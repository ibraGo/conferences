package com.bimmh.conferences.service;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Service
public class FileUploadServiceImp implements FileUpload {

    public String upload(MultipartFile file) {

        if (!file.isEmpty()) {
            String extension = FilenameUtils.getExtension(file.getOriginalFilename());
            String name = String.format("%s.%s", RandomStringUtils.randomAlphanumeric(8), extension);
            try {
                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = System.getProperty("catalina.home");
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                return name;
            } catch (Exception e) {
                return "failed";
            }
        } else {
            return "failed";
        }
    }

}


