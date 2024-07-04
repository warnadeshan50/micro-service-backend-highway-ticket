package com.example.userservice.service.impl;

import com.example.userservice.dto.UserDTO;
import com.example.userservice.entity.UserEntity;
import com.example.userservice.repositry.UserDAO;
import com.example.userservice.service.UserService;
import com.example.userservice.util.Mapping;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    final private UserDAO userDAO;
    final private Mapping mapping;
    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        userDTO.setUser_id(UUID.randomUUID().toString());
        return mapping.toUserDTO(userDAO.save(mapping.toUserEntity(userDTO)));
    }

    @Override
    public void deleteUser(String user_id) {
        userDAO.deleteById(user_id);
    }

    @Override
    public UserDTO getSelectedUser(String user_id) {
        return mapping.toUserDTO(userDAO.getById(user_id));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return mapping.toUserDTOList(userDAO.findAll());
    }

    @Override
    public void updateUser(String user_id, UserDTO userDTO) {
        Optional<UserEntity> optionalUser = userDAO.findById(user_id);
        if (optionalUser.isPresent()) {
            UserEntity existingUser = optionalUser.get();
            existingUser.setUser_address(userDTO.getUser_address());
            existingUser.setUser_email(userDTO.getUser_email());
            existingUser.setUser_phone(userDTO.getUser_phone());
            existingUser.setUser_first_name(userDTO.getUser_first_name());
            existingUser.setUser_last_name(userDTO.getUser_last_name());
            existingUser.setUser_password(userDTO.getUser_password());
            userDAO.save(existingUser);
        }
    }
}
