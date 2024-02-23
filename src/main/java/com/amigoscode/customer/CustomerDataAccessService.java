package com.amigoscode.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("addingvalueif needed")
public class CustomerDataAccessService implements CustomerDAO {

    //db

    private static List<Customer> customers;

    static {
        customers = new ArrayList<>();
        Customer alex = new Customer(1, "Alex", "alex@gmail.com", 21);
        customers.add(alex);

        Customer Jamila = new Customer(2, "Jamila", "Jamila@gmail.com", 19);
        customers.add(Jamila);

    }

    @Override
    public List<Customer> selectAllCustomers() {
        return customers;
    }

    @Override
    public Optional<Customer> selectCustomersById(Integer id) {
        return customers.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }
}
