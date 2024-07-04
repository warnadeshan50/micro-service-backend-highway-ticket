package com.example.paymentservice.util;

import com.example.paymentservice.dto.PaymentDTO;
import com.example.paymentservice.entity.PaymentEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Mapping {
    private final ModelMapper mapper;

    public PaymentDTO toPaymentDTO(PaymentEntity paymentEntity) {
        return  mapper.map(paymentEntity, PaymentDTO.class);
    }
    public PaymentEntity toPaymentEntity(PaymentDTO paymentDTO) {
        return  mapper.map(paymentDTO, PaymentEntity.class);
    }
    public List<PaymentDTO> toPaymentDTOList(List<PaymentEntity> paymentEntityList) {
        return mapper.map(paymentEntityList, List.class);
    }

}
