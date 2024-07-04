package com.example.paymentservice.controller;

import com.example.paymentservice.dto.PaymentDTO;
import com.example.paymentservice.dto.TicketDTO;
import com.example.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;
    private final RestTemplate restTemplate;

    @GetMapping("/okay")
    public String okay() {
        return "ready to use payment service";
    }

    @PostMapping
    public String savePayment(@RequestBody PaymentDTO paymentDTO){
        paymentService.savePayment(paymentDTO);
        return "successfully saved payment " + paymentDTO.toString();
    }

    @GetMapping("/payments")
    public List<PaymentDTO> getAllPayments(){
        return paymentService.getAllPayments();
    }

    @PutMapping("/update_ticket")
    public String updateTicket(@RequestParam String ticket_id,@RequestBody TicketDTO ticketDTO){
        String url = "http://localhost:8084/api/v1/ticket/update_ticket?ticket_id="+ticket_id;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<TicketDTO> entity = new HttpEntity<>(ticketDTO, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
        return "successfully updated ticket " + response.getBody();
    }


}
