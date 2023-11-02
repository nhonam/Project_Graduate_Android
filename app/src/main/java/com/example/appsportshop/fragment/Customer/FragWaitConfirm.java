package com.example.appsportshop.fragment.Customer;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;

import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.example.appsportshop.R;
import com.example.appsportshop.activity.Main_Customer;
import com.example.appsportshop.activity.ProductDetail;
import com.example.appsportshop.adapter.OrderAdapter;
import com.example.appsportshop.api.APICallBack;
import com.example.appsportshop.api.OrderAPI;
import com.example.appsportshop.model.Cart;
import com.example.appsportshop.utils.SingletonUser;
import com.example.appsportshop.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

//đơn hàng chờ xác nhận
public class FragWaitConfirm extends Fragment {

 // danh sách sản phẩm trong đơn hàng chờ duyệt
    public ArrayList<Cart> orderWating;

    ListView listViewOrder;
    OrderAdapter orderAdapter;
    ImageView btnReturn, notItemOrder;
    LinearLayout exsitOrder;
    SingletonUser singletonUser = SingletonUser.getInstance();


    private OnBackPressedCallback callback;

    private void mapping(View view) {
        listViewOrder = view.findViewById(R.id.listViewWaitOrder);
        exsitOrder = view.findViewById(R.id.exsitOrderWait);
        btnReturn = view.findViewById(R.id.returnOrderWait);
        notItemOrder = view.findViewById(R.id.notItemOrderWait);


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Không thực hiện gì cả để vô hiệu hóa nút "Back" mặc định
            }
        };

        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        // Bỏ điều kiện ghi đè khi Fragment bị hủy
        callback.remove();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frag_wait_confirm, container, false);
        //lấy dữ liệu đc gửi từ trang Main

        mapping(view);

        try {
            getOrderItemByIdUser();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        setEvent();


        return view;
    }
    private void setEvent() {


        listViewOrder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String idProduct = orderWating.get(i).getIdProduct();
                Intent intent = new Intent(getContext(), ProductDetail.class);

                intent.putExtra("idProduct",idProduct);
//                OrderItem.isChose = true;
//                intent.putExtra("tongTien",tongTien.getText().toString());
                startActivity(intent);

            }
        });


        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragHome.isDispHomeCustommer= true;
                startActivity(new Intent(getContext(), Main_Customer.class));
            }
        });
    }
    private void getOrderItemByIdUser() throws JSONException {

        OrderAPI.getOrderItemByUser(getContext(), Utils.BASE_URL + "order/by-user/" + singletonUser.getIdUser(), new APICallBack() {
            @Override
            public void onSuccess(JSONObject response) throws JSONException {
                JSONArray listcartJSON = response.getJSONArray("data");
                orderWating = new ArrayList<>();
                for (int i = 0; i < listcartJSON.length(); i++) {
                    JSONObject cartTmpObj = (JSONObject) listcartJSON.get(i);
//

                    Cart cartTemp = new Cart();
                    cartTemp.setId(cartTmpObj.getLong("id_order"));
                    cartTemp.setQuantity(cartTmpObj.getInt("quantity"));
                    cartTemp.setPrice_total(cartTmpObj.getLong("price"));
                    cartTemp.setUrlImage(cartTmpObj.getString("image_url"));
                    cartTemp.setNameProduct(cartTmpObj.getString("product_name"));
                    cartTemp.setIdProduct(cartTmpObj.getString("id_product"));
                    cartTemp.setId_order_status(cartTmpObj.getLong("id_order_status"));


                    if (cartTemp.getId_order_status()==1)
                        orderWating.add(cartTemp);

                }
                exsitOrder.setVisibility(View.GONE);
                Glide.with(getContext()).load("http://res.cloudinary.com/dzljztsyy/image/upload/v1691631791/shop_sport/ae4f5d04-28b3-4cd0-aabb-0fe63bdcef37.jpg").into(notItemOrder);

                if (orderWating.size()==0){
                    exsitOrder.setVisibility(View.VISIBLE);
                }
                orderAdapter = new OrderAdapter(getContext(), R.layout.row_order, orderWating);
                listViewOrder.setAdapter(orderAdapter);
            }

            @Override
            public void onError(VolleyError error) {

            }
        });
    }
}
