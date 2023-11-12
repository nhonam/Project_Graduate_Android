package com.example.appsportshop.utils;

import java.text.DecimalFormat;

public class UtilCommon {

    public static String FormatPrice( Double price){
        DecimalFormat formatter = new DecimalFormat("#,###");
        String formattedValue = formatter.format( Double.valueOf(String.format("%.0f", price)));
        return formattedValue;
    }
}
