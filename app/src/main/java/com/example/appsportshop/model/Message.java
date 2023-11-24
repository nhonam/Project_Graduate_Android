package com.example.appsportshop.model;

public class Message {

    private String fullname;
    private String text;
    private String image_product;

    private String product_name;

    private boolean isSenter;

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Message() {

    }
    public Message(String text, String avatar_url, boolean isSenter) {
        this.text = text;
        this.image_product = avatar_url;
        this.isSenter = isSenter;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage_product() {
        return image_product;
    }

    public void setImage_product(String image_product) {
        this.image_product = image_product;
    }

    public boolean isSenter() {
        return isSenter;
    }

    public void setSenter(boolean senter) {
        isSenter = senter;
    }
}
