package com.example.userservice.controller;

import com.example.userservice.dto.UserDTO;
import com.example.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/okay")
    public String okay() {
        return "ready to use user service";
    }

    @PostMapping
    public String saveUser(@RequestBody UserDTO userDTO) {
        userService.saveUser(userDTO);
        return "success"+userDTO.toString();
    }

    @GetMapping
    public UserDTO searchUser(@RequestParam String user_id) {
        return userService.getSelectedUser(user_id);
    }

    @GetMapping("/users")
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping
    public String deleteUser(@RequestParam String user_id) {
        userService.deleteUser(user_id);
        return "successfully deleted";
    }

    @PutMapping
    public String updateUser(@RequestParam String user_id,@RequestBody UserDTO userDTO) {
        userService.updateUser(user_id, userDTO);
        return "successfully updated "+userDTO.toString();
    }
}
