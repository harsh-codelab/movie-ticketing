package com.example.movieticketing.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ResponseEntity {

    public Boolean success;
    public ApiResponse response;
    public Object data;

}
