package com.natna.forces.customer;

import com.natna.forces.exception.ResourceNotFoundException;
import com.natna.forces.customer.Customer;

import java.util.List;

public interface ICustomerService {

    Customer addCustomer(Customer customer);

    Customer updateCustomer(Long CustomerId,Customer customer) throws ResourceNotFoundException;

    void deleteCustomer(Long CustomerId) throws ResourceNotFoundException;

    Customer getCustomerById(Long CustomerId);

    List<Customer> getAllCustomers();

}
