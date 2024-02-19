package com.natna.forces.payment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Table(name = "payment")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Long paymentId;
    private Long billId;
    private Double amountPaid;
    private Date paymentDate;
    private String paymentMethod;
    private String paymentStatus;
    private String paymentConfirmationNumber;
    private String transactionId;
    private String paymentSource;
    private String paymentGateway;
    private String paymentCurrency;
    private String paymentReference;
    private String paymentNotes;
    private String paymentRecipient;
    private String paymentPurpose;
    private String paymentAuthorizationCode;

}
