package com.natna.forces.bill;

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
public class BillController {

  @Autowired
  private IBillService billService;

  @PostMapping("/bill")
  public Bill createbill( @RequestBody Bill bill) {

      Bill billResponse = billService.addBill(bill);
      return new ResponseEntity<>(billResponse, HttpStatus.CREATED).getBody();

  }

  @GetMapping("/bills")
  public List<Bill> getAllBills() {
    return billService.getAllBills();
  }

  @GetMapping("/bill/{id}")
  public ResponseEntity<Bill> getBillsById(@PathVariable(value = "id") Long billId)
      throws ResourceNotFoundException {

    Bill bill = billService.getBillById(billId);

    return ResponseEntity.ok().body(bill);
  }

  @PutMapping("/bill/{id}")
  public ResponseEntity<Bill> updateBill(
      @PathVariable(value = "id") Long billId,  @RequestBody Bill billDetails)
      throws ResourceNotFoundException {

    Bill updatedbill = billService.updateBill(billId,billDetails);

    return ResponseEntity.ok(updatedbill);
  }

  @DeleteMapping("/bill/{id}")
  public Map<String, Boolean> deleteBill(@PathVariable(value = "id") Long billId) throws Exception {

    billService.deleteBill(billId);

    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }

  @GetMapping("/bills/biller/{id}")
  public List<Bill> getAllBillerBills() {
    return billService.getAllBills();
  }

  @GetMapping("/bills/customer/{id}")
  public List<Bill> getAllCustomerBills() {
    return billService.getAllBills();
  }
}


