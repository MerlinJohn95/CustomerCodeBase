package com.example.customer.dto.response;

import lombok.Data;

@Data
public class CustomerResponse {

    private long id;
    private String name;
    private String email;
    private String address;
    private String dob;
}
