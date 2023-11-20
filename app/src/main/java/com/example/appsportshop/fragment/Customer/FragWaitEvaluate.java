package com.example.appsportshop.fragment.Customer;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;

import com.example.appsportshop.R;
import com.example.appsportshop.model.Cart;

import java.util.ArrayList;

//Đánh giá sản phẩm ( những sản phẩm đã mua thành công nhưng chưa đánh giá )
public class FragWaitEvaluate extends Fragment {
    // danh sách sản phẩm đã mua nhưng chưa đánh giá
    public ArrayList<Cart> orderEvaluate;
    ListView listViewOrderEval;
    private OnBackPressedCallback callback;

    private void mapping(View view) {

    }

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
        View view = inflater.inflate(R.layout.frag_evalution, container, false);
        //lấy dữ liệu đc gửi từ trang Main

        mapping(view);

        return view;
    }


}
