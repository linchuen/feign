package com.cooba.dto;

import lombok.Data;

@Data
public class Response<T> {

    private String id;
    private T data;
}
