package com.example.appsportshop.fragment.Customer;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;

import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.example.appsportshop.R;
import com.example.appsportshop.activity.Main_Customer;
import com.example.appsportshop.activity.ProductDetail;
import com.example.appsportshop.adapter.OrderAdapter;
import com.example.appsportshop.adapter.ProductManagerAdapter;
import com.example.appsportshop.api.APICallBack;
import com.example.appsportshop.api.OrderAPI;
import com.example.appsportshop.api.UserAPI;
import com.example.appsportshop.model.Cart;
import com.example.appsportshop.model.Product;
import com.example.appsportshop.utils.SingletonUser;
import com.example.appsportshop.utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

//trạng thái đơn hàng
public class FragWaitConfirm extends Fragment {

 // danh sách sản phẩm trong đơn hàng chờ duyệt
    public ArrayList<Cart> orderWating;

    ListView listViewOrder;
    OrderAdapter orderAdapter;
    ImageView btnReturn, notItemOrder,ic_find;
    LinearLayout exsitOrder;
    SearchView searchView;

    EditText startDate, endDate;
    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    SingletonUser singletonUser = SingletonUser.getInstance();


    private OnBackPressedCallback callback;

    private void mapping(View view) {
        listViewOrder = view.findViewById(R.id.listViewWaitOrder);
        exsitOrder = view.findViewById(R.id.exsitOrderWait);
        btnReturn = view.findViewById(R.id.returnOrderWait);
        notItemOrder = view.findViewById(R.id.notItemOrderWait);

        searchView = view.findViewById(R.id.search_order);
        searchView.setQueryHint("Nhập vào thông sản phẩm để tìm kiếm");

        startDate = view.findViewById(R.id.start_date);
        endDate = view.findViewById(R.id.end_date);
        ic_find = view.findViewById(R.id.ic_find);
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
        View view = inflater.inflate(R.layout.frag_wait_confirm, container, false);
        //lấy dữ liệu đc gửi từ trang Main

        mapping(view);

        try {

            String curDay = currentDate.format(dateFormatter); // ngày hiện tại
            LocalDate minusDays = currentDate.minusDays(30); // ngày hiện tại trừ đi 1 tháng
            String oldDay = minusDays.format(dateFormatter);
            startDate.setText(oldDay);
            endDate.setText(curDay);

            getOrderItemByIdUser(oldDay, curDay);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        setEvent();


        return view;
    }
    private void setEvent() {
        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialogStart(view);
            }
        });

        endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialogEnd(view);
            }
        });

        listViewOrder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String idProduct = orderWating.get(i).getIdProduct();
                Intent intent = new Intent(getContext(), ProductDetail.class);

                intent.putExtra("idProduct",idProduct);
//                OrderItem.isChose = true;
//                intent.putExtra("tongTien",tongTien.getText().toString());
                startActivity(intent);

            }
        });


        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragHome.isDispHomeCustommer= true;
                startActivity(new Intent(getContext(), Main_Customer.class));
            }
        });
        ic_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    getOrderItemByIdUser(startDate.getText().toString().trim(), endDate.getText().toString().trim());
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
//                productManagerAdapter.getFilter().filter(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
//                productManagerAdapter.getFilter().filter(s);
                ArrayList<Cart> list = new ArrayList<>();
                try {
                    for (Cart product : orderWating
                    ) {

                        if (product.getNameProduct().toLowerCase().contains(s.toLowerCase()))  {
                            list.add(product);
                        }
                    }
                    orderAdapter = new OrderAdapter(getContext(), R.layout.row_order, list);
                    listViewOrder.setAdapter(orderAdapter);


                    return false;
                }catch (Exception e) {
                    return false;
                }

            }
        });
    }
    private void getOrderItemByIdUser(String start, String end) throws JSONException {
        JSONObject postData = new JSONObject();

        postData.put("date_start", start);
        postData.put("date_end", end);
        UserAPI.ApiPostandBody(getContext(), Utils.BASE_URL + "order/by-user/" + singletonUser.getIdUser(),postData ,  new APICallBack() {
            @Override
            public void onSuccess(JSONObject response) throws JSONException {
                JSONArray listcartJSON = response.getJSONArray("data");
                orderWating = new ArrayList<>();
                Log.d("nhonam", response.toString());
                for (int i = 0; i < listcartJSON.length(); i++) {
                    JSONObject cartTmpObj = (JSONObject) listcartJSON.get(i);
//

                    Cart cartTemp = new Cart();
                    cartTemp.setId(cartTmpObj.getLong("id_order"));
                    cartTemp.setQuantity(cartTmpObj.getInt("quantity"));
                    cartTemp.setPrice_total(cartTmpObj.getLong("price"));
                    cartTemp.setUrlImage(cartTmpObj.getString("image_url"));
                    cartTemp.setNameProduct(cartTmpObj.getString("product_name"));
                    cartTemp.setIdProduct(cartTmpObj.getString("id_product"));
                    cartTemp.setId_order_status(cartTmpObj.getLong("id_order_status"));

                        orderWating.add(cartTemp);

                }


                try {
                    if (orderWating.size()==0 || orderWating == null || orderWating.isEmpty()){
                        showViewNotList();
                    }else
                    {
                        exsitOrder.setVisibility(View.GONE);
                        searchView.setVisibility(View.VISIBLE);
                        notItemOrder.setVisibility(View.GONE);
                        orderAdapter = new OrderAdapter(getContext(), R.layout.row_order, orderWating);
                        listViewOrder.setAdapter(orderAdapter);
                    }
                }catch (Exception e) {
                    showViewNotList();
                }



            }

            @Override
            public void onError(VolleyError error) {

            }
        });
    }

    public void showDatePickerDialogStart(View v) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        c.set(year, monthOfYear, dayOfMonth);
                        EditText editTextDate = v.findViewById(R.id.start_date);
                        editTextDate.setText(simpleDateFormat.format(c.getTime()));

                    }
                }, year, month, day);
        datePickerDialog.show();
    }

    public void showDatePickerDialogEnd(View v) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        c.set(year, monthOfYear, dayOfMonth);
                        EditText editTextDate = v.findViewById(R.id.end_date);
                        editTextDate.setText(simpleDateFormat.format(c.getTime()));


                    }
                }, year, month, day);


        datePickerDialog.show();


    }

    private void showViewNotList(){
        exsitOrder.setVisibility(View.VISIBLE);
        Glide.with(getContext()).load("https://res.cloudinary.com/dzljztsyy/image/upload/v1700463449/shop_sport/avatart%20default/vyipv8h4fjgwheq2f37i.jpg").into(notItemOrder);
        searchView.setVisibility(View.GONE);
        notItemOrder.setVisibility(View.VISIBLE);
        listViewOrder.setVisibility(View.GONE);
    }

}
