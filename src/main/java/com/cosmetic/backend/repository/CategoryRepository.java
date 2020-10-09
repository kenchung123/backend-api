package com.cosmetic.backend.repository;

import com.cosmetic.backend.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {
//    List<CategoryEntity> findAllByGroupCategoryEntity_GroupCategoryId(int groupCategoryID);
//    @Query("Select * from CategoryEntity  ct Join GroupCategoryEntity  gc on where  gc.")
}
