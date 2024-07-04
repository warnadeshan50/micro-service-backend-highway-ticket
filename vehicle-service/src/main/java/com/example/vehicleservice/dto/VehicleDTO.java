package com.example.vehicleservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO implements Serializable {
    private String vehicle_id;
    @NotNull
    private String user_id;
    @NotNull
    private String vehicle_owner;
    @NotNull
    private String vehicle_type;
    @NotNull
    private String vehicle_model;
    private LocalDateTime registration_date;
    private int amount_of_passengers;
}
