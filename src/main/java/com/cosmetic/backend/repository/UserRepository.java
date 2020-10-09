package com.cosmetic.backend.repository;

import com.cosmetic.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findOneByEmail(String email);
//    User findOneByEmail(String email);
    Boolean existsByEmail(String email);
    User findOneByPassword(String password);

}
