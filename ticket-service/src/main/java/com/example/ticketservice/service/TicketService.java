package com.example.ticketservice.service;

import com.example.ticketservice.dto.TicketDTO;

import java.util.List;

public interface TicketService {
    TicketDTO saveTicket(TicketDTO ticketDTO);
    void deleteTicket(String ticket_id);
    TicketDTO getSelectedTicket(String ticket_id);
    List<TicketDTO> getAllTicket();
    void updateTicket(String vehicle_id,TicketDTO ticketDTO);
}
