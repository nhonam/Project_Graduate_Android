package com.example.appsportshop.fragment.Customer;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;

import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Resource;
import com.example.appsportshop.R;
import com.example.appsportshop.activity.ChangePassW;
import com.example.appsportshop.activity.Login;

import com.example.appsportshop.activity.MainAdmin;
import com.example.appsportshop.activity.MainEmployee;
import com.example.appsportshop.activity.Main_Customer;
import com.example.appsportshop.activity.Update_Profile;
import com.example.appsportshop.api.APICallBack;
import com.example.appsportshop.api.AuthAPI;
import com.example.appsportshop.fragment.Admin.FragManagerProduct;

import com.example.appsportshop.activity.Main_Customer;
import com.example.appsportshop.activity.Update_Profile;
import com.example.appsportshop.utils.CustomToast;

import com.example.appsportshop.utils.SingletonUser;
import com.example.appsportshop.utils.Utils;
import com.example.appsportshop.utils.dialog;

import org.json.JSONException;
import org.json.JSONObject;

public class FragProfile extends Fragment {

    public static Boolean isDisplay = false;


    ImageView avtUser;
    TextView nameUser;


    TextView fullName, ordered, emailProfile, phoneProfile, adressProfile, birthdayProfile, idProfile, changpass;

    LinearLayout logOut;


    LinearLayout btnLogout, btnUpdateProfile;
    SharedPreferences sharedPreferences;


    SingletonUser singletonUser = SingletonUser.getInstance();


    SingletonUser userCurrent = SingletonUser.getInstance();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frag_profile, container, false);


        mapping(view);

        sharedPreferences = getActivity().getSharedPreferences("matkhau", MODE_PRIVATE);


        if (!ReadPassWord()) {
            CustomToast.makeText(getContext(), "Vui lòng đăng nhập để tiếp tục !!!", CustomToast.LENGTH_SHORT, CustomToast.WARNING, true).show();


            Intent intent = new Intent(getContext(), Login.class);
            startActivity(intent);
        } else {
            if (singletonUser==null){
                sharedPreferences = getContext().getSharedPreferences("matkhau", MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "");
                String password = sharedPreferences.getString("password", "");
                try {
                    AuthAPI.LoginAPI(getContext(), Utils.BASE_URL + "auth/login", username, password, new APICallBack() {
                        @Override
                        public void onSuccess(JSONObject response) throws JSONException {
                            JSONObject res = response.getJSONObject("data");
                            JSONObject role = res.getJSONObject("role");


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

                        }


                        @Override
                        public void onError(VolleyError error) {

                        }
                    });
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
            loadInfoUser();

            setEvent();
        }


        return view;
    }

//    private Boolean ReadPassWord() {
//
//        try {
//            sharedPreferences = getContext().getSharedPreferences("matkhau", MODE_PRIVATE);
//            String username = sharedPreferences.getString("username", "");
//            String password = sharedPreferences.getString("password", "");
//            if (password.equalsIgnoreCase("") || password == null || username.equalsIgnoreCase("") || username == null) {
////            btnBack.setVisibility(View.GONE);
//                return false;
//            }
//            return true;
//
//        } catch (Exception R) {
//            return false;
//        }
////        System.out.println("doc mat khau "+sharedPreferences.getString("username","")+sharedPreferences.getString("password",""));
//
//    }

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
    private Boolean ReadPassWord() {

        try {
            String username = sharedPreferences.getString("username", "");
            String password = sharedPreferences.getString("password", "");
            Log.d("username", username);
            Log.d("password", password);
            if (password.equalsIgnoreCase("") || password == null || username.equalsIgnoreCase("") || username == null) {
//            btnBack.setVisibility(View.GONE);
                return false;
            }
            return true;
        } catch (Exception R) {
            return false;
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();

        // Bỏ điều kiện ghi đè khi Fragment bị hủy
        callback.remove();
    }

    private void loadInfoUser() {



//        Log.d("111", singletonUser.getRole());
//        if (singletonUser.getRole().equalsIgnoreCase("ADMIN"))
//            ordered.setVisibility(View.GONE);
        if (singletonUser.getFullName() == null) {
            singletonUser.setFullName("");

        Log.d("nhonam", userCurrent.getRole().toString());

        if (userCurrent.getRole().equalsIgnoreCase("ADMIN"))
            ordered.setVisibility(View.GONE);
        if (userCurrent.getFullName() == null) {
            userCurrent.setFullName("");

        }

        if (singletonUser.getEmail() == null) {
            singletonUser.setEmail("");
        }
        if (singletonUser.getAdress() == null) {
            singletonUser.setAdress("");
        }

        if (singletonUser.getBirthday() == null) {
            birthdayProfile.setText("");

        } else {
            birthdayProfile.setText(singletonUser.getBirthday());

        }
        if (singletonUser.getPhone() == null) {
            singletonUser.setPhone("");
        }



        Glide.with(getContext()).load(userCurrent.getAvatarUrl()).error(R.drawable.error_load_image).into(avtUser);
        nameUser.setText(userCurrent.getFullName());
        idProfile.setText(String.valueOf(userCurrent.getIdUser()));
        emailProfile.setText(userCurrent.getEmail());
        fullName.setText(userCurrent.getFullName());
        phoneProfile.setText(userCurrent.getPhone());
        adressProfile.setText(userCurrent.getAdress());
        birthdayProfile.setText(userCurrent.getBirthday());



    }


    private void mapping(View view) {
        changpass = view.findViewById(R.id.changpass);
        fullName = view.findViewById(R.id.fullname_Pf);
        emailProfile = view.findViewById(R.id.emailProfile);
        phoneProfile = view.findViewById(R.id.phoneProfile);
        adressProfile = view.findViewById(R.id.adressProfile);
        birthdayProfile = view.findViewById(R.id.birthdayProfile);
        idProfile = view.findViewById(R.id.id_user);
        avtUser = view.findViewById(R.id.avt_User);
        nameUser = view.findViewById(R.id.name_User);
        ordered = view.findViewById(R.id.ordered);

//        navi = view.findViewById(R.id.bottom_navigation_pro);
//        btnManagerProduct = view.findViewById(R.id.btnManagerProduct);
//        btnLogout = view.findViewById(R.id.logout);
        btnUpdateProfile = view.findViewById(R.id.updateInfo);
        logOut = view.findViewById(R.id.logout);
//        btnSetting = view.findViewById(R.id.setting);

    }

    private void setEvent() {
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getContext().getSharedPreferences("matkhau", MODE_PRIVATE);
                sharedPreferences.edit().clear().commit();
                SingletonUser singletonUser = SingletonUser.getInstance();
                singletonUser.clearValues();
                Intent intent = new Intent(getContext(), Login.class);
                startActivity(intent);
            }
        });

        ordered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MainOrder.class);
                startActivity(intent);
            }
        });

        changpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ChangePassW.class);
                startActivity(intent);
            }
        });


        btnUpdateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getContext(), Update_Profile.class);
//                intent.putExtra("token",userCurrent);
//                startActivity(intent);


                Intent intent = new Intent(getContext(), Update_Profile.class);
                startActivity(intent);

            }
        });

    }


}