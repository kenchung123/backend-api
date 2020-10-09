package com.cosmetic.backend.repository;

import com.cosmetic.backend.entity.GroupCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupCategoryRepository extends JpaRepository<GroupCategoryEntity,Integer> {
}
