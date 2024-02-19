package com.natna.forces.bill;

import com.natna.forces.exception.ResourceNotFoundException;
import com.natna.forces.bill.Bill;

import java.util.List;

public interface IBillService {

    Bill addBill(Bill bill);

    Bill updateBill(Long billId,Bill bill) throws ResourceNotFoundException;

    void deleteBill(Long billId) throws ResourceNotFoundException;

    Bill getBillById(Long billId);

    List<Bill> getAllBills();

}
