package com.cosmetic.backend.service;

import com.cosmetic.backend.dto.CategoryDTO;
import com.cosmetic.backend.dto.GroupCategoryDTO;

import java.util.List;

public interface GroupCategoryService {
    GroupCategoryDTO createGroupCategory(GroupCategoryDTO groupCategoryDTO);
    GroupCategoryDTO updateGroupCategory(GroupCategoryDTO groupCategoryDTO);
    List<GroupCategoryDTO> getAllGroupCategory();
    GroupCategoryDTO getGroupCategoryById(int groupCategoryId);
    void deleteGroupCategoryById(int groupCategoryId);
}
