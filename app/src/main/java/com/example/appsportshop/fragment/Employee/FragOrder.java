package com.example.appsportshop.fragment.Employee;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.example.appsportshop.R;
import com.example.appsportshop.activity.ChangePassW;
import com.example.appsportshop.activity.Main_Customer;
import com.example.appsportshop.adapter.ItemOrderAdapter;
import com.example.appsportshop.adapter.OrderAdminAdapter;
import com.example.appsportshop.adapter.ProductManagerAdapter;
import com.example.appsportshop.api.APICallBack;
import com.example.appsportshop.api.APICommon;
import com.example.appsportshop.api.UserAPI;
import com.example.appsportshop.fragment.Customer.FragHome;
import com.example.appsportshop.model.Bill;
import com.example.appsportshop.model.Order;
import com.example.appsportshop.model.OrderItem;
import com.example.appsportshop.model.Product;
import com.example.appsportshop.utils.CustomToast;
import com.example.appsportshop.utils.PdfExporter;
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
import java.util.List;

public class FragOrder extends Fragment {
    List<OrderItem> listOrderItemClick = new ArrayList<>();

    private ArrayList<Order> listOrder;
    List<Bill> hoaDonList;
    ListView listViewOrder;
    OrderAdminAdapter orderAdminAdapter;
    int idStautsOrder;
    ImageView ic_find;

