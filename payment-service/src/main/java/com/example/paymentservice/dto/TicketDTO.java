package com.example.paymentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDTO {
    private String ticket_id;
    private String entrance_user_id;
    private String entrance_location;
    private String exit_user_id;
    private String exit_location;
    private LocalDate entrance_date;
    private LocalDate exit_date;
    private LocalTime entrance_time;
    private LocalTime exit_time;
    private String travel_time;
    private Double average_speed;
}
