package com.example.customer.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_DETAILS")
public class CustomerEntity {

    @Id
    private long id;
    private String name;
    private String email;
    private String address;
    private String dob;

}
