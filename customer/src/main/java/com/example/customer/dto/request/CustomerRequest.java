package com.example.customer.dto.request;

import javax.validation.constraints.NotNull;

public class CustomerRequest {
    
    @NotNull
    private String name;
    private String email;
    private String address;
    private String dob;
}
