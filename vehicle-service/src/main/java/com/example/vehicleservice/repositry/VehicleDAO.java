package com.example.vehicleservice.repositry;

import com.example.vehicleservice.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleDAO extends JpaRepository<VehicleEntity, String> {

}
