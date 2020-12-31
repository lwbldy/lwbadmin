package com.pearadmin;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class TestURL {
    public static void main(String[] args) {
//        String s = "http://SomeUser:mypassword@www.some_server.com:8080/path/file.html";
//        System.out.println(URLEncoder.encode(s));

        try{
            String s = "https://ditu.amap.com/marker?markers=114.926367,25.815586,%E4%B8%87%E8%B1%A1%E5%9F%8E%E5%88%86%E9%99%A2%7C114.932993,25.842853,%E5%8D%97%E6%B2%B3%E8%B7%AF%C2%B7%E6%80%BB%E9%99%A2&src=mypage&callnative=0&innersrc=uriapi";
            System.out.println(URLDecoder.decode(s, "utf-8"));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
