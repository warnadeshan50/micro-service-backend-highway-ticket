package com.example.vehicleservice.service.impl;



import com.example.vehicleservice.dto.VehicleDTO;
import com.example.vehicleservice.entity.VehicleEntity;
import com.example.vehicleservice.repositry.VehicleDAO;
import com.example.vehicleservice.service.VehicleService;
import com.example.vehicleservice.util.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    final private Mapping mapping;
    final private VehicleDAO vehicleDAO;

    @Override
    public VehicleDTO saveVehicle(VehicleDTO vehicleDTO) {
        vehicleDTO.setRegistration_date(LocalDateTime.now());
        return mapping.toVehicleDTO(vehicleDAO.save(mapping.toVehicleEntity(vehicleDTO)));
    }

    @Override
    public void deleteVehicle(String vehicle_id) {
        vehicleDAO.deleteById(vehicle_id);
    }

    @Override
    public VehicleDTO getSelectedVehicle(String vehicle_id) {
        return mapping.toVehicleDTO(vehicleDAO.getById(vehicle_id));
    }

    @Override
    public List<VehicleDTO> getAllVehicles() {
        return mapping.toVehicleDTOList(vehicleDAO.findAll());
    }

    @Override
    public void updateVehicle(String vehicle_id, VehicleDTO vehicleDTO) {
        Optional<VehicleEntity> optionalVehicle = vehicleDAO.findById(vehicle_id);
        if (optionalVehicle.isPresent()) {
            VehicleEntity existingVehicle = optionalVehicle.get();
            existingVehicle.setVehicle_owner(vehicleDTO.getVehicle_owner());
            existingVehicle.setVehicle_model(vehicleDTO.getVehicle_model());
            existingVehicle.setVehicle_type(vehicleDTO.getVehicle_type());
            existingVehicle.setAmount_of_passengers(vehicleDTO.getAmount_of_passengers());
            existingVehicle.setUser_id(vehicleDTO.getUser_id());
            vehicleDAO.save(existingVehicle);
        }
    }
}
