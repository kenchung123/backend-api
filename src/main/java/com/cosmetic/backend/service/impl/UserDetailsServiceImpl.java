//package com.cosmetic.backend.service.impl;
//
//import com.cosmetic.backend.entity.User;
//import com.cosmetic.backend.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class UserDetailsServiceImpl extends Throwable implements UserDetailsService {
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepository.findOneByEmail(email);
//        if (user == null){
//            throw  new UsernameNotFoundException("can not find user");
//        }
//        return new MyUserDetail(user);
//    }
//}
