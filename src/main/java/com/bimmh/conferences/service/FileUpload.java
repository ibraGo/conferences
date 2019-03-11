package com.bimmh.conferences.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUpload {
    public String upload(MultipartFile file);
}
