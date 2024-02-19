package com.natna.forces.customer;

import com.natna.forces.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

  @Autowired
  private ICustomerService customerService;

  @PostMapping("/customer")
  public Customer createCustomer( @RequestBody Customer customer) {

    Customer customerResponse = customerService.addCustomer(customer);
      return new ResponseEntity<>(customerResponse, HttpStatus.CREATED).getBody();

  }

  @GetMapping("/customers")
  public List<Customer> getAllcustomers() {
    return customerService.getAllCustomers();
  }

  @GetMapping("/customer/{id}")
  public ResponseEntity<Customer> getCustomersById(@PathVariable(value = "id") Long customerId)
      throws ResourceNotFoundException {

    Customer customer = customerService.getCustomerById(customerId);

    return ResponseEntity.ok().body(customer);
  }

  @PutMapping("/customer/{id}")
  public ResponseEntity<Customer> updateCustomer(
      @PathVariable(value = "id") Long customerId,  @RequestBody Customer customerDetails)
      throws ResourceNotFoundException {

    Customer updatedcustomer = customerService.updateCustomer(customerId,customerDetails);

    return ResponseEntity.ok(updatedcustomer);
  }

  @DeleteMapping("/customer/{id}")
  public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Long customerId) throws Exception {

    customerService.deleteCustomer(customerId);

    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
}
