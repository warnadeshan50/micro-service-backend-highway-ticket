package com.example.paymentservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="payment")
public class PaymentEntity {
    @Id
    private String payment_id;
    @NotNull(message = "Type of payment is mandatory")
    private String payment_type;
    @NotNull(message = "Payment is mandatory")
    private double payment_amount;
    private LocalDateTime payment_date_time;

}
