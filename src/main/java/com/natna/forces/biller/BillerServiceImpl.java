package com.natna.forces.biller;

import com.natna.forces.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillerServiceImpl implements IBillerService {

    @Autowired
    private BillerRepository billerRepository;

    @Override
    public Biller addBiller(Biller biller) {
        return billerRepository.save(biller);
    }

    @Override
    public Biller updateBiller(Long billerId, Biller billerDetails) throws ResourceNotFoundException {
        Biller biller =
                billerRepository
                        .findById(billerId)
                        .orElseThrow(() -> new ResourceNotFoundException("Biller not found on :: " + billerId));

        biller.setBillerName(billerDetails.getBillerName());

        return billerRepository.save(biller);
    }

    @Override
    public void deleteBiller(Long billerId) throws ResourceNotFoundException {

        Biller biller =
                billerRepository
                        .findById(billerId)
                        .orElseThrow(() -> new ResourceNotFoundException("Biller not found on :: " + billerId));

        billerRepository.delete(biller);
    }

    @Override
    public Biller getBillerById(Long billerId) {
        return billerRepository.findById(billerId).orElse(null);
    }

    @Override
    public List<Biller> getAllBillers() {
        return billerRepository.findAll();
    }
}
