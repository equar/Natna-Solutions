package com.natna.forces.customer;

import com.natna.forces.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long customerId,Customer customerDetails) throws ResourceNotFoundException {
        Customer customer =
                customerRepository
                        .findById(customerId)
                        .orElseThrow(() -> new ResourceNotFoundException("Customer not found on :: " + customerId));

        customer.setEmail(customerDetails.getEmail());

        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long customerId) throws ResourceNotFoundException {

        Customer customer =
                customerRepository
                        .findById(customerId)
                        .orElseThrow(() -> new ResourceNotFoundException("Customer not found on :: " + customerId));

        customerRepository.delete(customer);
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
