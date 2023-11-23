package com.example.appsportshop.fragment.Customer;

import android.app.Dialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.example.appsportshop.R;
import com.example.appsportshop.activity.ProductDetail;
import com.example.appsportshop.adapter.MessageAdapter;
import com.example.appsportshop.adapter.ProductLatestAdapter;
import com.example.appsportshop.api.APICallBack;
import com.example.appsportshop.api.ProductAPI;
import com.example.appsportshop.api.UserAPI;
import com.example.appsportshop.model.Message;
import com.example.appsportshop.utils.CustomToast;
import com.example.appsportshop.utils.ObjectWrapperForBinder;
import com.example.appsportshop.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FragSearch extends Fragment {



    List<Message> messageList;

    GridView gr_productList;
    JSONArray listProduct = new JSONArray();
    List<String> nameProductList = new ArrayList<String>();

    List<Double> priceProductList = new ArrayList<Double>();

    Button bestsell,btnLatest;

    List<String> urlProductList = new ArrayList<String>();
    ProductLatestAdapter latestProduct_test;

    MessageAdapter messageAdapter;
    EditText edtSearch;
    ImageView chatSpBtn;
    private void Mapping(View view) {
        gr_productList = view.findViewById(R.id.search_list);
        edtSearch = view.findViewById(R.id.edtsearch_product);
        bestsell = view.findViewById(R.id.bestsell);
        btnLatest = view.findViewById(R.id.latest);
        chatSpBtn = view.findViewById(R.id.chat_sp);


    }





    private OnBackPressedCallback callback;

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
        View view = inflater.inflate(R.layout.frag_search, container, false);
        //lấy dữ liệu đc gửi từ trang Main
        Mapping(view);
        nameProductList.clear();
        priceProductList.clear();
        urlProductList.clear();

        try {
            getAllProduct();
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return view;

    }

    private void getAllProduct() throws JSONException {
        ProductAPI.GetProductByCategory(getContext(), Utils.BASE_URL + "product/byText?text="+edtSearch.getText(), new APICallBack() {

            @Override
            public void onSuccess(JSONObject response) {
                try {
                    nameProductList.clear();
                    priceProductList.clear();
                    urlProductList.clear();

                    listProduct = response.getJSONArray("data");

                    JSONObject productTmp;
                    String urlImgTmp = "";
                    for (int i = 0; i < listProduct.length(); i++) {




                        productTmp = (JSONObject) listProduct.get(i);
                        nameProductList.add((String) productTmp.get("productName"));
                        urlImgTmp = (String) productTmp.get("imageUrl");
                        priceProductList.add((productTmp.getDouble("price")));
                        urlProductList.add(urlImgTmp);
                        //                                System.out.println(urlImgTmp);

                    }
                    setAdapter();
                    setEvent();

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            }

            @Override
            public void onError(VolleyError error) {

            }
        });

    }


    private void setAdapter() {
        latestProduct_test = new ProductLatestAdapter(getContext(), nameProductList, priceProductList, urlProductList);
        gr_productList.setAdapter(latestProduct_test);
    }
    private void setEvent() {
        //click item product
        gr_productList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String id = "";
                try {
                    final Object objReceived = listProduct.get(i);
                    JSONObject productObj = (JSONObject) objReceived;
                    id = productObj.getString("id");
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                Intent intent = new Intent(getContext(), ProductDetail.class);


                intent.putExtra("idProduct", id);

                startActivity(intent);
            }
        });

        btnLatest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    getAllProduct();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        bestsell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ProductAPI.GetProductByCategory(getContext(), Utils.BASE_URL + "product/best_sell", new APICallBack() {

                        @Override
                        public void onSuccess(JSONObject response) {
                            try {
                                nameProductList.clear();
                                priceProductList.clear();
                                urlProductList.clear();

                                listProduct = response.getJSONArray("data");

                                JSONObject productTmp;
                                String urlImgTmp = "";
                                for (int i = 0; i < listProduct.length(); i++) {

                                    productTmp = (JSONObject) listProduct.get(i);
                                    nameProductList.add((String) productTmp.get("productName"));
                                    urlImgTmp = (String) productTmp.get("imageUrl");
                                    priceProductList.add((productTmp.getDouble("price")));
                                    urlProductList.add(urlImgTmp);
                                    //                                System.out.println(urlImgTmp);

                                }
                                setAdapter();
                                setEvent();

                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }

                        }

                        @Override
                        public void onError(VolleyError error) {

                        }
                    });
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        edtSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    nameProductList.clear();
                    priceProductList.clear();
                    urlProductList.clear();
                    ProductAPI.GetProductByCategory(getContext(), Utils.BASE_URL + "product/byText?text="+edtSearch.getText(), new APICallBack() {

                        @Override
                        public void onSuccess(JSONObject response) {
                            try {
                                nameProductList.clear();
                                priceProductList.clear();
                                urlProductList.clear();

                                listProduct = response.getJSONArray("data");

                                JSONObject productTmp;
                                String urlImgTmp = "";
                                for (int i = 0; i < listProduct.length(); i++) {




                                    productTmp = (JSONObject) listProduct.get(i);
                                    nameProductList.add((String) productTmp.get("productName"));
                                    urlImgTmp = (String) productTmp.get("imageUrl");
                                    priceProductList.add((productTmp.getDouble("price")));
                                    urlProductList.add(urlImgTmp);
                                    //                                System.out.println(urlImgTmp);

                                }
                                setAdapter();
                                setEvent();

                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }

                        }

                        @Override
                        public void onError(VolleyError error) {

                        }
                    });
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        chatSpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }


    private void showDialog() {
        Dialog dialog = new Dialog(getContext());

        dialog.setContentView(R.layout.chat_bot);
        ListView messagesListView;
        EditText edtChat = dialog.findViewById(R.id.edt_chat);
        messagesListView = dialog.findViewById(R.id.messages_view);
        ImageButton btnSent = dialog.findViewById(R.id.btn_sent);


        messageList = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            Message message = new Message();
            message.setText("bạn cos muon mua ao khong"+i);
            message.setFullname("Shop Nho Nam"+i);
            message.setAvatar_url("https://res.cloudinary.com/dzljztsyy/image/upload/v1700707731/shop_sport/avatart%20default/3531a97a-613d-47f5-8e6a-5fa6f780a2fa_q1jgan.png");
            if (i%2==0){
                message.setSenter(true);
            }else
                message.setSenter(false);
            messageList.add(message);
        }


        messageAdapter = new MessageAdapter(getContext(), messageList);
        messagesListView.setAdapter(messageAdapter);
        messagesListView.setSelection(messageAdapter.getCount() - 1);

        btnSent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Message message = new Message();
                message.setText(edtChat.getText().toString().trim());
                message.setFullname("đinh nho nam");
                message.setSenter(true);
//                message.setAvatar_url("https://res.cloudinary.com/dzljztsyy/image/upload/v1700707731/shop_sport/avatart%20default/3531a97a-613d-47f5-8e6a-5fa6f780a2fa_q1jgan.png");
                messageList.add(message);
                messageAdapter = new MessageAdapter(getContext(), messageList);
                messagesListView.setAdapter(messageAdapter);
                messageAdapter.notifyDataSetChanged();

                // Scroll to the last item
                messagesListView.setSelection(messageAdapter.getCount() - 1);

                edtChat.getText().clear();
            }
        });

        dialog.show();



    }

    private void startAutoScroll() {

    }



}