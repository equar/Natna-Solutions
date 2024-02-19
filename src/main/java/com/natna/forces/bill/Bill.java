package com.natna.forces.bill;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Table(name = "bill")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Long billId;
    private String billerName;
    private Double billAmount;
    private Date dueDate;
    private Date issueDate;
    private String paymentStatus;
    private String paymentMethod;
    private String billDescription;
    private String billingAddress;
    private String accountNumber;
    private Double lateFee;
    private Double discounts;
    private Double tax;
    private Double totalAmountDue;
    private Double additionalCharges;
}
