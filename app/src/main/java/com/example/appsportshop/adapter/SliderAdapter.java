package com.example.appsportshop.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.appsportshop.R;
import com.example.appsportshop.activity.ProductDetail;
import com.example.appsportshop.model.Banner;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.Holder> {

    Context myContextl;
    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    List<Banner> bannerArrayList ;

    public SliderAdapter(List<Banner> bannerArrayList, Context context){
        this.bannerArrayList = bannerArrayList;
        this.myContextl = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item, parent, false);


        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder viewHolder, int position) {

        Banner banner = bannerArrayList.get(position);

        Glide.with(viewHolder.imageView).load(bannerArrayList.get(position).getUrl_image()).error(R.drawable.error_load_image).into(viewHolder.imageView);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(myContextl, ProductDetail.class);
                intent.putExtra("idProduct", String.valueOf(banner.getIdProduct()));
                myContextl.startActivity(intent);

            }
        });
    }

    @Override
    public int getCount() {
        return 5;
    }

    public class Holder extends ViewHolder {

        ImageView imageView;

        public  Holder(View view) {
                super(view);
                imageView = view.findViewById(R.id.item_slider);
        }

    }
}
