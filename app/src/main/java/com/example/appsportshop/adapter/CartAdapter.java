package com.example.appsportshop.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.example.appsportshop.R;
import com.example.appsportshop.activity.ProductDetail;
import com.example.appsportshop.api.APICallBack;
import com.example.appsportshop.api.CartAPI;
import com.example.appsportshop.fragment.Customer.FragCart;
import com.example.appsportshop.model.Cart;
import com.example.appsportshop.utils.CustomToast;
import com.example.appsportshop.utils.Utils;


import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CartAdapter extends ArrayAdapter<Cart> {
    Context myContext;
    int myLayout;
    int quantiCart_chang_item =0;
    ArrayList<Cart> listCart ;
    public static Double  sumCart=0.0;
    DecimalFormat formatter = new DecimalFormat("#,###");
    ArrayList<Cart> listCartTmp = new ArrayList<Cart>();


    public CartAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Cart> listCart) {
        super(context, resource, listCart);
        this.myContext = context;
        sumCart=0.0;
        this.myLayout = resource;
        this.listCart = listCart;
        this.listCartTmp.addAll(listCart);
    }

    private void clickDeleteItem(long idCartItem, int i) {
        Dialog dialog = new Dialog(getContext());

        dialog.setContentView(R.layout.alert_yes_no);

        Button btnYes = dialog.findViewById(R.id.YES);
        Button btnNo = dialog.findViewById(R.id.NO);


        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Call api xóa
                try {
                    CartAPI.DeleteCart(getContext().getApplicationContext(), Utils.BASE_URL + "cart-management/"+ idCartItem, new APICallBack() {
                        @Override
                        public void onSuccess(JSONObject response) throws JSONException {
                            CustomToast.makeText(getContext(), "Xóa Sản Phẩm Thành Công", CustomToast.LENGTH_SHORT, CustomToast.SUCCESS, true).show();
                            notifyDataSetChanged();
                            dialog.dismiss();
                            listCart.remove(i);

                        }

                        @Override
                        public void onError(VolleyError error) {
                            CustomToast.makeText(getContext(), "Xóa Sản Phẩm Không Thành Công", CustomToast.LENGTH_SHORT, CustomToast.ERROR, true).show();
                        }
                    });
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                dialog.dismiss();
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        dialog.show();
    }

    private void clickQuantity(long idCartItem, int i) {
        quantiCart_chang_item = listCart.get(i).getQuantity();
        Dialog dialog = new Dialog(getContext());

        dialog.setContentView(R.layout.incre_reduce_quanti);

        Button btnYes = dialog.findViewById(R.id.YES_cart);
        Button btnNo = dialog.findViewById(R.id.NO_cart);
        TextView btnreduce,btnIncrease, quantiTiDialog;
        btnreduce = dialog.findViewById(R.id.reduce_cart);
        btnIncrease = dialog.findViewById(R.id.increase_cart);
        quantiTiDialog = dialog.findViewById(R.id.quantity_in_Cart);

        quantiTiDialog.setText( String.valueOf(listCart.get(i).getQuantity()));

        btnreduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int quantity = Integer.parseInt(quantiTiDialog.getText().toString()) - 1;
                if (quantity <= 0) {
                    CustomToast.makeText(getContext(), "Vui Lòng Chọn Số Lượng Lớn Hơn 0 !!!", CustomToast.LENGTH_LONG, CustomToast.ERROR, true).show();
                    quantiTiDialog.setText("1");
                } else {
                    quantiTiDialog.setText(String.valueOf(quantity));
                }
                quantiCart_chang_item = Integer.parseInt(quantiTiDialog.getText().toString());


            }
        });

        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity = Integer.parseInt(quantiTiDialog.getText().toString()) + 1;
                quantiTiDialog.setText(String.valueOf(quantity));

                quantiCart_chang_item = Integer.parseInt(quantiTiDialog.getText().toString());
            }
        });

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Call api xóa
                try {
                    CartAPI.DeleteCart(getContext().getApplicationContext(), Utils.BASE_URL + "cart-management/"+ idCartItem, new APICallBack() {
                        @Override
                        public void onSuccess(JSONObject response) throws JSONException {

                            for (int j = 0; j < listCart.size(); j++) {
                                if (listCart.get(i).getId()==idCartItem ){
                                    listCart.get(i).setPrice_total( ( listCart.get(i).getPrice_total() /  listCart.get(i).getQuantity() ) * quantiCart_chang_item);
                                    listCart.get(i).setQuantity(quantiCart_chang_item);

                                }
                            }


//                            CustomToast.makeText(getContext(), "thêm số lượng Thành Công", CustomToast.LENGTH_SHORT, CustomToast.SUCCESS, true).show();
                            notifyDataSetChanged();
                            dialog.dismiss();
//                            listCart.remove(i);

                        }

                        @Override
                        public void onError(VolleyError error) {
//                            CustomToast.makeText(getContext(), "Xóa Sản Phẩm Không Thành Công", CustomToast.LENGTH_SHORT, CustomToast.ERROR, true).show();
                        }
                    });
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                dialog.dismiss();
            }
        });
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        dialog.show();
    }

    private Boolean checkAll(){
        int j =0;
        int len = listCart.size();
        for (int i = 0; i < len; i++) {
            if(listCart.get(i).getSelected()){
                j++;
            }
        }

        if (j==len)
            return true;
        return false;
    }

    @Override
    public View getView(int i, @Nullable View view,@NonNull ViewGroup viewGroup) {


        ViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(myContext).inflate(myLayout, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Cart cart = listCart.get(i);
        viewHolder.txtProductName.setText(cart.getNameProduct());
        viewHolder.txtQuanti.setText("x"+ String.valueOf(cart.getQuantity()));
//        viewHolder.txtShopName.setText(cart.getShopName());

        String formattedValue = formatter.format( Double.valueOf(String.format("%.0f", cart.getPrice_total())));

        viewHolder.txtPrice.setText(formattedValue +" VND");


//        viewHolder.txtPrice.setText(String.format("%.0f", cart.getPrice_total()) +" VND");
        Glide.with(myContext).load(cart.getUrlImage()).into(viewHolder.ImgCart);



        if(cart.getSelected()) {
            viewHolder.checkBox.setChecked(true);
        }

        else{
            viewHolder.checkBox.setChecked(false);

        }

        viewHolder.txtQuanti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickQuantity(cart.getId(),i);
            }
        });


        viewHolder.Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cart.getSelected())
                    sumCart-=cart.getPrice_total();
                clickDeleteItem(cart.getId(), i);

                notifyDataSetChanged();

            }
        });




        viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                cart.setSelected(b);

                if(checkAll()){
                    FragCart.cbCheckAll.setChecked(true);
                    String formattedValue = formatter.format( Double.valueOf(String.format("%.0f", sumCart)));
                    FragCart.tongTien.setText( formattedValue+" VND");
                }else {
                    FragCart.cbCheckAll.setChecked(false);
                    String formattedValue = formatter.format( Double.valueOf(String.format("%.0f", sumCart)));
                    FragCart.tongTien.setText( formattedValue+" VND");
                }
                if(cart.getSelected()){
                    sumCart += cart.getPrice_total();
                } else if (!cart.getSelected()) {
                    sumCart -= cart.getPrice_total();
                }

                String formattedValue = formatter.format( Double.valueOf(String.format("%.0f",sumCart)));
                FragCart.tongTien.setText( formattedValue+" VND");
