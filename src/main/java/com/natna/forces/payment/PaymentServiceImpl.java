package com.natna.forces.payment;

import com.natna.forces.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements IPaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment updatePayment(Long paymentId,Payment paymentDetails) throws ResourceNotFoundException {
        Payment payment =
                paymentRepository
                        .findById(paymentId)
                        .orElseThrow(() -> new ResourceNotFoundException("Payment not found on :: " + paymentId));

        payment.setPaymentDate(paymentDetails.getPaymentDate());

        return paymentRepository.save(payment);
    }

    @Override
    public void deletePayment(Long paymentId) throws ResourceNotFoundException {

        Payment payment =
                paymentRepository
                        .findById(paymentId)
                        .orElseThrow(() -> new ResourceNotFoundException("Payment not found on :: " + paymentId));

        paymentRepository.delete(payment);
    }

    @Override
    public Payment getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId).orElse(null);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
}
