package com.example.vehicleservice.controller;

import com.example.vehicleservice.dto.VehicleDTO;
import com.example.vehicleservice.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicle")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @GetMapping("/okay")
    public String okay() {
        return "ready to use vehicle service";
    }

    @PostMapping
    public String registerVehicle(@RequestBody VehicleDTO vehicleDTO){
        vehicleService.saveVehicle(vehicleDTO);
        return "registered a vehicle";
    }

    @GetMapping
    public VehicleDTO getVehicle(@RequestParam String vehicle_id){
        return vehicleService.getSelectedVehicle(vehicle_id);
    }

    @DeleteMapping
    public String deleteVehicle(@RequestParam String vehicle_id){
        vehicleService.deleteVehicle(vehicle_id);
        return "deleted vehicle "+vehicle_id;
    }

    @GetMapping("/vehicles")
    public List<VehicleDTO> getAllVehicles(){
        return vehicleService.getAllVehicles();
    }

    @PutMapping
    public String updateVehicle(@RequestParam String vehicle_id,@RequestBody VehicleDTO vehicleDTO){
        vehicleService.updateVehicle(vehicle_id, vehicleDTO);
        return "updated vehicle "+vehicleDTO.toString();
    }


}
