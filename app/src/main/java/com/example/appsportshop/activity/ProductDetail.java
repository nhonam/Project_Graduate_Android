package com.example.appsportshop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.example.appsportshop.R;
import com.example.appsportshop.adapter.CartAdapter;
import com.example.appsportshop.adapter.EvaluateAdapter;
import com.example.appsportshop.adapter.OrderEvalAdapter;
import com.example.appsportshop.api.APICallBack;
import com.example.appsportshop.api.APICommon;
import com.example.appsportshop.api.CartAPI;
import com.example.appsportshop.api.ProductAPI;
import com.example.appsportshop.fragment.Customer.FragCart;
import com.example.appsportshop.fragment.Customer.FragHome;
import com.example.appsportshop.model.Cart;
import com.example.appsportshop.model.Evaluate;
import com.example.appsportshop.model.Product;
import com.example.appsportshop.utils.CustomToast;
import com.example.appsportshop.utils.ObjectWrapperForBinder;
import com.example.appsportshop.utils.SingletonUser;
import com.example.appsportshop.utils.UtilCommon;
import com.example.appsportshop.utils.Utils;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ProductDetail extends AppCompatActivity {
    //sản phẩm người dùng mua kjhi bấm nút mua
    public static Cart Product_bought = null;
    ImageView Img_ProductDetail, btnBackHome, btnCart;
    TextView nameProductDetail, priceProductDeltail, tagProductDeltail, descriptionProductDetail,tvsupplier, tvactivity,tvenvironment,tvbrand,tvunit ;
    TextView addCart,btnBuyProduct;
    ListView lvEval;

    EvaluateAdapter evaluateAdapter;

    ArrayList<Evaluate> listEval;

    private Product product;
    SingletonUser singletonUser = SingletonUser.getInstance();
    BottomSheetDialog dialogSelectQuanti;
    int quantiCart = 0;


    String category,supplier,activity,environment,brand,unit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.product_detail);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        // nhận về giá trị gửi từ frag Home
        mapping();


        String id = getIntent().getStringExtra("idProduct");

        Log.d("data123", id);
