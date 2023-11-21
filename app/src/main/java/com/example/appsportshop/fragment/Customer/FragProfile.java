package com.example.appsportshop.fragment.Customer;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
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

import com.bumptech.glide.Glide;
import com.example.appsportshop.R;
import com.example.appsportshop.activity.ChangePassW;
import com.example.appsportshop.activity.Login;
import com.example.appsportshop.activity.Update_Profile;
import com.example.appsportshop.model.User;
import com.example.appsportshop.utils.CustomToast;
import com.example.appsportshop.utils.SingletonUser;

import org.json.JSONException;

public class FragProfile extends Fragment {

    public static Boolean isDisplay = false;


    ImageView avtUser;
    TextView nameUser;


    TextView fullName, ordered, emailProfile, phoneProfile, adressProfile, birthdayProfile, idProfile, changpass;

    LinearLayout logOut;


    LinearLayout btnLogout, btnUpdateProfile;
    SharedPreferences sharedPreferences;

    String username="", password="";
    SingletonUser singletonUser = SingletonUser.getInstance();
    User userCur = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frag_profile, container, false);


        mapping(view);




        if (!ReadPassWord()) {
            CustomToast.makeText(getContext(), "Vui lòng đăng nhập để tiếp tục !!!", CustomToast.LENGTH_SHORT, CustomToast.WARNING, true).show();


            Intent intent = new Intent(getContext(), Login.class);
            startActivity(intent);
        } else {
                sharedPreferences = getContext().getSharedPreferences("matkhau", MODE_PRIVATE);
                 username = sharedPreferences.getString("username", "");
                 password = sharedPreferences.getString("password", "");
                try {
                    loadInfoUser();
                    setEvent();
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
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
            sharedPreferences = getActivity().getSharedPreferences("matkhau", MODE_PRIVATE);
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

    private void loadInfoUser() throws JSONException {


            userCur = getInfoUser();

            Glide.with(getContext()).load(userCur.getAvatarUrl()).error(R.drawable.error_load_image).into(avtUser);
            nameUser.setText(userCur.getFullName());
            idProfile.setText(String.valueOf(userCur.getIdUser()));
            emailProfile.setText(userCur.getEmail());
            fullName.setText(userCur.getFullName());
            phoneProfile.setText(userCur.getPhone());
            adressProfile.setText(userCur.getAdress());
            birthdayProfile.setText(userCur.getBirthday());



    }
    private User getInfoUser() {
        User user = new User();

        user.setIdUser(singletonUser.getIdUser());
        user.setFullName(singletonUser.getFullName());
        user.setEmail(singletonUser.getEmail());
        user.setAdress(singletonUser.getAdress());

        Log.d("nhonam",singletonUser.getRole()+"test");
        if(singletonUser.getBirthday()==null){

            user.setBirthday(null);
        }else{

            user.setBirthday(singletonUser.getBirthday());

        }
        user.setPhone(singletonUser.getPhone());
        user.setAvatarUrl(singletonUser.getAvatarUrl());
        user.setPublicId(singletonUser.getPublicId());
        user.setRole(singletonUser.getRole());


        return user;
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