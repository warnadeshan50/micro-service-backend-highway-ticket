package com.example.paymentservice.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {

    private String payment_id;
    @NotNull
    private String payment_type;
    @NotNull
    private double payment_amount;
    @NotNull
    private LocalDateTime payment_date_time;
}
