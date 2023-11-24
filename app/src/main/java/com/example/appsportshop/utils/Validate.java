package com.example.appsportshop.utils;

import java.util.regex.Pattern;

public class Validate {

    private static final String PHONE_REGEX = "^0\\d{9,10}$";

    public static boolean isValidPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        return pattern.matcher(phoneNumber).matches();
    }
}
