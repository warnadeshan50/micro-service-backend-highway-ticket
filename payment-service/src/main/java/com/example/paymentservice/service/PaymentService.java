package com.example.paymentservice.service;

import com.example.paymentservice.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {

    PaymentDTO savePayment(PaymentDTO ticketDTO);
    List<PaymentDTO> getAllPayments();
}
