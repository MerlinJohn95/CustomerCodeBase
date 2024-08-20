package com.example.customer.controller;

import com.example.customer.dto.request.CustomerRequest;
import com.example.customer.dto.response.ApiResponse;
import com.example.customer.dto.response.CustomerResponse;
import com.example.customer.entity.CustomerEntity;
import com.example.customer.exception.ServiceException;
import com.example.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/customer")
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/get/customer-details/{id}")
    public ApiResponse getCustomerDetails(@RequestParam long id) throws ServiceException {
        log.info("Fetching customer details for ID {}", id);
        ApiResponse response = customerService.getCustomerDetais(id);
        log.info("Returning customer details for {}", id);
        return response;
    }

    @PostMapping("/save/customer-details")
    public ApiResponse saveCustomerDetails(@RequestBody CustomerRequest request) {
        log.info("Saving customer details for request {}", request);
        ApiResponse response = customerService.saveCustomerDetais(request);
        log.info("Returning customer details for {}", response);
        return response;
    }

    @DeleteMapping("/delete/customer-details/{id}")
    public void deleteCustomerDetails(@RequestParam long id) {
        log.info("Removing customer details for ID {}", id);
        customerService.deleteCustomerById(id);
    }
    
    
}
