package com.example.appsportshop.fragment.Customer;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;

import com.android.volley.VolleyError;
import com.example.appsportshop.R;
import com.example.appsportshop.activity.ProductDetail;
import com.example.appsportshop.adapter.MessageAdapter;
import com.example.appsportshop.adapter.ProductLatestAdapter;
import com.example.appsportshop.api.APICallBack;
import com.example.appsportshop.api.APICommon;
import com.example.appsportshop.api.ProductAPI;
import com.example.appsportshop.model.Message;
import com.example.appsportshop.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FragSearch extends Fragment {



    List<Message> messageList;
    long id_product_search = 0;
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

        Message message = new Message();
        message.setText("Nhập thông tin sản phẩm bạn muốn mua chúng tôi sẽ gợi ý sản phẩm phù hợp với nhu cầu của bạn");
        message.setFullname("Shop NHO NAM");
        message.setSenter(false);
        messageList.add(message);



        messageAdapter = new MessageAdapter(getContext(), messageList);
        messagesListView.setAdapter(messageAdapter);
        messagesListView.setSelection(messageAdapter.getCount() - 1);


        clickItemProduct(messagesListView);

        btnSent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Message message = new Message();
//                message.setText(edtChat.getText().toString().trim());
//                message.setFullname("đinh nho nam");
//                message.setSenter(true);
////                message.setAvatar_url("https://res.cloudinary.com/dzljztsyy/image/upload/v1700707731/shop_sport/avatart%20default/3531a97a-613d-47f5-8e6a-5fa6f780a2fa_q1jgan.png");
//                messageList.add(message);
//                messageAdapter = new MessageAdapter(getContext(), messageList);
//                messagesListView.setAdapter(messageAdapter);
//                messageAdapter.notifyDataSetChanged();
//
//                // Scroll to the last item
//                messagesListView.setSelection(messageAdapter.getCount() - 1);

                try {
                    CallAPIChat( );
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }


            }



            private void CallAPIChat() throws JSONException {
                JSONObject body = new JSONObject();
                body.put("question", edtChat.getText().toString().trim());
                APICommon.APIPostWithOutJWT(requireContext(), Utils.URL_CHAT, body, new APICallBack() {
                    @Override
                    public void onSuccess(JSONObject response) throws JSONException {
                        Message message = new Message();

                        Log.d("nam", response.toString());
                        String sanpham = response.getString("result");

                        if (sanpham.equalsIgnoreCase("Giày đá bóng")) {
                            ApiGetInfoProduct(sanpham);

                        }else if (sanpham.equalsIgnoreCase("Vợt cầu lông")){

                            ApiGetInfoProduct(sanpham);
                        }else if (sanpham.equalsIgnoreCase("Kính bơi")){
                            ApiGetInfoProduct(sanpham);
                        }else {
                            if (sanpham.equalsIgnoreCase("Bạn vui lòng mô tả chi tiết hơn ?")) {
                                message.setSenter(false);
                                message.setText("Bạn vui lòng mô tả chi tiết hơn ?");
//                                message.setImage_product("https://res.cloudinary.com/dzljztsyy/image/upload/v1700707731/shop_sport/avatart%20default/3531a97a-613d-47f5-8e6a-5fa6f780a2fa_q1jgan.png");
                                message.setProduct_name("");

                                messageList.add(message);
                                messageAdapter = new MessageAdapter(getContext(), messageList);
                                messagesListView.setAdapter(messageAdapter);
                                messageAdapter.notifyDataSetChanged();

                                // Scroll to the last item
                                messagesListView.setSelection(messageAdapter.getCount() - 1);
                                edtChat.getText().clear();

                            }
                        }


                    }

                    @Override
                    public void onError(VolleyError error) {

                    }
                });
            }

            private void ApiGetInfoProduct(String productName) throws JSONException {

                APICommon.APIGetWithOutJWT(requireContext(), "product/find-by-name/" + productName, new APICallBack() {
                    @Override
                    public void onSuccess(JSONObject response) throws JSONException {
                        Log.d("nam111",response.toString());

                        JSONObject data = response.getJSONObject("data");

                        id_product_search =data.getLong("id");
                        Log.d("nhonam", String.valueOf(id_product_search));
                        message.setSenter(false);
                        message.setText("Sản phẩm này có thể phù hợp với nhu cầu của bạn ");
                        message.setImage_product(data.getString("imageUrl"));
                        message.setProduct_name(data.getString("productName"));
                        messageList.add(message);
//                        messageAdapter = new MessageAdapter(getContext(), messageList);
//                        messagesListView.setAdapter(messageAdapter);
                        messageAdapter.notifyDataSetChanged();

                        // Scroll to the last item
                        messagesListView.setSelection(messageAdapter.getCount() - 1);
                        edtChat.getText().clear();

                    }

                    @Override
                    public void onError(VolleyError error) {

                    }
                });
            }


        });

        dialog.show();


    }

    private void SearchSanPham(String sanPham) {


    }

    private void clickItemProduct(ListView listView){

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

//                Log.d("nam",  messageList.get(i).getProduct_name());
                Log.d("nhonam", String.valueOf(id_product_search));

                if (messageList.get(i).getProduct_name()!="" && messageList.get(i).getProduct_name()!=null ){
                    Intent intent = new Intent(getActivity(), ProductDetail.class);
                    intent.putExtra("idProduct", String.valueOf(id_product_search));
//                OrderItem.isChose = true;
//                intent.putExtra("tongTien",tongTien.getText().toString());
                    getActivity().startActivity(intent);
                }




            }
        });

    }



}