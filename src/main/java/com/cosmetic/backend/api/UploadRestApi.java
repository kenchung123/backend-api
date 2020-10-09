package com.cosmetic.backend.api;

import com.cosmetic.backend.util.UploadFileResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/demo")
public class UploadRestApi implements ServletContextAware {

    private ServletContext servletContext;
    @PostMapping("upload")
    public UploadFileResponse uploads(@RequestParam("files") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        long fileSize = file.getSize();
        String fileType = file.getContentType();
        save(file);
        return new UploadFileResponse(fileName, fileSize, fileType);
    }
    private String save(MultipartFile file){
        try {
            String newFileName = file.getOriginalFilename();
            byte[] bytes = file.getBytes();
            Path path = Paths.get(this.servletContext.getRealPath("/uploads/images/") + newFileName);
            Files.write(path,bytes);
            return newFileName;
        }catch (Exception e){
            return null;
        }
    }
    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
