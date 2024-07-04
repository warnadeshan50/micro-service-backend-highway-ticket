package com.example.paymentservice.repositry;

import com.example.paymentservice.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDAO extends JpaRepository<PaymentEntity, String> {
}
