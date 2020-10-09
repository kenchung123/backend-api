package com.cosmetic.backend.security;

import com.cosmetic.backend.dto.UserPrincipalDto;
import com.cosmetic.backend.entity.User;
import com.cosmetic.backend.exception.ResourceNotFoundException;
import com.cosmetic.backend.repository.UserRepository;
import com.cosmetic.backend.util.constant.MessageConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findOneByEmail(email);
        if (user == null){
            throw  new UsernameNotFoundException(MessageConstants.EMAIL_NOT_FOUND + " : " + email);
      }
//                .orElseThrow(() ->
//                        new UsernameNotFoundException(MessageConstants.EMAIL_NOT_FOUND + " : " + email)
//                );
        return UserPrincipalDto.create(user);
    }

    @Transactional
    public UserDetails loadUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );

        return UserPrincipalDto.create(user);
    }

}
