package com.natna.forces.payment;

import com.natna.forces.exception.ResourceNotFoundException;
import com.natna.forces.payment.Payment;

import java.util.List;

public interface IPaymentService {

    Payment addPayment(Payment payment);

    Payment updatePayment(Long paymentId,Payment payment) throws ResourceNotFoundException;

    void deletePayment(Long paymentId) throws ResourceNotFoundException;

    Payment getPaymentById(Long paymentId);

    List<Payment> getAllPayments();

}