//                System.out.println(sumCart);

            }
        });
        return view;
    }

    private class ViewHolder {

        TextView txtShopName, txtProductName, txtPrice, Delete, txtQuanti;
//        TextView edtQuantity;
        public   CheckBox checkBox;
        ImageView ImgCart;




        public ViewHolder(View view) {
            txtShopName = view.findViewById(R.id.nameShopCart);
            checkBox = view.findViewById(R.id.checkCart);
            txtProductName = view.findViewById(R.id.nameProductCart);
            txtPrice = view.findViewById(R.id.priceCart);
            txtQuanti = view.findViewById(R.id.quanti);
            ImgCart = view.findViewById(R.id.imgCart);
            Delete = view.findViewById(R.id.Delete);

        }

    }

    //    public  void searchSV(String query){
//        listCart.clear();
//        if(query==""){
//            listCart.addAll(listCartTmp);
//        }
//        for (Cart sv:listCartTmp) {
//            if(sv.getHoTen().contains(query))
//                data.add(sv);
//        }
//        notifyDataSetChanged();
//    }
    public  void XoaDuLieu(){
        listCartTmp.clear();
        listCartTmp.addAll(listCart);
        listCart.clear();
        for (Cart cart:listCartTmp ) {
            if(!cart.getSelected())
                listCart.add(cart);
        }
        notifyDataSetChanged();
        listCartTmp.clear();
        listCartTmp.addAll(listCart);
    }
    public void CheckAll(){

        for ( Cart sv:listCart      ) {
            sv.setSelected(true);

//            sumCart+=sv.getPrice();
        }
        notifyDataSetChanged();
    }

    public void UnCheckAll(){

        for ( Cart sv:listCart      ) {
            sv.setSelected(false);
        }
        notifyDataSetChanged();
    }
}
