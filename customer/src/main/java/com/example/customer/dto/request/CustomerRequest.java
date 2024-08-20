package com.example.customer.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CustomerRequest {

    @NotNull
    private long id;
    private String name;
    private String email;
    private String address;
    private String dob;
}
