package com.example.appsportshop.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.appsportshop.R;
import com.example.appsportshop.model.Message;

import java.util.List;


public class MessageAdapter extends BaseAdapter {

    List<Message> messages ;
    Context context;

    public MessageAdapter(Context context, List<Message> list) {
        this.messages = list;
        this.context = context;
    }


    public void add(Message message) {
        this.messages.add(message);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int i) {
        return messages.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        MessageViewHolder holder = new MessageViewHolder();
        LayoutInflater messageInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        Message message = messages.get(i);

        if (message.isSenter()) {
            convertView = messageInflater.inflate(R.layout.my_message, null);
            holder.messageBody = (TextView) convertView.findViewById(R.id.message_body);
            convertView.setTag(holder);
            holder.messageBody.setText(message.getText());
        } else {
            convertView = messageInflater.inflate(R.layout.their_message, null);

            holder.messageBody = (TextView) convertView.findViewById(R.id.message_body);
            convertView.setTag(holder);


            holder.product_tar = (LinearLayout) convertView.findViewById(R.id.product_tar);
            holder.product_tar.setVisibility(View.GONE);




            holder.messageBody.setText(message.getText());
            if (message.getImage_product()!=null || message.getImage_product()!="")
            {
                holder.product_tar.setVisibility(View.VISIBLE);
                holder.productName = (TextView) convertView.findViewById(R.id.product_tar_name);
                holder.imageProduct = (ImageView) convertView.findViewById(R.id.img_product_tar);

                holder.productName.setVisibility(View.VISIBLE);
                holder.productName.setText(message.getProduct_name());


                holder.imageProduct.setVisibility(View.VISIBLE);
                Glide.with(holder.imageProduct ).load(message.getImage_product()).into(holder.imageProduct);

            }
//            GradientDrawable drawable = (GradientDrawable) holder.avatar.getBackground();
//            drawable.setColor(Color.parseColor();
        }

        return convertView;
    }

}

class MessageViewHolder {
    public ImageView imageProduct;
    public TextView productName;

    LinearLayout product_tar;
    public TextView messageBody;
}
