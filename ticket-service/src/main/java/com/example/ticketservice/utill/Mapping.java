package com.example.ticketservice.utill;

import com.example.ticketservice.dto.TicketDTO;
import com.example.ticketservice.entity.TicketEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Mapping {
     final private ModelMapper mapper;

    public TicketDTO toTicketDTO(TicketEntity ticketEntity) {
        return  mapper.map(ticketEntity, TicketDTO.class);
    }
    public TicketEntity toTicketEntity(TicketDTO ticketDTO) {
        return  mapper.map(ticketDTO, TicketEntity.class);
    }
    public List<TicketDTO> toTicketDTOList(List<TicketEntity> ticketEntityList) {
        return mapper.map(ticketEntityList, List.class);
    }
}
