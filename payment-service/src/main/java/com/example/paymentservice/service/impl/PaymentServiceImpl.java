package com.example.paymentservice.service.impl;

import com.example.paymentservice.dto.PaymentDTO;
import com.example.paymentservice.repositry.PaymentDAO;
import com.example.paymentservice.service.PaymentService;
import com.example.paymentservice.util.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    final private Mapping mapping;
    private final PaymentDAO paymentDAO;

    @Override
    public PaymentDTO savePayment(PaymentDTO ticketDTO) {
        ticketDTO.setPayment_id(UUID.randomUUID().toString());
        ticketDTO.setPayment_date_time(LocalDateTime.now());
        return mapping.toPaymentDTO(paymentDAO.save(mapping.toPaymentEntity(ticketDTO)));
    }

    @Override
    public List<PaymentDTO> getAllPayments() {
        return mapping.toPaymentDTOList(paymentDAO.findAll());
    }
}
