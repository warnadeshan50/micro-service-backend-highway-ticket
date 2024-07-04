package com.example.vehicleservice.service;

import com.example.vehicleservice.dto.VehicleDTO;

import java.util.List;

public interface VehicleService {
    VehicleDTO saveVehicle(VehicleDTO vehicleDTO);
    void deleteVehicle(String vehicle_id);
    VehicleDTO getSelectedVehicle(String vehicle_id);
    List<VehicleDTO> getAllVehicles();
    void updateVehicle(String vehicle_id,VehicleDTO vehicleDTO);
}
