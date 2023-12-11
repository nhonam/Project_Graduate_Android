package com.example.appsportshop.fragment.Customer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appsportshop.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class  MainOrder extends AppCompatActivity {


    private FragOrder fragWaitConfirm =null;
    private FragBought fragBought =null;
    private FragWaitEvaluate fragWaitEvaluate =null;



    BottomNavigationView navi;


    private void mapping() {
        navi = findViewById(R.id.top_navigation);

    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.acti_main_order);
        mapping();

        if (fragWaitConfirm == null)
            fragWaitConfirm = new FragOrder();
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(
                        R.anim.fade_out,  // enter
                        R.anim.slide_out_left  // exit
                )
                .replace(R.id.content_main_order, fragWaitConfirm)
                .commit();


        navi.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.waitconfirm:
                        item.setChecked(true);
                        if (fragWaitConfirm == null)
                            fragWaitConfirm = new FragOrder();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .setCustomAnimations(
                                        R.anim.fade_out,  // enter
                                        R.anim.slide_out_left  // exit
                                )
                                .replace(R.id.content_main_order, fragWaitConfirm)
                                .commit();
                        break;


                    case R.id.evaluate:
                        item.setChecked(true);
                        if (fragWaitEvaluate == null)
                            fragWaitEvaluate = new FragWaitEvaluate();
                        getSupportFragmentManager()
                                .beginTransaction()
                                .setCustomAnimations(
                                        R.anim.slide_in,
                                        R.anim.fade_out
                                )
                                .replace(R.id.content_main_order, fragWaitEvaluate)
                                .commit();

                        break;

                }
                return false;
            }
        });
    }
}
