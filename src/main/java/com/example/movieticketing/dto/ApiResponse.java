package com.example.movieticketing.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ApiResponse {

    ADD_SUCCESSFUL(1,"Show Added Successfully"),
    LIST_FETCHED(2,"List Fetched Successfully"),
    SIGN_UP(3,"User SignUp Successfully"),
    LOGGED_IN(4,"Hey !! , Welcome Back"),
    SHOW_BOOKED(5,"Show Booked Successfully"),
    LOGIN_REQUIRED(6,"Require login for this operation"),
    LOGIN_FAILED(7,"Invalid Credentials"),
    LOGGED_OUT(8,"User Logout Successfully"),
    NO_RECORDS(9,"No Data Found"),


    SOMETHING_WENT_WRONG(500,"Something Went Wrong");


    private final Integer code;
    private final String description;
}
