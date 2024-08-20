package com.example.customer.service.impl;

import com.example.customer.dto.request.CustomerRequest;
import com.example.customer.dto.response.ApiResponse;
import com.example.customer.entity.CustomerEntity;
import com.example.customer.exception.ServiceException;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static com.example.customer.util.ConsumerUtil.createApiResponse;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public ApiResponse getCustomerDetais(long id) throws ServiceException {

        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
        if (customerEntity.isPresent())
            return createApiResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
                    customerEntity.get());
        else
            throw new ServiceException("Unable to fetch customer details");
    }

    @Override
    public ApiResponse saveCustomerDetais(CustomerRequest request) {
        CustomerEntity entity = new CustomerEntity();
        BeanUtils.copyProperties(request, entity);
        return createApiResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
                customerRepository.save(entity));
    }
}
