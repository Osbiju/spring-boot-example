package com.amigoscode.customer;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component // los dos son lo mismo, pero service es mas especifico
@Service
public class CustomerService {

    private final CustomerDAO customerDAO;

    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public List<Customer> getAllCustomers(){
        return customerDAO.selectAllCustomers();
    }

    public Customer getCustomers(Integer id){
        return customerDAO.selectCustomersById(id)
                .orElseThrow(() -> new IllegalArgumentException
                        (String.format("Customer with id [%d] not found", id)));

    }
}
