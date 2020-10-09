package com.cosmetic.backend.service.impl;

import com.cosmetic.backend.dto.ChangePasswordParam;
import com.cosmetic.backend.dto.ResetPasswordParam;
import com.cosmetic.backend.dto.UserDTO;
import com.cosmetic.backend.dto.UserPrincipalDto;
import com.cosmetic.backend.entity.BrandEntity;
import com.cosmetic.backend.entity.Role;
import com.cosmetic.backend.entity.User;
import com.cosmetic.backend.exception.BadRequestException;
import com.cosmetic.backend.exception.ResourceNotFoundException;
import com.cosmetic.backend.mapper.BrandMapper;
import com.cosmetic.backend.mapper.UserMapper;
import com.cosmetic.backend.repository.RoleRepository;
import com.cosmetic.backend.repository.UserRepository;
import com.cosmetic.backend.service.UserService;
import com.cosmetic.backend.util.constant.MessageConstants;
import com.cosmetic.backend.validation.EMEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDTO getUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return UserMapper.INSTANCE.toUserDTO(user.get());
    }

    @Override
    public List<UserDTO> getAllUser() {
       List<User> users = userRepository.findAll();
       return UserMapper.INSTANCE.toListUserDTO(users);
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) throws BadRequestException {
            if (userRepository.existsByEmail(userDTO.getEmail())) {
                throw new BadRequestException(MessageConstants.EMAIL_ALREADY_EXISTS);
            }
            User user = new User();
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            user.setAddress(userDTO.getAddress());
            user.setBirthDate(userDTO.getBirthDate());
            user.setPhoneNumber(userDTO.getPhoneNumber());
            user.setGender(userDTO.getGender());
            user.setFullName(userDTO.getFullName());
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            Role userRole = roleRepository.findOneByRoleName(EMEnum.RoleName.ROLE_USER);
            user.setRole(userRole);
            User result = userRepository.save(user);
            return UserMapper.INSTANCE.toUserDTO(result);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
             Optional<User> user = userRepository.findById(userDTO.getUserId());
            User user2 = UserMapper.INSTANCE.toUserEntity(userDTO);
             user2.setRole(user.get().getRole());
            return UserMapper.INSTANCE.toUserDTO(userRepository.save(user2));
    }

    @Override
    public UserDTO changePasswordUser(ChangePasswordParam param, UserPrincipalDto userPrincipalDto) {
        if (!userPrincipalDto.getEmail().equals(param.getEmail())){
          throw  new ResourceNotFoundException("user","email",param.getEmail());
        }
        User user = userRepository.findOneByEmail(param.getEmail());
        if (!passwordEncoder.matches(param.getOldPassword(),user.getPassword())){
            throw new BadRequestException(MessageConstants.INVALID_PASSWORD);
        }
        user.setPassword(passwordEncoder.encode(param.getNewPassword()));
        User result = userRepository.save(user);
        return UserMapper.INSTANCE.toUserDTO(result);
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }


}
