package com.example.appsportshop.adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

public class OrderEvalAdapter extends ArrayAdapter<Cart>   {
    Context myContext;
    int myLayout;


    ArrayList<Cart> listCart ;



    public OrderEvalAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Cart> listCart) {
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



        return view;
    }




    private class ViewHolder {

        TextView  txtProductName, txtPrice, txtQuanti, Madon;

        ImageView ImgCart;




        public ViewHolder(View view) {
            Madon = view.findViewById(R.id.MadonEval);
            txtProductName = view.findViewById(R.id.name_product_eval);
            txtPrice = view.findViewById(R.id.priceOrderEval);
            txtQuanti = view.findViewById(R.id.quantiOrderEval);
            ImgCart = view.findViewById(R.id.imgOrderEval);


        }

    }

}
