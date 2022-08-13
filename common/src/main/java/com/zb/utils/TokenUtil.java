package com.zb.utils;

import lombok.Data;

import java.util.UUID;

@Data
public class TokenUtil {

    public static String getToken(){
        String s = UUID.randomUUID().toString().replaceAll("-", "");
        return s;
    }

}
