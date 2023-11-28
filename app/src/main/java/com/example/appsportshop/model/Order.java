package com.example.appsportshop.model;

public class Order {
    String id;
    String orderDate;
    String paymentDate;
    String shippingAdress;
    String shippingDate;
    String idCustomer;
    String idOderStatus;
    String name_ceciver;
    String phoneNumber;

    public Order() {

    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getShippingAdress() {
        return shippingAdress;
    }

    public void setShippingAdress(String shippingAdress) {
        this.shippingAdress = shippingAdress;
    }

    public String getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(String shippingDate) {
        this.shippingDate = shippingDate;
    }


    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdOderStatus() {
        return idOderStatus;
    }

    public void setIdOderStatus(String idOderStatus) {
        this.idOderStatus = idOderStatus;
    }


    public String getName_ceciver() {
        return name_ceciver;
    }

    public void setName_ceciver(String name_ceciver) {
        this.name_ceciver = name_ceciver;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
