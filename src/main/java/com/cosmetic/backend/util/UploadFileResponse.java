package com.cosmetic.backend.util;

import lombok.Data;

@Data
public class UploadFileResponse {
    private String fileName;
    private String fileType;
    private long size;
    public UploadFileResponse(String fileName,long size, String fileType ) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.size = size;
    }
}
