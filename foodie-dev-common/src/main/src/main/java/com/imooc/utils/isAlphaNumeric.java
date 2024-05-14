package com.imooc.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class isAlphaNumeric {

    public  static  boolean isAlphaNumeric(String str)
    {
        String regex = "^[a-zA-Z0-9!@#$%^&*()「」（）…,.?\\\":{}|<>]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

     return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(isAlphaNumeric("%12&%……&*）"));
    }
}
