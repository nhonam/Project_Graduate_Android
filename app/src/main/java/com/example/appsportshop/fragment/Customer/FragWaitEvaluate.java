package com.example.appsportshop.fragment.Customer;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;

import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.example.appsportshop.R;
import com.example.appsportshop.activity.Main_Customer;
import com.example.appsportshop.adapter.OrderEvalAdapter;
import com.example.appsportshop.api.APICallBack;
import com.example.appsportshop.api.OrderAPI;
import com.example.appsportshop.api.UserAPI;
import com.example.appsportshop.model.Cart;
import com.example.appsportshop.utils.CustomToast;
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
//                Log.d("id", String.valueOf(orderEvaluateList.get(i).getId()));
                showDialog(orderEvaluateList.get(i).getId_order_item(), orderEvaluateList.get(i).getUrlImage(), orderEvaluateList.get(i).getIdProduct());
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
                orderEvalAdapter = new OrderEvalAdapter(getContext(), R.layout.row_order_eval, list);
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


                    Cart cartTemp = new Cart();

                    cartTemp.setId_order_item(cartTmpObj.getLong("id_order_item"));
                    cartTemp.setId(cartTmpObj.getLong("id_order"));
                    cartTemp.setQuantity(cartTmpObj.getInt("quantity"));
                    cartTemp.setPrice_total(cartTmpObj.getLong("price"));
                    cartTemp.setUrlImage(cartTmpObj.getString("image_url"));
                    cartTemp.setNameProduct(cartTmpObj.getString("product_name"));
                    cartTemp.setIdProduct(cartTmpObj.getString("id_product"));
                    cartTemp.setId_order_status(cartTmpObj.getLong("id_order_status"));

                    orderEvaluateList.add(cartTemp);

                }
                try {
                    if (orderEvaluateList.size()==0 || orderEvaluateList == null || orderEvaluateList.isEmpty()){
                        showViewNotList();

                    }else
                    { listViewOrderEval.setVisibility(View.VISIBLE);
                        exsitOrder.setVisibility(View.GONE);
                        searchView.setVisibility(View.VISIBLE);
                        notItemOrder.setVisibility(View.GONE);
                        orderEvalAdapter = new OrderEvalAdapter(getContext(), R.layout.row_order_eval, orderEvaluateList);
                        listViewOrderEval.setAdapter(orderEvalAdapter);
                    }
                }catch (Exception e) {
                    showViewNotList();
                }



            }

            @Override
            public void onError(VolleyError error) {

            }
        });
    }

    //show view khi ko có sản phẩm nào đã mua mà chưa được đánh giá
    private void showViewNotList(){
        exsitOrder.setVisibility(View.VISIBLE);
        Glide.with(getContext()).load("https://res.cloudinary.com/dzljztsyy/image/upload/v1700463449/shop_sport/avatart%20default/vyipv8h4fjgwheq2f37i.jpg").into(notItemOrder);
        searchView.setVisibility(View.GONE);
        notItemOrder.setVisibility(View.VISIBLE);
        listViewOrderEval.setVisibility(View.GONE);
    }

    private void showDialog(long idOrderItem, String imageProduct, String idProduct) {
        Dialog dialog = new Dialog(getContext());

        dialog.setContentView(R.layout.evaluate_comment);

        TextView btnSent = dialog.findViewById(R.id.sent_eval);
        EditText comment = dialog.findViewById(R.id.cmt_evaluate);

        ImageView avtProduct = dialog.findViewById(R.id.avt_evaluate);
        RatingBar ratingBar = dialog.findViewById(R.id.rating_evaluate);
        final int[] rate = {1};

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                rate[0] = (int) v;
            }
        });


        Glide.with(getContext()).load(imageProduct).into(avtProduct);

        btnSent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Call api xóa
                JSONObject postData = new JSONObject();
                try {
                    postData.put("comment",comment.getText().toString().trim() );
                    postData.put("star", rate[0]  );
                    Log.d("start", String.valueOf(ratingBar.getNumStars()));
                    postData.put("id_user",singletonUser.getIdUser() );
                    postData.put("id_product",idProduct );
                    postData.put("id_order_item",idOrderItem );

                    UserAPI.ApiPostandBody(getContext(), Utils.BASE_URL + "evaluate-management/evaluates", postData, new APICallBack() {
                        @Override
                        public void onSuccess(JSONObject response) throws JSONException {
                            if (response.getInt("status")== 200){
                                CustomToast.makeText(getContext(), "Đánh giá thành công, Cảm ơn bạn đã đánh giá!", CustomToast.LENGTH_SHORT, CustomToast.SUCCESS, true).show();

                                orderEvalAdapter.notifyDataSetChanged();
                                dialog.dismiss();
                            }

                        }

                        @Override
                        public void onError(VolleyError error) {
                            CustomToast.makeText(getContext(), "Xem lại kết nối Internet !", CustomToast.LENGTH_SHORT, CustomToast.WARNING, true).show();
                            dialog.dismiss();

                        }
                    });
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }


                dialog.dismiss();
            }
        });

        dialog.show();
    }



}
