package com.example.appsportshop.activity;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import com.android.volley.VolleyError;
import com.example.appsportshop.R;
import com.example.appsportshop.api.APICallBack;
import com.example.appsportshop.api.CartAPI;
import com.example.appsportshop.api.OrderAPI;
import com.example.appsportshop.fragment.Customer.FragCart;
import com.example.appsportshop.fragment.Customer.MainOrder;
import com.example.appsportshop.model.Cart;
import com.example.appsportshop.utils.CustomToast;
import com.example.appsportshop.utils.SingletonUser;
import com.example.appsportshop.utils.Utils;
import com.example.appsportshop.utils.dialog;
import com.example.appsportshop.zalo.Api.CreateOrder;

import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;

import vn.zalopay.sdk.ZaloPayError;
import vn.zalopay.sdk.ZaloPaySDK;
import vn.zalopay.sdk.Environment;
import vn.zalopay.sdk.listeners.PayOrderListener;

public class  ZaloPay extends AppCompatActivity {
    SingletonUser singletonUser = SingletonUser.getInstance();
    TextView lblZpTransToken, txtToken;
    Button btnCreateOrder, btnPay;
    EditText txtAmount;
    ArrayList<Cart> listProductPayment;
    String tongtien;

    private void BindView() {
//        txtToken = findViewById(R.id.txtToken);
//        lblZpTransToken = findViewById(R.id.lblZpTransToken);
        btnCreateOrder = findViewById(R.id.btnPay);
        txtAmount = findViewById(R.id.txtAmount);
        txtAmount.setText(tongtien);
        btnPay = findViewById(R.id.btnPay);
//        IsLoading();
    }

//    private void IsLoading() {
//        lblZpTransToken.setVisibility(View.INVISIBLE);
//        txtToken.setVisibility(View.INVISIBLE);
//        btnPay.setVisibility(View.INVISIBLE);
//    }
//
//    private void IsDone() {
//        lblZpTransToken.setVisibility(View.VISIBLE);
//        txtToken.setVisibility(View.VISIBLE);
//        btnPay.setVisibility(View.VISIBLE);
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zalopay);

        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        listProductPayment = new ArrayList<>();

        if (ProductDetail.isBuyInCart){
            for (int i = 0; i < FragCart.listCart.size(); i++) {
                if (FragCart.listCart.get(i).getSelected()) {
                    listProductPayment.add(FragCart.listCart.get(i));
                }
            }
        }else {
            listProductPayment.add(ProductDetail.Product_bought);

        }


        Intent intent = getIntent();
       tongtien  = intent.getStringExtra("tongtien");

//        tongtien="10000";


        // ZaloPay SDK Init
        ZaloPaySDK.init(2553, Environment.SANDBOX);
        // bind components with ids
        BindView();
        dialog dialog = new dialog(ZaloPay.this);

        // handle CreateOrder

        btnCreateOrder.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                dialog.startLoadingdialog();
                CreateOrder orderApi = new CreateOrder();

                String numericString = tongtien.replaceAll("[^0-9]", "");
                Log.d("nhonam",numericString);
                try {
                    JSONObject data = orderApi.createOrder(numericString);

//                    lblZpTransToken.setVisibility(View.VISIBLE);
                    String code = data.getString("return_code");
                    Toast.makeText(getApplicationContext(), "return_code: " + code, Toast.LENGTH_LONG).show();

                    if (code.equals("1")) {
//                        lblZpTransToken.setText("zptranstoken");
                        String token = data.getString("zp_trans_token");
//                        txtToken.setText(token);

                        ZaloPaySDK.getInstance().payOrder(ZaloPay.this, token, "demozpdk://app", new PayOrderListener() {
                            @Override
                            public void onPaymentSucceeded(String s, String s1, String s2) {

                                try {
                                    dialog.dismissdialog();
                                    APIMuaHang();

                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }


                            }

                            @Override
                            public void onPaymentCanceled(String s, String s1) {
                                CustomToast.makeText(ZaloPay.this,  "     Thanh toán thất bại ! ", CustomToast.LENGTH_LONG, CustomToast.ERROR, true).show();
                                dialog.dismissdialog();
                            }

                            @Override
                            public void onPaymentError(ZaloPayError zaloPayError, String s, String s1) {
                                dialog.dismissdialog();
                                CustomToast.makeText(ZaloPay.this,  "     Thanh toán thất bại ! ", CustomToast.LENGTH_LONG, CustomToast.ERROR, true).show();
                                Intent intent = new Intent(ZaloPay.this, Main_Customer.class);
                                startActivity(intent);

                            }
                        });

//                        IsDone();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });



    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        ZaloPaySDK.getInstance().onResult(intent);
    }




    public  void APIMuaHang() throws JSONException {

        String idQuantities ="";
        String idProducts ="";

        for (int i = 0; i < listProductPayment.size(); i++) {
            idQuantities += listProductPayment.get(i).getQuantity()+",";
            idProducts+=listProductPayment.get(i).getIdProduct()+",";
        }
        idQuantities =  idQuantities.replaceAll(",$", "");
        idProducts =  idProducts.replaceAll(",$", "");

        OrderAPI.BuyProduct(getApplicationContext(),
                Utils.BASE_URL + "order/buy", singletonUser.getIdUser(),
                Payment.diaChiShip, idProducts, idQuantities, Payment.sdtNgNhan, Payment.tenNgNhan, new APICallBack() {
                    @Override
                    public void onSuccess(JSONObject response) throws JSONException {
                        if (ProductDetail.isBuyInCart)
                            RemoveProductInCart();
                        else {
                            CustomToast.makeText(ZaloPay.this,  "     Mua hàng thành công ! \n Cảm ơn bạn đã tin tưởng Shop", CustomToast.LENGTH_LONG, CustomToast.SUCCESS, true).show();

                            Intent intent = new Intent(getApplicationContext(), MainOrder.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onError(VolleyError error) {

                    }
                });
    }

    private void RemoveProductInCart() throws JSONException {

        try {
            for (int i = 0; i < FragCart.listCart.size(); i++) {

                for (int j = 0; j < listProductPayment.size(); j++) {

                    if (FragCart.listCart.get(i).getId() == listProductPayment.get(i).getId()){
//                        FragCart.listCart.remove(i);
//                        if (FragCart.listCart.size()==0) return;
                        CartAPI.DeleteCart(getApplicationContext(), Utils.BASE_URL + "cart-management/" + FragCart.listCart.get(i).getId(), new APICallBack() {
                            @Override
                            public void onSuccess(JSONObject response) throws JSONException {

                                CustomToast.makeText(ZaloPay.this,  "     Mua hàng thành công ! \n Cảm ơn bạn đã tin tưởng Shop", CustomToast.LENGTH_LONG, CustomToast.SUCCESS, true).show();

                                Intent intent1= new Intent(ZaloPay.this, MainOrder.class);
                                startActivity(intent1);


                            }

                            @Override
                            public void onError(VolleyError error) {

                            }
                        });
                    }
                }
            }
        }catch (Exception e) {
            CustomToast.makeText(ZaloPay.this,  "     Mua hàng thành công ! \n Cảm ơn bạn đã tin tưởng Shop", CustomToast.LENGTH_LONG, CustomToast.SUCCESS, true).show();

            Intent intent = new Intent(getApplicationContext(), MainOrder.class);
            startActivity(intent);
        }



    }

}
