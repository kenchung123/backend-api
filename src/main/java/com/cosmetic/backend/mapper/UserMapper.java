package com.cosmetic.backend.mapper;

import com.cosmetic.backend.dto.UserDTO;
import com.cosmetic.backend.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    @Mapping(source = "user.role.roleId",target = "roleId")
    UserDTO toUserDTO(User user);
    List<UserDTO> toListUserDTO(List<User> users);
    @Mapping(source = "userDTO.roleId",target = "role.roleId")
    User toUserEntity(UserDTO userDTO);
    List<User> toListUserEntity( List<UserDTO> userDTOS);
}
