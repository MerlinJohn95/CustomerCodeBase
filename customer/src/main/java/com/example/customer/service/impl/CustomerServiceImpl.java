package com.example.customer.service.impl;

import com.example.customer.dto.request.CustomerRequest;
import com.example.customer.dto.response.ApiResponse;
import com.example.customer.entity.CustomerEntity;
import com.example.customer.exception.ServiceException;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

import static com.example.customer.constants.CustomerConstants.CUSTOMER_FETCH_FAILURE;
import static com.example.customer.util.ConsumerUtil.createApiResponse;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public ApiResponse getCustomerDetais(long id) throws ServiceException {
        try {
            Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
            if (customerEntity.isPresent())
                return createApiResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
                        customerEntity.get());
            else
                throw new ServiceException(CUSTOMER_FETCH_FAILURE);
        } catch (Exception ex) {
            log.error("Exception while fetching customer details");
            return createApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    HttpStatus.INTERNAL_SERVER_ERROR.name(), ex.getMessage());
        }
    }

    @Override
    @Transactional
    public ApiResponse saveCustomerDetais(CustomerRequest request) {
        CustomerEntity entity = new CustomerEntity();
        BeanUtils.copyProperties(request, entity);
        return createApiResponse(HttpStatus.OK.value(), HttpStatus.OK.name(),
                customerRepository.save(entity));
    }

    @Transactional
    @Override
    public void deleteCustomerById(long id) {
        customerRepository.deleteById(id);
    }

}
