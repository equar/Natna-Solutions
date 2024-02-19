package com.natna.forces.biller;

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
public class BillerController {

  @Autowired
  private IBillerService billerService;

  @PostMapping("/biller")
  public Biller createbiller( @RequestBody Biller biller) {

    Biller billerResponse = billerService.addBiller(biller);
      return new ResponseEntity<>(billerResponse, HttpStatus.CREATED).getBody();

  }

  @GetMapping("/billers")
  public List<Biller> getAllbillers() {
    return billerService.getAllBillers();
  }

  @GetMapping("/biller/{id}")
  public ResponseEntity<Biller> getbillersById(@PathVariable(value = "id") Long billerId)
      throws ResourceNotFoundException {

    Biller biller = billerService.getBillerById(billerId);

    return ResponseEntity.ok().body(biller);
  }

  @PutMapping("/biller/{id}")
  public ResponseEntity<Biller> updateBiller(
      @PathVariable(value = "id") Long billerId,  @RequestBody Biller billerDetails)
      throws ResourceNotFoundException {

    Biller updatedbiller = billerService.updateBiller(billerId,billerDetails);

    return ResponseEntity.ok(updatedbiller);
  }

  @DeleteMapping("/biller/{id}")
  public Map<String, Boolean> deleteBiller(@PathVariable(value = "id") Long billerId) throws Exception {

    billerService.deleteBiller(billerId);

    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
}
