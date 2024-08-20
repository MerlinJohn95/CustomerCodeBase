package com.example.customer.util;

import com.example.customer.dto.response.ApiResponse;

public class ConsumerUtil {

    public static <T> ApiResponse createApiResponse(int statusCode, String statusDesc, T data) {
        return ApiResponse.builder()
                .statusCode(statusCode)
                .statusDesc(statusDesc)
                .data(data)
                .build();
    }
}
