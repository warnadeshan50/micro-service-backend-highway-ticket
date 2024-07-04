package com.example.userservice.service;

import com.example.userservice.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserDTO saveUser(UserDTO userDTO);
    void deleteUser(String user_id);
    UserDTO getSelectedUser(String user_id);
    List<UserDTO> getAllUsers();
    void updateUser(String user_id,UserDTO userDTO);
}
