package com.natna.forces.payment;

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
public class PaymentController {

  @Autowired
  private IPaymentService paymentService;

  @PostMapping("/payment")
  public Payment createPayment( @RequestBody Payment payment) {

    Payment paymentResponse = paymentService.addPayment(payment);
      return new ResponseEntity<>(paymentResponse, HttpStatus.CREATED).getBody();

  }

  @GetMapping("/payments")
  public List<Payment> getAllpayments() {
    return paymentService.getAllPayments();
  }

  @GetMapping("/payment/{id}")
  public ResponseEntity<Payment> getPaymentsById(@PathVariable(value = "id") Long paymentId)
      throws ResourceNotFoundException {

    Payment payment = paymentService.getPaymentById(paymentId);

    return ResponseEntity.ok().body(payment);
  }

  @PutMapping("/payment/{id}")
  public ResponseEntity<Payment> updatePayment(
      @PathVariable(value = "id") Long paymentId,  @RequestBody Payment paymentDetails)
      throws ResourceNotFoundException {

    Payment updatedpayment = paymentService.updatePayment(paymentId,paymentDetails);

    return ResponseEntity.ok(updatedpayment);
  }

  @DeleteMapping("/payment/{id}")
  public Map<String, Boolean> deletePayment(@PathVariable(value = "id") Long paymentId) throws Exception {

    paymentService.deletePayment(paymentId);

    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
}
