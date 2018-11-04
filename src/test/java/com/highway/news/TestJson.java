package com.highway.news;

import com.alibaba.fastjson.JSONObject;

public class TestJson {


    public static void main(String [] args){
        String returnUrl =  "wwwwww";
        JSONObject kkk=new JSONObject();
        kkk.put("url", returnUrl);
        System.out.println(kkk);
    }
}
