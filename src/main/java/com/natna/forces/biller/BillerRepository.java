package com.natna.forces.biller;

import com.natna.forces.biller.Biller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BillerRepository extends JpaRepository<Biller, Long> {}
