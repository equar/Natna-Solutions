package com.natna.forces.biller;

import com.natna.forces.exception.ResourceNotFoundException;
import com.natna.forces.biller.Biller;

import java.util.List;

public interface IBillerService {
    Biller addBiller(Biller biller);

    Biller updateBiller(Long billerId, Biller biller) throws ResourceNotFoundException;

    void deleteBiller(Long billerId) throws ResourceNotFoundException;

    Biller getBillerById(Long billerId);

    List<Biller> getAllBillers();

}
