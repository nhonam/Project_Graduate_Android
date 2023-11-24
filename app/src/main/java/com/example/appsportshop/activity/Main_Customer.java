package com.example.appsportshop.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.VolleyError;
import com.example.appsportshop.R;
import com.example.appsportshop.api.APICallBack;
import com.example.appsportshop.api.APICommon;
import com.example.appsportshop.api.AuthAPI;
import com.example.appsportshop.fragment.Customer.FragCart;
import com.example.appsportshop.fragment.Customer.FragHome;
import com.example.appsportshop.fragment.Customer.FragProfile;
import com.example.appsportshop.fragment.Customer.FragSearch;
import com.example.appsportshop.utils.SingletonUser;
import com.example.appsportshop.utils.Utils;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.PublicKey;

public class Main_Customer extends AppCompatActivity {


    FragHome fragHome = null;
    FragCart fragCart = null;
    FragProfile fragProfile = null;
    FragSearch fragSearch = null;
    BottomNavigationView navi;
    SharedPreferences sharedPreferences;
    private String username = "";
    private String password = "";
    public static Boolean isLogin = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.main_layout);
//        LoadDataInLocal();

        // mở lên sẽ vào fragHome();

        //lấy fcm token kiểm tra nếu có rồi thì bỏ qua, nếu chưa có thì lwuu vô databas
//        Log.d("123","123");

        if (ReadPassWord()){
            try {
                //getIntent PutExtra từ Update Profile nếu isLogin = true thì phải đăng nhập, không thì thôi
//                Update_Profile
                if(isLogin)
                    APILoginDefault();
                if (FragProfile.isDisplay==true){
                    loadingFragment();
//                    FragProfile.isDisplay=true;
//                    fragProfile= new FragProfile();
//
//                    getSupportFragmentManager()
//                            .beginTransaction()
//                            .setCustomAnimations(
//                                    R.anim.fade_out,  // enter
//                                    R.anim.slide_in  // exit
//                            )
//                            .replace(R.id.content_main, fragProfile)
//                            .commit();
                }else {
                    FragHome.isDispHomeCustommer = false;
                    fragHome = new FragHome();
                    getSupportFragmentManager()
                            .beginTransaction()
                            .setCustomAnimations(
                                    R.anim.fade_out,  // enter
                                    R.anim.slide_out_left  // exit
                            )
                            .replace(R.id.content_main, fragHome)
                            .commit();
                    loadingFragment();
                }

            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }else {
            FragHome.isDispHomeCustommer = false;
            fragHome = new FragHome();
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(
                            R.anim.fade_out,  // enter
                            R.anim.slide_out_left  // exit
                    )
                    .replace(R.id.content_main, fragHome)
                    .commit();
            loadingFragment();
        }
        mapping();
        //nếu bấm lưu trong UpdateProfile thì nhảy qua fragProfile


        navi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_home:
                        item.setChecked(true);
                        if (fragHome == null)
                            fragHome = new FragHome();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .setCustomAnimations(
                                        R.anim.fade_out,  // enter
                                        R.anim.slide_out_left  // exit
                                )
                                .replace(R.id.content_main, fragHome)
                                .commit();
                        break;
                    case R.id.ic_cart:
                        item.setChecked(true);
                        if (fragCart == null)
                            fragCart = new FragCart();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .setCustomAnimations(
                                        R.anim.slide_in,
                                        R.anim.fade_out
                                )
                                .replace(R.id.content_main, fragCart)
                                .commit();

                        break;

                    case R.id.ic_search:
                        item.setChecked(true);
                        if (fragSearch == null)
                            fragSearch = new FragSearch();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .setCustomAnimations(
                                        R.anim.slide_in,
                                        R.anim.fade_out
                                )
                                .replace(R.id.content_main, fragSearch)
                                .commit();

                        break;
                    case R.id.ic_profile:
                        item.setChecked(true);
                        if (fragProfile==null)
                            fragProfile= new FragProfile();

                        getSupportFragmentManager()
                                .beginTransaction()
                                .setCustomAnimations(
                                        R.anim.fade_out,  // enter
                                        R.anim.slide_in  // exit
                                )
                                .replace(R.id.content_main, fragProfile)
                                .commit();
                        break;
                }
                return false;
            }
        });

    }
    private void loadingFragment() {
        if (FragHome.isDispHomeCustommer) {
            FragHome.isDispHomeCustommer = false;
            fragHome = new FragHome();
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(
                            R.anim.fade_out,  // enter
                            R.anim.slide_out_left  // exit
                    )
                    .replace(R.id.content_main, fragHome)
                    .commit();
        }else
        if (FragProfile.isDisplay){
            FragProfile.isDisplay=false;
            fragProfile= new FragProfile();

            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(
                            R.anim.fade_out,  // enter
                            R.anim.slide_in  // exit
                    )
                    .replace(R.id.content_main, fragProfile)
                    .commit();
        }
        else
        if (FragCart.isDisplay){
            FragCart.isDisplay=false;
            fragCart= new FragCart();

            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(
                            R.anim.fade_out,  // enter
                            R.anim.slide_in  // exit
                    )
                    .replace(R.id.content_main, fragCart)
                    .commit();
        }


    }
    private void mapping() {
        navi = findViewById(R.id.bottom_navigation);


    }
    private Boolean ReadPassWord() {

        try {
            sharedPreferences = getSharedPreferences("matkhau", MODE_PRIVATE);

            username = sharedPreferences.getString("username", "");
            password = sharedPreferences.getString("password", "");
            Log.d("username", username);
            Log.d("password", password);
            if (password.equalsIgnoreCase("") || password == null ||username.equalsIgnoreCase("") || username == null) {
//            btnBack.setVisibility(View.GONE);
                return false;
            }
            APILoginDefault();
            return true;
        }catch (Exception R) {
            return false;
        }
//        System.out.println("doc mat khau "+sharedPreferences.getString("username","")+sharedPreferences.getString("password",""));

    }

    private void APILoginDefault() throws JSONException {

        AuthAPI.LoginAPI(getApplicationContext(), Utils.BASE_URL + "auth/login", username, password, new APICallBack() {
            @Override
            public void onSuccess(JSONObject response) throws JSONException {
                JSONObject res = response.getJSONObject("data");
                JSONObject roleObj = res.getJSONObject("role");
//                SaveInfoToLocal(username, password);

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
                getFCMtoken(singletonUser.getIdUser());

            }

            @Override
            public void onError(VolleyError error){
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
