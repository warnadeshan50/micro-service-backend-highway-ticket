package com.example.ticketservice.service.impl;

import com.example.ticketservice.dto.TicketDTO;
import com.example.ticketservice.entity.TicketEntity;
import com.example.ticketservice.repositry.TicketDAO;
import com.example.ticketservice.service.TicketService;
import com.example.ticketservice.utill.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    final private TicketDAO ticketDAO;
    private final Mapping mapping;
    final private RestTemplate restTemplate;

    @Override
    public TicketDTO saveTicket(TicketDTO ticketDTO) {
        ticketDTO.setTicket_id(UUID.randomUUID().toString());
        ticketDTO.setEntrance_date(LocalDate.now());
        ticketDTO.setEntrance_time(LocalTime.now());
        return mapping.toTicketDTO(ticketDAO.save(mapping.toTicketEntity(ticketDTO)));
    }

    @Override
    public void deleteTicket(String ticket_id) {
        ticketDAO.deleteById(ticket_id);

    }

    @Override
    public TicketDTO getSelectedTicket(String ticket_id) {
        return mapping.toTicketDTO(ticketDAO.getById(ticket_id));
    }

    @Override
    public List<TicketDTO> getAllTicket() {
        return mapping.toTicketDTOList(ticketDAO.findAll());
    }

    @Override
    public void updateTicket(String ticket_id, TicketDTO ticketDTO) {
        Optional<TicketEntity> optionalTicket = ticketDAO.findById(ticket_id);
        if (optionalTicket.isPresent()) {
            TicketEntity existingTicket = optionalTicket.get();
            existingTicket.setExit_location(ticketDTO.getExit_location());
            existingTicket.setExit_date(LocalDate.now());
            LocalTime exitTime = LocalTime.now();
            existingTicket.setExit_time(exitTime);
            existingTicket.setTravel_time(getTravelTime(existingTicket.getEntrance_time(),exitTime));
            existingTicket.setExit_user_id(ticketDTO.getExit_user_id());
            ticketDAO.save(existingTicket);
        }
    }

    private String getTravelTime(LocalTime entranceTime, LocalTime exitTime) {
        // Get start time from user
        String en_t=entranceTime.format(DateTimeFormatter.ofPattern("HH:mm"));
        String e=exitTime.format(DateTimeFormatter.ofPattern("HH:mm"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime startTime = LocalTime.parse(en_t, formatter);
        LocalTime endTime = LocalTime.parse(e, formatter);
        String travelTime = calculateTravelTime(startTime, endTime);
        return travelTime;
    }

    private String calculateTravelTime(LocalTime startTime, LocalTime endTime) {
        Duration duration = Duration.between(startTime, endTime);
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;

        return String.format("%d hours %d minutes", hours, minutes);
    }
}
