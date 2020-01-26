package com.inquisitive.datawrite.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by ankitmishra on 27/01/20.
 */

@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
    private String uploadDir;

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}
