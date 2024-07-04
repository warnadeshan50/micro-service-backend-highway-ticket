package com.example.userservice.util;

import com.example.userservice.dto.UserDTO;
import com.example.userservice.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Mapping {
    private final ModelMapper mapper;

    public UserDTO toUserDTO(UserEntity userEntity) {
        return  mapper.map(userEntity, UserDTO.class);
    }
    public UserEntity toUserEntity(UserDTO userDTO) {
        return  mapper.map(userDTO, UserEntity.class);
    }
    public List<UserDTO> toUserDTOList(List<UserEntity> userEntityList) {
        return mapper.map(userEntityList, List.class);
    }
}
