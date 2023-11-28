package com.example.appsportshop.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.appsportshop.R;
import com.example.appsportshop.model.HoaDon;
import com.example.appsportshop.model.Order;
import com.example.appsportshop.model.OrderItem;

import java.util.ArrayList;

public class ItemOrderAdapter extends ArrayAdapter<HoaDon> {
    Context myContext;
    int myLayout;
    ArrayList<OrderItem> data;


    public ItemOrderAdapter(@NonNull Context context, int resource, @NonNull ArrayList<OrderItem> listOrder) {
        super(context, resource);
        this.myContext = context;
        this.myLayout = resource;
        this.data = listOrder;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ItemOrderAdapter.ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(myContext).inflate(myLayout, null);
            viewHolder = new ItemOrderAdapter.ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ItemOrderAdapter.ViewHolder) convertView.getTag();
        }
        OrderItem orderItem = data.get(position);

//        viewHolder.tvGiaSP.setText(order.getPrice());
        viewHolder.tvGiaSP.setText(String.format("%.0f", orderItem.getPrice()));
        viewHolder.tvSoluong.setText(String.valueOf(orderItem.getQuantity()));
        viewHolder.tvTenSp.setText(orderItem.getProductName());
        Glide
                .with(viewHolder.imageProduct)
                .load(orderItem.getImage_url())
                .centerCrop()
                .placeholder(R.drawable.error_load_image)
                .into(viewHolder.imageProduct);

        return convertView;

    }

//    @Override
//    public Filter getFilter() {
//        return new Filter() {
//
//            @Override
//            protected FilterResults performFiltering(CharSequence charSequence) {
//                String searchStr = charSequence.toString();
//                if (searchStr.isEmpty()) {
//                    data_tmp = data;
//                } else {
//                    ArrayList<HoaDon> list = new ArrayList<>();
//                    for (HoaDon order : data
//                    ) {
//
//                        if (order.getId_Order().toLowerCase().contains(searchStr.toLowerCase()) ||order.getNameReciver().toLowerCase().contains(searchStr.toLowerCase()) || order.getSdt().toLowerCase().contains(searchStr.toLowerCase())) {
//                            list.add(order);
//                        }
//                    }
//                    data_tmp = list;
//                }
//
//                FilterResults filterResults = new FilterResults();
//                filterResults.values = data_tmp;
//                return filterResults;
//            }
//
//            @Override
//            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
//                data = (ArrayList<HoaDon>) filterResults.values;
//                notifyDataSetChanged();
//            }
//        };
//
//
//    }

    private class ViewHolder {

        TextView tvTenSp, tvGiaSP, tvSoluong;
        ImageView imageProduct;
        public ViewHolder(View view) {
            tvTenSp = view.findViewById(R.id.tensp);
            tvGiaSP = view.findViewById(R.id.giasp);
            tvSoluong = view.findViewById(R.id.soluongsp);
            imageProduct = view.findViewById(R.id.image_product);

        }
    }

}

