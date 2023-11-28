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
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appsportshop.R;
import com.example.appsportshop.model.Evaluate;

import java.util.ArrayList;
import java.util.List;

public class EvaluateAdapter extends RecyclerView.Adapter<EvaluateAdapter.ViewHolder> {
    Context myContext;
    int myLayout;


    List<Evaluate> dataList;
    public EvaluateAdapter(List<Evaluate> dataList) {
        this.dataList =  dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_evaluate, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Evaluate cart = dataList.get(position);
//        System.out.println(cart.getQuantity()+"nânnanana");


        viewHolder.txtUser.setText(cart.getFullname());
        viewHolder.cmt.setText(String.valueOf(cart.getComment()));
        viewHolder.ratingBar.setRating(cart.getStar());

//        viewHolder.ImageUser.setImageResource(R.drawable.avatar_use_default);

        Glide.with(viewHolder.ImageUser)
                .load(cart.getImage_url())
                .error(R.drawable.avatar_use_default)
                .into(viewHolder.ImageUser);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtUser, cmt;

        ImageView ImageUser;

        RatingBar ratingBar;


        public ViewHolder(View view) {
            super(view);
            txtUser = view.findViewById(R.id.name_user_eval);
            cmt = view.findViewById(R.id.cmt_eval);
            ratingBar = view.findViewById(R.id.rating_eval);
            ImageUser = view.findViewById(R.id.avt_user_eval);


        }

    }

}
