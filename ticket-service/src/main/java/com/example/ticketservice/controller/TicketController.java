package com.example.ticketservice.controller;

import com.example.ticketservice.dto.TicketDTO;
import com.example.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ticket")
@RequiredArgsConstructor
public class TicketController {
    final private TicketService ticketService;


    @GetMapping("/okay")
    public String okay() {
        return "Ready to use ticket service";
    }
    @PostMapping
    public String EntryTicket(@RequestBody TicketDTO ticketDTO) {
        ticketService.saveTicket(ticketDTO);
        return "Vehicle entry successful";
    }
    @GetMapping
    public TicketDTO getTicket(String ticket_id){
        return ticketService.getSelectedTicket(ticket_id);
    }
    @PutMapping("/update_ticket")
    public String updateTicket(@RequestParam String ticket_id,@RequestBody TicketDTO ticketDTO) {
        ticketService.updateTicket(ticket_id,ticketDTO);
        return "Final updated ticket";
    }

}
