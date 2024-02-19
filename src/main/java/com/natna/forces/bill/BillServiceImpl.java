package com.natna.forces.bill;

import com.natna.forces.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements IBillService {

    @Autowired
    private BillRepository billRepository;

    @Override
    public Bill addBill(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public Bill updateBill(Long billId,Bill billDetails) throws ResourceNotFoundException {
        Bill bill =
                billRepository
                        .findById(billId)
                        .orElseThrow(() -> new ResourceNotFoundException("Bill not found on :: " + billId));

        bill.setBillingAddress(billDetails.getBillingAddress());

        return billRepository.save(bill);
    }

    @Override
    public void deleteBill(Long billId) throws ResourceNotFoundException {

        Bill bill =
                billRepository
                        .findById(billId)
                        .orElseThrow(() -> new ResourceNotFoundException("Bill not found on :: " + billId));

        billRepository.delete(bill);
    }

    @Override
    public Bill getBillById(Long billId) {
        return billRepository.findById(billId).orElse(null);
    }

    @Override
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }
}
