package com.example.appsportshop.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.example.appsportshop.R;
import com.example.appsportshop.api.APICallBack;
import com.example.appsportshop.api.UserAPI;
import com.example.appsportshop.fragment.Customer.MainOrder;
import com.example.appsportshop.model.Cart;
import com.example.appsportshop.utils.CustomToast;
import com.example.appsportshop.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class OrderAdapter extends ArrayAdapter<Cart> {
    Context myContext;
    int myLayout;

    ArrayList<Cart> listCart ;



    public OrderAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Cart> listCart) {
        super(context, resource, listCart);
        this.myContext = context;
        this.myLayout = resource;
        this.listCart = listCart;
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
//        System.out.println(cart.getQuantity()+"nânnanana");

        viewHolder.txtProductName.setText(cart.getNameProduct());
        viewHolder.txtQuanti.setText(String.valueOf(cart.getQuantity()));
        DecimalFormat formatter = new DecimalFormat("#,###");
        String formattedValue = formatter.format( Double.valueOf(String.format("%.0f", cart.getPrice_total())));
        viewHolder.txtPrice.setText(formattedValue +" VND");
        viewHolder.Madon.setText("  Mã Đơn Hàng: "+cart.getId());

        Glide.with(myContext).load(cart.getUrlImage()).into(viewHolder.ImgCart);
        //set trạng thái
        long idOrder = cart.getId_order_status();
        if (idOrder==1){
            viewHolder.proccess_status.setVisibility(View.VISIBLE);
        }else   viewHolder.proccess_status.setVisibility(View.GONE);

        if (idOrder==2){
            viewHolder.comfirm.setVisibility(View.VISIBLE);
        }else viewHolder.comfirm.setVisibility(View.GONE);

        if (idOrder==3){
            viewHolder.shipping.setVisibility(View.VISIBLE);
        }else viewHolder.shipping.setVisibility(View.GONE);

        if (idOrder==4){
            viewHolder.shipped.setVisibility(View.VISIBLE);
        }else  viewHolder.shipped.setVisibility(View.GONE);

        if (idOrder==5){
            viewHolder.cancel.setVisibility(View.VISIBLE);
        }else  viewHolder.cancel.setVisibility(View.GONE);




        if (cart.getId_order_status()!=1) {
            viewHolder.huyDon.setVisibility(View.GONE);
        }else {
            viewHolder.huyDon.setVisibility(View.VISIBLE);
            viewHolder.huyDon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickCancel(cart.getId());
                }
            });
        }





        return view;
    }

    private void clickCancel(long idOrder) {
        Dialog dialog = new Dialog(myContext);

        dialog.setContentView(R.layout.alert_yes_no);

        Button btnYes = dialog.findViewById(R.id.YES);
        TextView txt_popup_title= dialog.findViewById(R.id.txt_popup_title);
        txt_popup_title.setText("HỦY BỎ ĐƠN HÀNG");
        TextView txt_popup_content = dialog.findViewById(R.id.txt_popup_content);
        txt_popup_content.setText("Bạn có chắc muốn hủy đơn hàng !!!");
        Button btnNo = dialog.findViewById(R.id.NO);


        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Call api xóa
                try {
                    UserAPI.ApiGet(getContext(), Utils.BASE_URL + "order/cancel-order/" + idOrder, new APICallBack() {
                        @Override
                        public void onSuccess(JSONObject response) throws JSONException {
                            if (response.getLong("data") == 1) {
                                dialog.dismiss();


                                CustomToast.makeText(myContext, "Hủy đơn đặt hàng thành công !", CustomToast.LENGTH_SHORT, CustomToast.SUCCESS, true).show();
                                myContext.startActivity(new Intent( myContext.getApplicationContext(), MainOrder.class));

                            }else {
                                dialog.dismiss();
                                CustomToast.makeText(myContext, "Hủy đơn đặt hàng không thành công !", CustomToast.LENGTH_SHORT, CustomToast.ERROR, true).show();

                            }

                        }

                        @Override
                        public void onError(VolleyError error) {
//                            CustomToast.makeText(myContext, "Hủy đơn đặt hàng không thành công !", CustomToast.LENGTH_SHORT, CustomToast.ERROR, true).show();
                            dialog.dismiss();

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

    private class ViewHolder {

        TextView txtShopName, txtProductName, txtPrice, huyDon, txtQuanti, Madon;
        View proccess_status, comfirm, shipping, shipped, cancel;

        ImageView ImgCart;




        public ViewHolder(View view) {
            txtShopName = view.findViewById(R.id.nameShopOrder);
            huyDon = view.findViewById(R.id.Huydon);
            Madon = view.findViewById(R.id.Madon);
            txtProductName = view.findViewById(R.id.nameProductOrder);
            txtPrice = view.findViewById(R.id.priceOrder);
            txtQuanti = view.findViewById(R.id.quantiOrder);
            ImgCart = view.findViewById(R.id.imgOrder);

            proccess_status = view.findViewById(R.id.proccess_status);
            comfirm = view.findViewById(R.id.confirm_status);
            shipping = view.findViewById(R.id.shipping_status);
            shipped = view.findViewById(R.id.shipped_status);
            cancel = view.findViewById(R.id.cancel_status);

        }

    }

}
