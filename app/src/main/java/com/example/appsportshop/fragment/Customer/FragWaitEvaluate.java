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
import android.widget.SearchView;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;

import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.example.appsportshop.R;
import com.example.appsportshop.activity.Main_Customer;
import com.example.appsportshop.activity.ProductDetail;
import com.example.appsportshop.adapter.OrderAdapter;
import com.example.appsportshop.adapter.OrderEvalAdapter;
import com.example.appsportshop.api.APICallBack;
import com.example.appsportshop.api.OrderAPI;
import com.example.appsportshop.model.Cart;
import com.example.appsportshop.utils.SingletonUser;
import com.example.appsportshop.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

//Đánh giá sản phẩm ( những sản phẩm đã mua thành công nhưng chưa đánh giá )
public class FragWaitEvaluate extends Fragment {
    // danh sách sản phẩm đã mua nhưng chưa đánh giá
    public ArrayList<Cart> orderEvaluateList;
    ListView listViewOrderEval;

    OrderEvalAdapter orderEvalAdapter;
    ImageView btnReturn, notItemOrder;
    LinearLayout exsitOrder;
    SearchView searchView;


    SingletonUser singletonUser = SingletonUser.getInstance();
    private OnBackPressedCallback callback;

    private void mapping(View view) {
        listViewOrderEval = view.findViewById(R.id.listViewOrderEval);
        exsitOrder = view.findViewById(R.id.exitOrderEval);
        btnReturn = view.findViewById(R.id.returnOrderEval);
        notItemOrder = view.findViewById(R.id.notItemOrderEval);

        searchView = view.findViewById(R.id.search_order_eval);
        searchView.setQueryHint("Nhập vào thông sản phẩm để tìm kiếm");
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
        View view = inflater.inflate(R.layout.frag_evalution, container, false);
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


        listViewOrderEval.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String idProduct = orderEvaluateList.get(i).getIdProduct();
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


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
//                productManagerAdapter.getFilter().filter(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
//                productManagerAdapter.getFilter().filter(s);
                ArrayList<Cart> list = new ArrayList<>();
                for (Cart product : orderEvaluateList
                ) {

                    if (product.getNameProduct().toLowerCase().contains(s.toLowerCase()))  {
                        list.add(product);
                    }
                }
                orderEvalAdapter = new OrderEvalAdapter(getContext(), R.layout.row_order, list);
                listViewOrderEval.setAdapter(orderEvalAdapter);


                return false;
            }
        });
    }

    private void getOrderItemByIdUser() throws JSONException {

        OrderAPI.getOrderItemByUser(getContext(), Utils.BASE_URL + "order/not-evaluate/" + singletonUser.getIdUser(), new APICallBack() {
            @Override
            public void onSuccess(JSONObject response) throws JSONException {
                JSONArray listcartJSON = response.getJSONArray("data");
                orderEvaluateList = new ArrayList<>();
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

                    orderEvaluateList.add(cartTemp);

                }


                if (orderEvaluateList.size()==0){
                    exsitOrder.setVisibility(View.VISIBLE);
                    Glide.with(getContext()).load("https://res.cloudinary.com/dzljztsyy/image/upload/v1700463449/shop_sport/avatart%20default/vyipv8h4fjgwheq2f37i.jpg").into(notItemOrder);
                    searchView.setVisibility(View.GONE);
                    notItemOrder.setVisibility(View.VISIBLE);
                }else
                {
                    exsitOrder.setVisibility(View.GONE);
                    searchView.setVisibility(View.VISIBLE);
                    notItemOrder.setVisibility(View.GONE);
                    orderEvalAdapter = new OrderEvalAdapter(getContext(), R.layout.row_order, orderEvaluateList);
                    listViewOrderEval.setAdapter(orderEvalAdapter);
                }

            }

            @Override
            public void onError(VolleyError error) {

            }
        });
    }


}
