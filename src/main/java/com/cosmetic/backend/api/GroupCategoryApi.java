package com.cosmetic.backend.api;

import com.cosmetic.backend.dto.GroupCategoryDTO;
import com.cosmetic.backend.exception.ResourceNotFoundException;
import com.cosmetic.backend.service.GroupCategoryService;
import com.cosmetic.backend.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/groupcategorys")
public class GroupCategoryApi {
    @Autowired
    private GroupCategoryService groupCategoryService;
    @GetMapping
    public ResponseEntity<List<GroupCategoryDTO>> getAllGroupCategorys() {
        return ResponseEntity.ok(groupCategoryService.getAllGroupCategory());
    }
    @GetMapping("/{id}")
    public ResponseEntity getGroupCategoryById(@PathVariable("id") Integer id){
        return  ResponseEntity.ok(groupCategoryService.getGroupCategoryById(id));
    }
    @PostMapping
    public ResponseEntity<?> createGroupCategory(@RequestBody GroupCategoryDTO groupCategoryDTO){
        GroupCategoryDTO dto = groupCategoryService.createGroupCategory(groupCategoryDTO);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PutMapping
    public ResponseEntity<?> updateGroupCategory( @RequestBody GroupCategoryDTO groupCategoryDTO){
        //groupCategoryDTO.setGroupCategoryId(id);
        GroupCategoryDTO dto = groupCategoryService.updateGroupCategory(groupCategoryDTO);
        return ResponseEntity.status(HttpStatus.OK).body(dto);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGroupCategoryById(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        groupCategoryService.deleteGroupCategoryById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
