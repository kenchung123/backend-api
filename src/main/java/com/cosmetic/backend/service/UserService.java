package com.cosmetic.backend.service;

import com.cosmetic.backend.dto.ChangePasswordParam;
import com.cosmetic.backend.dto.ResetPasswordParam;
import com.cosmetic.backend.dto.UserDTO;
import com.cosmetic.backend.dto.UserPrincipalDto;

import java.util.List;

public interface UserService {
    UserDTO getUserById(Integer id);
    List<UserDTO> getAllUser();
    UserDTO saveUser(UserDTO userDTO);
    UserDTO updateUser(UserDTO userDTO);
    UserDTO changePasswordUser(ChangePasswordParam param, UserPrincipalDto userPrincipalDto);
    void deleteUser(int userId);
}