//        System.out.println(id+"dã lấy đc ở product detail");
        try {
            ProductAPI.getProductByid(ProductDetail.this, Utils.BASE_URL + "product/one/" + id, new APICallBack() {
                @Override
                public void onSuccess(JSONObject response) throws JSONException {

                    JSONObject data = response.getJSONObject("data");
                    JSONObject productObj = data.getJSONObject("product");
                    JSONArray special = data.getJSONArray("special");

                    product = new Product();

                    product.setId(productObj.getLong("id"));
                    product.setNameProduct(productObj.getString("productName"));
                    product.setPrice((float) productObj.getDouble("price"));
                    product.setDescription(productObj.getString("description"));
                    product.setStockQuantity(productObj.getInt("stockQuantity"));
                    product.setUrlImage(productObj.getString("imageUrl"));

                     category = productObj.getJSONObject("category").getString("categoryName");
                     supplier = "Nhà Cung Cấp : "+ productObj.getJSONObject("supplier").getString("supplierName");
                     activity = "Hoạt động : "+productObj.getJSONObject("activity").getString("activityName");
                     environment ="Môi trường : " +productObj.getJSONObject("environment").getString("environment_name");
                     brand = "Thương hiệu : " +productObj.getJSONObject("brand").getString("brandName");
                     unit ="Đơn vị : " + productObj.getJSONObject("unit").getString("unitName");



                    dialogSelectQuanti = new BottomSheetDialog(ProductDetail.this);
//                    dialogSelectQuanti.dismiss();


                    getEvaluates();

                    setEvent();

                }



                @Override
                public void onError(VolleyError error) {
                    System.err.println("lỗi call api get product by id in Product detail");
                }
            });
        } catch (JSONException e) {
            System.err.println("lỗi call api");

        }


    }

    private void getEvaluates() throws JSONException {
        APICommon.APIGetWithOutJWT(getApplicationContext(), "evaluate-management/evaluates/" + product.getId(), new APICallBack() {
            @Override
            public void onSuccess(JSONObject response) throws JSONException {

                JSONArray data = response.getJSONArray("data");
                JSONObject itemObj = new JSONObject();
                Evaluate evaluateTmp;
                listEval = new ArrayList<>();
                for (int i = 0; i < data.length(); i++) {

                    itemObj = data.getJSONObject(i);
                    evaluateTmp = new Evaluate();
                    evaluateTmp.setComment(itemObj.getString("comment"));
                    evaluateTmp.setId(itemObj.getLong("id"));
                    evaluateTmp.setStar(itemObj.getInt("start"));
                    evaluateTmp.setFullname(itemObj.getString("fullname"));
                    evaluateTmp.setImage_url(itemObj.getString("avatar_url"));
                    evaluateTmp.setProductName(itemObj.getString("product_name"));
                    listEval.add(evaluateTmp);

                }
                evaluateAdapter = new EvaluateAdapter(getApplicationContext(), R.layout.row_evaluate, listEval);
                lvEval.setAdapter(evaluateAdapter);




            }

            @Override
            public void onError(VolleyError error) {

            }
        });

    }


    private void loadData() throws JSONException {




        Glide.with(this).load(product.getUrlImage()).into(Img_ProductDetail);
        nameProductDetail.setText(product.getNameProduct());

        DecimalFormat formatter = new DecimalFormat("#,###");
        String formattedValue = formatter.format( Double.valueOf(String.format("%.0f", product.getPrice())));

        priceProductDeltail.setText(formattedValue +" VND");
        tvsupplier.setText(supplier);
        tvunit.setText(unit);
        tvenvironment.setText(environment);
        tvbrand.setText(brand);
        tvactivity.setText(activity);

//        priceProductDeltail.setText(String.format("%.0f", product.getPrice()) +" VND");

//        priceProductDeltail.setText(String.valueOf(product.getPrice()) + " VND");
        descriptionProductDetail.setText(product.getDescription());
    }

    private void setEvent() throws JSONException {
        loadData();




        addCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createDialogAddCart();

                dialogSelectQuanti.show();

            }
        });

        btnBuyProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createDialogBuy();
                dialogSelectQuanti.show();

            }
        });



        btnBackHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragHome.isDispHomeCustommer = true;
                startActivity(new Intent(ProductDetail.this, Main_Customer.class));
            }
        });

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragCart.isDisplay = true;
                startActivity(new Intent(ProductDetail.this, Main_Customer.class));
            }
        });


    }


    private void createDialogAddCart() {
        View view = getLayoutInflater().inflate(R.layout.bottom_sheet, null, false);
        Button btnSubmit = view.findViewById(R.id.submit_quanti);
        TextView btnreduce = view.findViewById(R.id.reduce);
        TextView btnIncrease = view.findViewById(R.id.increase);
        TextView quanti = view.findViewById(R.id.quantityCart);


        quantiCart = Integer.parseInt(quanti.getText().toString());
        btnreduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int quantity = Integer.parseInt(quanti.getText().toString()) - 1;
                if (quantity <= 0) {
                    CustomToast.makeText(ProductDetail.this, "Vui Lòng Chọn Số Lượng Lớn Hơn 0 !!!", CustomToast.LENGTH_LONG, CustomToast.ERROR, true).show();
                    quanti.setText("1");
                } else {
                    quanti.setText(String.valueOf(quantity));
                }
                quantiCart = Integer.parseInt(quanti.getText().toString());


            }
        });

        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity = Integer.parseInt(quanti.getText().toString()) + 1;
                quanti.setText(String.valueOf(quantity));

                quantiCart = Integer.parseInt(quanti.getText().toString());
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (singletonUser.getToken() == null) {
                        CustomToast.makeText(ProductDetail.this, "Vui lòng đăng nhập để tiếp tục !!!", CustomToast.LENGTH_SHORT, CustomToast.WARNING, true).show();

                        Intent intent = new Intent(getApplicationContext(), Login.class);
                        startActivity(intent);
                    }else
                            addToCart();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                dialogSelectQuanti.dismiss();
            }
        });
        dialogSelectQuanti.setContentView(view);

    }

    private void createDialogBuy() {
        View view = getLayoutInflater().inflate(R.layout.bottom_sheet, null, false);
        Button btnSubmit = view.findViewById(R.id.submit_quanti);
        TextView btnreduce = view.findViewById(R.id.reduce);
        TextView btnIncrease = view.findViewById(R.id.increase);
        TextView quanti = view.findViewById(R.id.quantityCart);


            Button  submit_quanti = view.findViewById(R.id.submit_quanti);
            submit_quanti.setText("MUA SẢN PHẨM");


        quantiCart = Integer.parseInt(quanti.getText().toString());
        btnreduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int quantity = Integer.parseInt(quanti.getText().toString()) - 1;
                if (quantity <= 0) {
                    CustomToast.makeText(ProductDetail.this, "Vui Lòng Chọn Số Lượng Lớn Hơn 0 !!!", CustomToast.LENGTH_LONG, CustomToast.ERROR, true).show();
                    quanti.setText("1");
                } else {
                    quanti.setText(String.valueOf(quantity));
                }
                quantiCart = Integer.parseInt(quanti.getText().toString());


            }
        });

        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity = Integer.parseInt(quanti.getText().toString()) + 1;
                quanti.setText(String.valueOf(quantity));

                quantiCart = Integer.parseInt(quanti.getText().toString());
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (singletonUser.getToken() == null) {
                        CustomToast.makeText(ProductDetail.this, "Vui lòng đăng nhập để tiếp tục !!!", CustomToast.LENGTH_SHORT, CustomToast.WARNING, true).show();

                        Intent intent = new Intent(getApplicationContext(), Login.class);
                        startActivity(intent);
                    }else

                        BuyProduct();

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                dialogSelectQuanti.dismiss();
            }
        });
        dialogSelectQuanti.setContentView(view);

    }

    private void addToCart() throws JSONException {
        System.out.println(singletonUser.getIdUser()+"|"+product.getId()+"|"+ quantiCart);
        ProductAPI.AddToCart(ProductDetail.this, Utils.BASE_URL + "cart-management/carts", singletonUser.getIdUser(), product.getId(), quantiCart, new APICallBack() {
            @Override
            public void onSuccess(JSONObject response) throws JSONException {
                CustomToast.makeText(ProductDetail.this, "Thêm sản phẩm vào giỏ hàng thành công", CustomToast.LENGTH_SHORT, CustomToast.SUCCESS, true).show();
            }

            @Override
            public void onError(VolleyError error) {
                CustomToast.makeText(ProductDetail.this, "Thêm sản phẩm vào giỏ hàng thất bại", CustomToast.LENGTH_SHORT, CustomToast.ERROR, true).show();

            }
        });
    }

    private void BuyProduct() throws JSONException {
        Product_bought = new Cart();
        Product_bought.setQuantity(quantiCart);  // số lượng sản phẩm muốn mua
        Product_bought.setPrice_total(product.getPrice());
        Product_bought.setUrlImage(product.getUrlImage());
        Product_bought.setNameProduct(product.getNameProduct());
        Product_bought.setIdProduct(String.valueOf(product.getId()));

        Intent intent = new Intent(getApplicationContext(), Payment.class);
        Address.isDisplay = false;

        intent.putExtra("tongTien", UtilCommon.FormatPrice((double) (product.getPrice()*quantiCart)));
        startActivity(intent);
    }

    private void mapping() {
        Img_ProductDetail = findViewById(R.id.img_ProductDetail);
        nameProductDetail = findViewById(R.id.nameProductDetail);
        priceProductDeltail = findViewById(R.id.priceProductDeltail);
        tagProductDeltail = findViewById(R.id.tagProductDeltail);
        descriptionProductDetail = findViewById(R.id.descriptionProductDetail);
        addCart = findViewById(R.id.addCart);
        btnBackHome = findViewById(R.id.back_Productdetail);
        btnCart = findViewById(R.id.cart_Productdetail);

        tvbrand = findViewById(R.id.brand);
        tvactivity = findViewById(R.id.activity);
        tvenvironment = findViewById(R.id.environment);
        tvunit = findViewById(R.id.unit);
        tvsupplier = findViewById(R.id.supplier);
        btnBuyProduct = findViewById(R.id.buy_product);
        lvEval = findViewById(R.id.lv_eval);


    }
}
