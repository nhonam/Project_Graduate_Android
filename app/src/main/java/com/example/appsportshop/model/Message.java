package com.example.appsportshop.model;

public class Message {

    private String fullname;
    private String text;
    private String avatar_url ;
    private boolean isSenter;

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
        this.avatar_url = avatar_url;
        this.isSenter = isSenter;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public boolean isSenter() {
        return isSenter;
    }

    public void setSenter(boolean senter) {
        isSenter = senter;
    }
}
