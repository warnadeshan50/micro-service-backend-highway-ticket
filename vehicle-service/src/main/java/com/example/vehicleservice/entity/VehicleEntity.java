package com.example.vehicleservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vehicle")
@Entity
public class VehicleEntity implements Serializable {
    @Id
    private String vehicle_id;
    @NotNull(message = "User id is mandatory")
    private String user_id;
    @NotNull(message = "Owner is mandatory")
    private String vehicle_owner;
    @NotNull(message = "Vehicle Model is mandatory")
    private String vehicle_model;
    @NotNull(message = "Vehicle type is mandatory")
    private String vehicle_type;
    private LocalDateTime registration_date;
    private int amount_of_passengers;
}
