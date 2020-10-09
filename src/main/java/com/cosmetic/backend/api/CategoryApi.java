package com.cosmetic.backend.api;

import com.cosmetic.backend.dto.CategoryDTO;
import com.cosmetic.backend.exception.ResourceNotFoundException;
import com.cosmetic.backend.service.CategoryService;
import com.cosmetic.backend.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/categorys")
public class CategoryApi {

    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategorys() {

        return ResponseEntity.ok(categoryService.getAllCategory());
    }
    @GetMapping("/{id}")
    public ResponseEntity getCategoryById(@PathVariable("id") Integer id){
        return  ResponseEntity.ok(categoryService.getCategoryById(id));
    }
    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO){
        CategoryDTO dto = categoryService.createCategory(categoryDTO);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PutMapping
    public ResponseEntity<?> updateCategory( @RequestBody CategoryDTO categoryDTO){
//        categoryDTO.setCategoryId(id);
        CategoryDTO dto = categoryService.updateCategory(categoryDTO);
        return ResponseEntity.status(HttpStatus.OK).body(dto);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        categoryService.deleteCategoryById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
