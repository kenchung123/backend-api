package com.cosmetic.backend.service.impl;

import com.cosmetic.backend.dto.GroupCategoryDTO;
import com.cosmetic.backend.entity.CategoryEntity;
import com.cosmetic.backend.entity.GroupCategoryEntity;
import com.cosmetic.backend.exception.BadRequestException;
import com.cosmetic.backend.exception.ResourceNotFoundException;
import com.cosmetic.backend.mapper.CategoryMapper;
import com.cosmetic.backend.mapper.GroupCategoryMapper;
import com.cosmetic.backend.repository.GroupCategoryRepository;
import com.cosmetic.backend.service.GroupCategoryService;
import com.cosmetic.backend.util.constant.MessageConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupCategoryServiceImpl implements GroupCategoryService {
    @Autowired
    private GroupCategoryRepository groupCategoryRepository;
    @Override
    public GroupCategoryDTO createGroupCategory(GroupCategoryDTO groupCategoryDTO) {
            GroupCategoryEntity groupCategoryEntity = groupCategoryRepository.save(GroupCategoryMapper.INSTANCE.toGroupCategoryEntity(groupCategoryDTO));
            return GroupCategoryMapper.INSTANCE.toGroupCategoryDTO(groupCategoryEntity);
    }

    @Override
    public GroupCategoryDTO updateGroupCategory(GroupCategoryDTO groupCategoryDTO) {
            GroupCategoryEntity groupCategoryEntity = groupCategoryRepository.save(GroupCategoryMapper.INSTANCE.toGroupCategoryEntity(groupCategoryDTO));
            return GroupCategoryMapper.INSTANCE.toGroupCategoryDTO(groupCategoryEntity);
    }

    @Override
    public List<GroupCategoryDTO> getAllGroupCategory() {
        List<GroupCategoryEntity> groupCategoryEntityList = groupCategoryRepository.findAll();
        return GroupCategoryMapper.INSTANCE.toListGroupCategoryDTO(groupCategoryEntityList);
    }

    @Override
    public GroupCategoryDTO getGroupCategoryById(int groupCategoryId) {
        Optional<GroupCategoryEntity> groupCategoryEntity =  groupCategoryRepository.findById(groupCategoryId);
        return GroupCategoryMapper.INSTANCE.toGroupCategoryDTO(groupCategoryEntity.get());
    }

    @Override
    public void deleteGroupCategoryById(int groupCategoryId) {
        Optional<GroupCategoryEntity> groupCategoryEntity = groupCategoryRepository.findById(groupCategoryId);
        if(groupCategoryEntity.isPresent()){
            try {
                groupCategoryRepository.deleteById(groupCategoryId);
            }catch (Exception e){
                throw new BadRequestException(MessageConstants.CATEGORY_CANNOT_DELETE);
            }
        }
        else throw new ResourceNotFoundException("Group category", "id", groupCategoryId);
    }
}
