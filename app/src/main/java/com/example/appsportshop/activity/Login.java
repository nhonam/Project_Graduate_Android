package com.example.appsportshop.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.android.volley.VolleyError;
import com.example.appsportshop.R;
import com.example.appsportshop.api.APICallBack;
import com.example.appsportshop.api.APICommon;
import com.example.appsportshop.api.AuthAPI;
import com.example.appsportshop.api.UserAPI;
import com.example.appsportshop.fragment.Admin.FragManagerProduct;
import com.example.appsportshop.fragment.Customer.FragHome;
import com.example.appsportshop.utils.CustomToast;
import com.example.appsportshop.utils.SingletonUser;
import com.example.appsportshop.utils.Utils;
import com.example.appsportshop.utils.dialog;
import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessaging;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {

    AppCompatButton btnLogin;
    private String username = "";
    private String password = "";
    TextView txtregisterNow,forgetpass,pushNoti;
    ImageView btnBack;
    EditText edtUserName, edtpassWord;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.login_act);

        sharedPreferences = getSharedPreferences("matkhau", MODE_PRIVATE);
        ReadPassWord();

        mapping();



        try {
            if (ReadPassWord())
                APILoginDefault();
        } catch (JSONException e) {
            System.err.println("Error catch LoginAPI in class (Login.java)" + e.getMessage());
            throw new RuntimeException(e);
        }
        setEvent();
    }

    private Boolean ReadPassWord() {

//        System.out.println("doc mat khau "+sharedPreferences.getString("username","")+sharedPreferences.getString("password",""));
        username = sharedPreferences.getString("username", "");
        password = sharedPreferences.getString("password", "");
        if (password.equalsIgnoreCase("") || password == null ||username.equalsIgnoreCase("") || username == null) {
//            btnBack.setVisibility(View.GONE);
            return false;
        }
        return true;
    }

    private void mapping() {
        btnLogin = findViewById(R.id.btnLogin);
        txtregisterNow = findViewById(R.id.registerNow);
        edtUserName = (EditText) findViewById(R.id.login_username);
        edtpassWord = (EditText) findViewById(R.id.login_password);
        forgetpass =  findViewById(R.id.forgetpass);
        btnBack =  findViewById(R.id.loginBack);


    }


    private void setEvent() {

        if (username.equalsIgnoreCase("") && password.equalsIgnoreCase("")){
            btnBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Login.this, Main_Customer.class);
                    startActivity(intent);
                }
            });
        }




        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                username = String.valueOf(edtUserName.getText());
                password = String.valueOf(edtpassWord.getText());

                try {
                    APILogin();
                } catch (JSONException e) {
                    System.err.println("Error catch LoginAPI in class (Login.java)" + e.getMessage());
                    throw new RuntimeException(e);
                }

            }
        });

        txtregisterNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });

        forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    GetUserByUserName();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }





    private void GetUserByUserName() throws JSONException {
        JSONObject postData = new JSONObject();

        postData.put("username",edtUserName.getText().toString().trim());
        UserAPI.ApiPostandBody(getApplicationContext(), Utils.BASE_URL + "auth/getUser-byUserName", postData, new APICallBack() {
            @Override
            public void onSuccess(JSONObject response) throws JSONException {
                JSONArray res = (JSONArray) response.get("data");

                ApiResetPassWord((String) res.get(0), (String) res.get(1));
            }

            @Override
            public void onError(VolleyError error) {
                CustomToast.makeText(Login.this, "Tên đăng nhập của bạn không tồn tại !", CustomToast.LENGTH_SHORT, CustomToast.ERROR, true).show();

            }
        });
    }

    private void ApiResetPassWord(String idUser, String email) throws JSONException {
        JSONObject postData = new JSONObject();

        postData.put("email",email);
        UserAPI.ApiPostandBody(getApplicationContext(), Utils.BASE_URL + "user/forget-password/" + idUser, postData, new APICallBack() {
            @Override
            public void onSuccess(JSONObject response) throws JSONException {
                CustomToast.makeText(Login.this, "Mở ứng dụng gmail của bạn để lấy mật khẩu mới !", CustomToast.LENGTH_SHORT, CustomToast.SUCCESS, true).show();

            }

            @Override
            public void onError(VolleyError error) {
                CustomToast.makeText(Login.this, "Mở ứng dụng gmail của bạn để lấy mật khẩu mới !", CustomToast.LENGTH_SHORT, CustomToast.SUCCESS, true).show();

            }
        });
    }

    private void APILoginDefault() throws JSONException {
        dialog dialog = new dialog(Login.this);
        dialog.startLoadingdialog();
        AuthAPI.LoginAPI(getApplicationContext(), Utils.BASE_URL + "auth/login", username, password, new APICallBack() {
            @Override
            public void onSuccess(JSONObject response) throws JSONException {
                JSONObject res = response.getJSONObject("data");
                JSONObject role = res.getJSONObject("role");
                SaveInfoToLocal(username, password);

                SingletonUser singletonUser = SingletonUser.getInstance();
                singletonUser.setIdUser(res.getLong("id"));

                singletonUser.setUserName(res.getString("username"));
                if (res.getString("fullname").equalsIgnoreCase("null")) {
                    singletonUser.setFullName("");
                } else {
                    singletonUser.setFullName(res.getString("fullname"));

                }


                if (res.getString("adress").equalsIgnoreCase("null")) {
                    singletonUser.setAdress("");
                } else {
                    singletonUser.setAdress(res.getString("adress"));

                }
                if (res.getString("email").equalsIgnoreCase("null")) {
                    singletonUser.setEmail("");
                } else {
                    singletonUser.setEmail(res.getString("email"));

                }

                if (res.getString("birthday").equalsIgnoreCase("null")) {
                    singletonUser.setBirthday("");
                } else {
                    singletonUser.setBirthday(res.getString("birthday"));

                }

                if (res.getString("phone").equalsIgnoreCase("null")) {
                    singletonUser.setPhone("");
                } else {
                    singletonUser.setPhone(res.getString("phone"));
                }


//                System.out.println(singletonUser.getBirthday()+"woa-------------");
                singletonUser.setPassword(password);

                singletonUser.setRole(role.getString("name"));
                singletonUser.setAvatarUrl(res.getString("avatarUrl"));
                singletonUser.setPublicId(res.getString("publicId"));
                singletonUser.setToken(response.getString("token"));


                //nếu là Custommer

                if (role.getLong("id")== 3) {

                    getFCMtoken(singletonUser.getIdUser());


                    if (singletonUser.getFullName().equalsIgnoreCase("null") || singletonUser.getEmail().equalsIgnoreCase("null") || singletonUser.getPhone().equalsIgnoreCase("null") || singletonUser.getAdress().equalsIgnoreCase("null")) {
                        Intent intent = new Intent(Login.this, Update_Profile.class);
                        startActivity(intent);
                    } else {

                        FragHome.isDispHomeCustommer = true;
                        Intent intent = new Intent(Login.this, Main_Customer.class);
                        startActivity(intent);
                    }

                // nếu user là employee
                } else if (role.getLong("id") == 2) {
                    if (singletonUser.getFullName() == null || singletonUser.getEmail() == null || singletonUser.getPhone() == null || singletonUser.getAdress() == null) {

                        Intent intent = new Intent(Login.this, Update_Profile.class);
                        startActivity(intent);
                    } else {

                        Intent intent = new Intent(Login.this, MainEmployee.class);
                        startActivity(intent);
                    }

                    //nếu user là admin
                } else {
                    Intent intent = new Intent(Login.this, MainAdmin.class);
                    FragManagerProduct.isDisplayManagerProd=true;
                    startActivity(intent);
                }
                dialog.dismissdialog();
            }

            @Override
            public void onError(VolleyError error) {
                dialog.dismissdialog();
            }
        });
    }

    private void SaveInfoToLocal(String username, String password) {

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("username", username);
        editor.putString("password", password);
        editor.commit();

    }

    public void APILogin() throws JSONException {
        dialog dialog = new dialog(Login.this);
        dialog.startLoadingdialog();
        AuthAPI.LoginAPI(getApplicationContext(), Utils.BASE_URL + "auth/login", username, password, new APICallBack() {
            @Override
            public void onSuccess(JSONObject response) throws JSONException {
                Log.d("Respone_Login_Sucess", response.toString());

                JSONObject res = response.getJSONObject("data");
                JSONObject roleObj = res.getJSONObject("role");

                SaveInfoToLocal(username, password);

                SingletonUser singletonUser = SingletonUser.getInstance();
                singletonUser.setIdUser(res.getLong("id"));

                singletonUser.setUserName(res.getString("username"));
                if (res.getString("fullname").equalsIgnoreCase("null")) {
                    singletonUser.setFullName("");
                } else {
                    singletonUser.setFullName(res.getString("fullname"));

                }


                if (res.getString("adress").equalsIgnoreCase("null")) {
                    singletonUser.setAdress("");
                } else {
                    singletonUser.setAdress(res.getString("adress"));

                }
                if (res.getString("email").equalsIgnoreCase("null")) {
                    singletonUser.setEmail("");
                } else {
                    singletonUser.setEmail(res.getString("email"));

                }

                if (res.getString("birthday").equalsIgnoreCase("null")) {
                    singletonUser.setBirthday("");
                } else {
                    singletonUser.setBirthday(res.getString("birthday"));

                }

                if (res.getString("phone").equalsIgnoreCase("null")) {
                    singletonUser.setPhone("");
                } else {
                    singletonUser.setPhone(res.getString("phone"));
                }


//                System.out.println(singletonUser.getBirthday()+"woa-------------");
                singletonUser.setPassword(password);

                singletonUser.setRole(roleObj.getString("name"));
                singletonUser.setAvatarUrl(res.getString("avatarUrl"));
                singletonUser.setPublicId(res.getString("publicId"));
                singletonUser.setToken(response.getString("token"));


                if (roleObj.getString("name").equalsIgnoreCase("CUSTOMER")) {

                    getFCMtoken(singletonUser.getIdUser());


                    if (singletonUser.getFullName().equalsIgnoreCase("") || singletonUser.getEmail().equalsIgnoreCase("") || singletonUser.getPhone().equalsIgnoreCase("") || singletonUser.getAdress().equalsIgnoreCase("")) {
                        Intent intent = new Intent(Login.this, Update_Profile.class);
                        startActivity(intent);
                    } else {

                        FragHome.isDispHomeCustommer = true;
                        Intent intent = new Intent(Login.this, Main_Customer.class);
                        startActivity(intent);
                    }


                } else if (roleObj.getString("name").equalsIgnoreCase("EMPLOYEE")) {
                    if (singletonUser.getFullName() == null || singletonUser.getEmail() == null || singletonUser.getPhone() == null || singletonUser.getAdress() == null) {

                        Intent intent = new Intent(Login.this, Update_Profile.class);
                        startActivity(intent);
                    } else {

                        Intent intent = new Intent(Login.this, MainEmployee.class);
                        startActivity(intent);
                    }


                } else {
                    Intent intent = new Intent(Login.this, MainAdmin.class);
                    FragManagerProduct.isDisplayManagerProd= true;
                    startActivity(intent);
                }

            }

            @Override
            public void onError(VolleyError error) {
                edtUserName.setText("");
                edtpassWord.setText("");
                edtUserName.requestFocus();
//                Log.d("Respone_Login_Error", error.getMessage());
                dialog.dismissdialog();
                CustomToast.makeText(Login.this, "Tên đăng nhập hoặc mật khẩu không đúng !", CustomToast.LENGTH_SHORT, CustomToast.ERROR, true).show();

            }
        });
    }


    void getFCMtoken(long idUser){
        FirebaseApp.initializeApp(this);
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(task -> {

            if (task.isSuccessful()){
                String token = task.getResult();
                Log.i("token",token);
                JSONObject body = new JSONObject();
                try {
                    body.put("fcm_token", token);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                try {
                    APICommon.APIPostWithJWT(getApplicationContext(), "user/find-device/" + idUser, body, new APICallBack() {
                        @Override
                        public void onSuccess(JSONObject response) throws JSONException {
                            Log.d( "1111",response.toString());
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
    }
}