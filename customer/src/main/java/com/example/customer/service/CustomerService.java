package com.example.customer.service;

import com.example.customer.dto.request.CustomerRequest;
import com.example.customer.dto.response.ApiResponse;
import com.example.customer.dto.response.CustomerResponse;
import com.example.customer.entity.CustomerEntity;
import com.example.customer.exception.ServiceException;

public interface CustomerService {

    ApiResponse getCustomerDetais(long id) throws ServiceException;

    ApiResponse saveCustomerDetais(CustomerRequest request);
}
