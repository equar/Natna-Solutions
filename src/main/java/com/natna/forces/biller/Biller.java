package com.natna.forces.biller;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "biller")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Biller {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Long billerId;
    private String billerName;
    private String category;
    private String contactInformation;
    private String address;
    private String website;
    private String paymentMethods;
    private String accountNumberFormat;
    private String billingFrequency;
    private String latePaymentPolicy;
    private String discountsPromotions;
    private String billingTerms;
    private String logoImage;
    private String taxInformation;
}
