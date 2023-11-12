package com.example.appsportshop.fragment.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.VolleyError;
import com.example.appsportshop.R;
import com.example.appsportshop.activity.ProductDetail;
import com.example.appsportshop.adapter.CategoryRCVAdapter;
import com.example.appsportshop.adapter.ProductLatestAdapter;
import com.example.appsportshop.adapter.SliderAdapter;
import com.example.appsportshop.api.APICallBack;
import com.example.appsportshop.api.APICommon;
import com.example.appsportshop.api.ProductAPI;
import com.example.appsportshop.model.Category;
import com.example.appsportshop.service.InternetConnect;
import com.example.appsportshop.utils.SingletonUser;
import com.example.appsportshop.utils.Utils;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FragHome extends Fragment {
    GridView gr_productList;
    RecyclerView rcvCategory;

    //Name Category Product
    List<Category> categoryList = new ArrayList<>();
    //get listproduct recive from api
    JSONArray listProduct = new JSONArray();
    List<String> nameProductList = new ArrayList<String>();
    List<Double> priceProductList = new ArrayList<Double>();
    List<String> urlProductList = new ArrayList<String>();
    CategoryRCVAdapter categoryRCVAdapter;
    ProductLatestAdapter latestProduct_test;
    SliderAdapter sliderAdapter;

    int[] imgSliders = {
            R.drawable.giamgia1,
            R.drawable.giamgia2,
            R.drawable.giamgia3,
            R.drawable.giamgia4,
            R.drawable.giamgia5,

    };

    SliderView sliderView;

    public static Boolean isDispHomeCustommer =false;

    private String category = "";
    long idUserCurrent;


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
        View view = inflater.inflate(R.layout.frag_home, container, false);
        //lấy dữ liệu đc gửi từ trang Main
        SingletonUser singletonUser = SingletonUser.getInstance();
        Mapping(view);
        idUserCurrent = singletonUser.getIdUser();
//        nameLogo = CategoryService.loadLogoName().toArray(new String[0]);
//        imgLogo = CategoryService.loadLogo();
        nameProductList.clear();
        priceProductList.clear();
        urlProductList.clear();

        if (InternetConnect.isConnected(getContext())) {
//            Toast.makeText(getContext(), "ok", Toast.LENGTH_LONG).show();

            //call api get all product in app
            try {
                ProductAPI.GetAllProduct(getContext(), Utils.BASE_URL + "product/allProduct", new APICallBack() {
                    @Override
                    public void onSuccess(JSONObject response) {
                        try {
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

                            //init adapter
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

        } else {
            Toast.makeText(getContext(), "khong có internet", Toast.LENGTH_LONG).show();
        }
        return view;
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
    }
    private void setAdapter() throws JSONException {

        APICommon.APIGetWithOutJWT(getContext(), "category/getAllCategory", new APICallBack() {
            @Override
            public void onSuccess(JSONObject response) throws JSONException {

                JSONArray data = response.getJSONArray("data");
                JSONObject categoryObj = new JSONObject();
                Category category1 ;
                categoryList.clear();
                for (int i = 0; i < data.length(); i++) {
                     category1 = new Category();
                    categoryObj = data.getJSONObject(i);

                    category1.setCategoryName(categoryObj.getString("categoryName"));
                    category1.setImageURL(categoryObj.getString("imageUrl"));
                    categoryList.add(category1);

                }


                //setCategoryProduct and click item category
                categoryRCVAdapter = new CategoryRCVAdapter(getContext(), categoryList, (view, position) -> {
                    category = categoryList.get(position).getCategoryName();
                    //call api all product của category

                    APICommon.APIGetWithOutJWT(getContext(), "product/byCategory?categoryName=" + category, new APICallBack() {
                        @Override
                        public void onSuccess(JSONObject response) throws JSONException {
                            nameProductList.clear();
                            priceProductList.clear();
                            urlProductList.clear();
                            Log.d("Respone_FragHome_Product_By_Category_onSuccess",category);

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
                            latestProduct_test.notifyDataSetChanged();

                        }

                        @Override
                        public void onError(VolleyError error) {
                            Log.d("Respone_FragHome_Product_By_Category_onSuccess",error.getMessage());

                        }
                    });

                });
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
                gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
                rcvCategory.setLayoutManager(gridLayoutManager);
                rcvCategory.setAdapter(categoryRCVAdapter);

                // setlatestProduct_test

                latestProduct_test = new ProductLatestAdapter(getContext(), nameProductList, priceProductList, urlProductList);
                gr_productList.setAdapter(latestProduct_test);

                //setAdapterSlider
                sliderAdapter = new SliderAdapter(imgSliders);
                sliderView.setSliderAdapter(sliderAdapter);
                sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
                sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
                sliderView.startAutoCycle();
            }

            @Override
            public void onError(VolleyError error) {

            }
        });




    }
    private void Mapping(View view) {
        rcvCategory = view.findViewById(R.id.productCategory);
        gr_productList = view.findViewById(R.id.latestProduct);
        sliderView = view.findViewById(R.id.slider);
    }
}