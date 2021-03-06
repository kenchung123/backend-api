//package com.cosmetic.backend.api;
//
//import com.cosmetic.backend.payload.UploadFileResponse;
//import com.cosmetic.backend.service.impl.FileStorageService;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import java.util.logging.Logger;
//
//@RestController
//@RequestMapping("/api/v1/uploadFile")
//public class FileController {
//    private final FileStorageService fileStorageService;
//
//    public FileController(FileStorageService fileStorageService) {
//        this.fileStorageService = fileStorageService;
//    }
//
//    @PostMapping
//    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
//        String fileName = fileStorageService.storeFile(file);
//
//        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//                .path("/downloadFile/")
//                .path(fileName)
//                .toUriString();
//
//        return new UploadFileResponse(fileName, fileDownloadUri,
//                file.getContentType(), file.getSize());
//    }
//
//}
