package com.example.appsportshop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.example.appsportshop.R;
import com.example.appsportshop.model.Evaluate;

import java.util.ArrayList;

public class EvaluateAdapter extends ArrayAdapter<Evaluate> {
    Context myContext;
    int myLayout;


    ArrayList<Evaluate> listCart;


    public EvaluateAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Evaluate> listCart) {
        super(context, resource, listCart);
        this.myContext = context;
        this.myLayout = resource;
        this.listCart = listCart;
    }


    @Override
    public View getView(int i, @Nullable View view, @NonNull ViewGroup viewGroup) {


        ViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(myContext).inflate(myLayout, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        Evaluate cart = listCart.get(i);
//        System.out.println(cart.getQuantity()+"nânnanana");


        viewHolder.txtUser.setText(cart.getFullname());
        viewHolder.cmt.setText(String.valueOf(cart.getComment()));
        viewHolder.ratingBar.setRating(cart.getStar());

//        viewHolder.ImageUser.setImageResource(R.drawable.avatar_use_default);

        Glide.with(viewHolder.ImageUser)
                .load(cart.getImage_url())
                .error(R.drawable.avatar_use_default)
                .into(viewHolder.ImageUser);

        return view;
    }


    private class ViewHolder {

        TextView txtUser, cmt;

        ImageView ImageUser;

        RatingBar ratingBar;


        public ViewHolder(View view) {
            txtUser = view.findViewById(R.id.name_user_eval);
            cmt = view.findViewById(R.id.cmt_eval);
            ratingBar = view.findViewById(R.id.rating_eval);
            ImageUser = view.findViewById(R.id.avt_user_eval);


        }

    }

}