    EditText startDate, endDate;
    LocalDate currentDate = LocalDate.now();
    SearchView seacrch_Order;
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.frag_manager_order_shop, container, false);
        //lấy dữ liệu đc gửi từ trang ManagerShop

        mapping(view);

        try {

            // Get the current date

            String curDay = currentDate.format(dateFormatter); // ngày hiện tại
            LocalDate minusDays = currentDate.minusDays(30); // ngày hiện tại trừ đi 1 tháng
            String oldDay = minusDays.format(dateFormatter);
            startDate.setText(oldDay);
            endDate.setText(curDay);
            getListOrderByDate(oldDay, curDay);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }


        return view;
    }



    private void mapping(View view) {
        listViewOrder = view.findViewById(R.id.listviewManagerOrder);
        startDate = view.findViewById(R.id.start_date);
        endDate = view.findViewById(R.id.end_date);
        ic_find = view.findViewById(R.id.ic_find);
        seacrch_Order = view.findViewById(R.id.seacrch_Order);



    }

    private void setEvent() {
        FragSell.isSell = false;
        orderAdminAdapter = new OrderAdminAdapter(getContext(), R.layout.row_manager_order, listOrder);
//        System.out.println(orderAdapter);
        listViewOrder.setAdapter(orderAdminAdapter);



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

        ic_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    getListOrderByDate(startDate.getText().toString().trim(), endDate.getText().toString().trim());
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        listViewOrder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Order
                try {
                    showOrderItems(listOrder.get(i).getId(), listOrder.get(i).getPhoneNumber(), listOrder.get(i).getShippingAdress(),
                            listOrder.get(i).getName_ceciver(), listOrder.get(i).getIdOderStatus());
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        seacrch_Order.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
//                productManagerAdapter.getFilter().filter(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
//                productManagerAdapter.getFilter().filter(s);
                ArrayList<Order> list = new ArrayList<>();
                for (Order order : listOrder
                ) {

                    if (order.getPhoneNumber().toLowerCase().contains(s.toLowerCase()) || String.valueOf( order.getId()).toLowerCase().contains(s.toLowerCase())  )  {
                        list.add(order);
                    }
                }
                orderAdminAdapter = new OrderAdminAdapter(getContext(), R.layout.row_manager_order, list);
//        System.out.println(orderAdapter);
                listViewOrder.setAdapter(orderAdminAdapter);

                return false;
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

    private void showOrderItems(String idOrder, String phone, String adressShip, String nameReciver, String idOrderStatus) throws JSONException {
        Dialog dialog = new Dialog(getContext());
        //
        UserAPI.ApiGet(getContext(), Utils.BASE_URL + "order-employee/detail/" + idOrder, new APICallBack() {
            @Override
            public void onSuccess(JSONObject response) throws JSONException {


                JSONArray jsonArray = response.getJSONArray("data");
                OrderItem orderItem;
                listOrderItemClick = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject tmp = (JSONObject) jsonArray.get(i);
                    orderItem = new OrderItem();
                    orderItem.setId(tmp.getInt("id"));
                    orderItem.setPrice(Float.parseFloat(tmp.getString("price")));
                    orderItem.setProductName(tmp.getString("product_name"));
                    orderItem.setQuantity(Integer.parseInt(tmp.getString("quantity")));
                    orderItem.setImage_url(tmp.getString("image_url"));

                    listOrderItemClick.add(orderItem);

                }

                dialog.setContentView(R.layout.order_item_list);
                ListView listView_orderItem = dialog.findViewById(R.id.listview_itemorder);
                ItemOrderAdapter orderAdminAdapter = new ItemOrderAdapter(dialog.getContext(), R.layout.row_item_order, (ArrayList<OrderItem>) listOrderItemClick);
                listView_orderItem.setAdapter(orderAdminAdapter);

                Button confirm = dialog.findViewById(R.id.confirm);
                Button cancelOrder = dialog.findViewById(R.id.cancelOrder);
                Spinner spinner = dialog.findViewById(R.id.order_status);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(dialog.getContext(), R.array.spinner_values, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
                if (idOrderStatus.equalsIgnoreCase("1")){
                    spinner.setSelection(0);
                }
                if (idOrderStatus.equalsIgnoreCase("2")){
                    spinner.setSelection(1);
                }
                if (idOrderStatus.equalsIgnoreCase("3")){
                    spinner.setSelection(2);
                }
                if (idOrderStatus.equalsIgnoreCase("4")){
                    spinner.setSelection(3);
                }
                if (idOrderStatus.equalsIgnoreCase("5")){
                    spinner.setSelection(4);
                }


                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        String selectedItem = parent.getItemAtPosition(position).toString();

                          idStautsOrder =  ProcessStatusOrder(selectedItem, idOrder, dialog.getContext());

                        Log.d("123", selectedItem);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        // Handle the case where no item is selected
                    }
                });

                cancelOrder.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog.dismiss();
                    }
                });

                confirm.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            ApiCHangeStatusOrder(idOrder, idStautsOrder, dialog.getContext(), adressShip, phone, nameReciver);
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }




            @Override
            public void onError(VolleyError error) {

            }
        });

    }

    private  void ApiCHangeStatusOrder( String idOrder, int idStatus, Context context, String adressShip, String phone, String nameReciver) throws JSONException {
        JSONObject body = new JSONObject();
        body.put("id_order_status", idStatus);
        body.put("id_user", SingletonUser.getInstance().getIdUser());
        body.put("email", SingletonUser.getInstance().getEmail());
        APICommon.APIPostWithJWT(context, "order-employee/update-status-order/" + idOrder, body, new APICallBack() {
            @Override
            public void onSuccess(JSONObject response) throws JSONException {


//                    Log.d("123213", (response.getString("message")));
//                    Log.d("123213", String.valueOf(response.getString("message").equalsIgnoreCase("1")));
                    Log.d("nhonampro", (response.getString("message")));

                    if (response.get("data").toString().equalsIgnoreCase("0")){
                        CustomToast.makeText(context, "Chuyển trạng thái đơn hàng sai!", CustomToast.LENGTH_SHORT, CustomToast.WARNING, true).show();

                    }else {

                        if (response.getString("message").equalsIgnoreCase("1")) {
                            PdfExporter.exportBillOrder(getContext(),listOrderItemClick ,"HoaDon"+idOrder+".pdf", adressShip, phone, nameReciver);
                            CustomToast.makeText(context, "Mở tệp tin để xem hóa đơn bán hàng !", CustomToast.LENGTH_SHORT, CustomToast.SUCCESS, true).show();

                        }
                        CustomToast.makeText(context, "Chuyển trạng thái đơn hàng thành công", CustomToast.LENGTH_SHORT, CustomToast.SUCCESS, true).show();

                    }
                getListOrderByDate(startDate.getText().toString(), endDate.getText().toString());
                orderAdminAdapter = new OrderAdminAdapter(requireContext(), R.layout.row_manager_order, listOrder);
//        System.out.println(orderAdapter);
                listViewOrder.setAdapter(orderAdminAdapter);





            }

            @Override
            public void onError(VolleyError error) {


            }
        });
    }

    private int ProcessStatusOrder(String selectedItem, String idOrder, Context context)  {
        int idStatus = 1;
        if (selectedItem.equalsIgnoreCase("Đang chờ xác nhận")) {
            idStatus = 1;
        }
        if (selectedItem.equalsIgnoreCase("Đã xác nhận")) {
            idStatus = 2;
        }
        if (selectedItem.equalsIgnoreCase("Đang giao")) {
            idStatus = 3;
        }
        if (selectedItem.equalsIgnoreCase("Đã giao")) {
            idStatus = 4;
        }
        if (selectedItem.equalsIgnoreCase("Đã hủy")) {
            idStatus = 5;
        }
        return  idStatus;

    }

    private void getListOrderByDate(String start, String end) throws JSONException {
        JSONObject postData = new JSONObject();

        postData.put("date_start", start);
        postData.put("date_end", end);
        UserAPI.ApiPostandBody(getContext(), Utils.BASE_URL + "order-employee/all", postData, new APICallBack() {
            @Override
            public void onSuccess(JSONObject response) throws JSONException {
                listOrder = new ArrayList<>();

//                Log.d("000",response.get("data").toString());

                 if (response.get("data").toString() != "[]" || response.getInt("data") != 0) {
                    JSONArray dataArr = (JSONArray) response.get("data");
                    JSONObject data; //item data in dataArr
                    for (int i = 0; i < dataArr.length(); i++) {
                        Order orderTmp = new Order();
                        data = (JSONObject) dataArr.get(i);
                        orderTmp.setId(data.getString("id"));
                        orderTmp.setOrderDate(data.getString("orderDate"));
                        orderTmp.setName_ceciver(data.getString("name_reciver"));
                        orderTmp.setShippingAdress(data.getString("shippingAdress"));
                        orderTmp.setPhoneNumber(data.getString("sdt"));
                        JSONObject tmp = (JSONObject) data.get("orderStatus");
                        orderTmp.setIdOderStatus(tmp.getString("id"));
                        listOrder.add(orderTmp);
                    }
                }

                setEvent();
            }

            @Override
            public void onError(VolleyError error) {

            }
        });
    }



}
