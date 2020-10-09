package com.cosmetic.backend.repository;

import com.cosmetic.backend.entity.Role;
import com.cosmetic.backend.validation.EMEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findOneByRoleName(EMEnum.RoleName roleName);
}
