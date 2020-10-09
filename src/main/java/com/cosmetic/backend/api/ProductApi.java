package com.cosmetic.backend.api;

import com.cosmetic.backend.dto.ProductDTO;
import com.cosmetic.backend.exception.ResourceNotFoundException;
import com.cosmetic.backend.service.ProductService;
import com.cosmetic.backend.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/v1/products")
public class ProductApi {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProduct(){
        return ResponseEntity.ok(productService.getAllProduct());
    }
    @GetMapping("/search")
    public ResponseEntity<List<ProductDTO>> findAllProduct(@Param("keySearch") String keySearch){
        return ResponseEntity.ok(productService.findAllProduct(keySearch));
    }
    @GetMapping("{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable("id")  Integer id){
        return ResponseEntity.ok(productService.getProductById(id));
    }
    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO){
        ProductDTO dto = productService.createProduct(productDTO);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PutMapping
    public  ResponseEntity<?> updateProduct(@RequestBody ProductDTO productDTO){
//        productDTO.setProductId(id);
        ProductDTO dto = productService.updateProduct(productDTO);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
