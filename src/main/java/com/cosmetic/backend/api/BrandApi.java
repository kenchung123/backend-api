package com.cosmetic.backend.api;

import com.cosmetic.backend.dto.BrandDTO;
import com.cosmetic.backend.entity.BrandEntity;
import com.cosmetic.backend.exception.ResourceNotFoundException;
import com.cosmetic.backend.mapper.BrandMapper;
import com.cosmetic.backend.service.BrandService;
import com.cosmetic.backend.util.SecurityUtil;
import com.cosmetic.backend.util.UploadFileUtils;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.ServletContext;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/v1/brands")
public class BrandApi {

    private ServletContext servletContext;

    @Autowired
    private UploadFileUtils uploadFileUtils;

    @Autowired
    private BrandService brandService;
    @GetMapping
    public ResponseEntity<List<BrandDTO>> getAllBrands() {

        return ResponseEntity.ok(brandService.getAllBrand());
    }
    @GetMapping("/{id}")
    public ResponseEntity getBrandById(@PathVariable("id") Integer id){
        return  ResponseEntity.ok(brandService.getBrandById(id));
    }
    @PostMapping
    public ResponseEntity<?> createBrand(@RequestBody BrandDTO brandDTO){
//        byte[] decodebase64 = Base64.getDecoder().decode(brandDTO.getBase64().split(",")[1].getBytes());
//        uploadFileUtils.writeOrUpdate(decodebase64,"/images/" + brandDTO.getLogo());
        BrandDTO dto = brandService.createBrand(brandDTO);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PutMapping
    public ResponseEntity<?> updateBrand( @RequestBody BrandDTO brandDTO){
//        brandDTO.setBrandId(id);
        BrandDTO dto = brandService.updateBrand(brandDTO);
        return ResponseEntity.status(HttpStatus.OK).body(dto);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBrandById(@PathVariable("id") Integer id) throws ResourceNotFoundException {
         brandService.deleteBrandById(id);
         return ResponseEntity.status(HttpStatus.OK).build();
    }

//    @GetMapping("/{brandName}")
//    public ResponseEntity<?> findByBrandName( @PathVariable("brandName") String brandName){
//        return ResponseEntity.ok(brandService.findByBrandName(brandName));
//    }

    @RequestMapping(value =  "/upload",method = RequestMethod.POST)
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file,
                                     @RequestParam(name = "logoName") String logoName) {
        String originalFileName = file.getOriginalFilename();
//        Path path = Paths.get(this.servletContext.getRealPath("/uploads") + originalFileName);

        File destinationFile = new File("D:\\save\\uploads\\images/"+ logoName);
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(originalFileName)
//                .toUriString();


        try {
            file.transferTo(destinationFile);
            System.out.println("File name:" + originalFileName);
            System.out.println("File path:" + destinationFile.getPath());
            System.out.println("File size:" + file.getSize());
//            System.out.println("url :" + path);
//            System.out.println("File url:" + fileDownloadUri);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return new ResponseEntity(destinationFile.getPath(), HttpStatus.OK);
    }
}
