package com.example.ticketservice.repositry;

import com.example.ticketservice.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketDAO extends JpaRepository<TicketEntity, String> {
}
