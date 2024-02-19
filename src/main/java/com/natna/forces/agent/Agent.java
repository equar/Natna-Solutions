package com.natna.forces.agent;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "agent")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Long agentId;
    private String agentName;
    private String location;
    private String contactInformation;
    private String servicesOffered;
    private String operatingHours;
    private double commissionRate;
    private String paymentMethodsAccepted;
    private String languagesSpoken;
    private String additionalServices;
    private String agentCode;
    private String affiliations;
    private String logoImage;
    private double rating;
    private String reviews;
    private String status;
}
