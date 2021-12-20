package com.example.movieticketing.service;

import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class UtilityService {

    public static Boolean notNullOrEmpty(String string){
        return string != null && string.length()>0;
    }

    public String encode(String string) {
        Base64.Encoder encoder = Base64.getEncoder();
        String encodedString = encoder.encodeToString(string.getBytes());
        return encodedString;
    }

    public String decode(String string) {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] bytes = decoder.decode(string);
        return new String(bytes);
    }


}
