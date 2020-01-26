package com.inquisitive.datawrite.service.FileStorge;

import com.inquisitive.datawrite.exception.FileStorageException;
import com.inquisitive.datawrite.exception.MyFileNotFoundException;
import com.inquisitive.datawrite.model.FeedsConstant;
import com.inquisitive.datawrite.model.FileStorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Created by ankitmishra on 27/01/20.
 */

@Service
public class FileDiskStorageService implements FileStorageService {
    private final Path fileStorageLocation;

    @Autowired
    public FileDiskStorageService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }
    @Override
    public String storeFile(Long id, MultipartFile file) {
        String uploadedFileName = StringUtils.cleanPath(file.getOriginalFilename());
        String fileName = FeedsConstant.IMAGE_NAME_PREFIX.concat(id.toString());

        try {
            if(uploadedFileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + uploadedFileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + uploadedFileName + ". Please try again!", ex);
        }
    }

    @Override
    public Resource loadFileAsResource(Long id) {
        String fileName = FeedsConstant.IMAGE_NAME_PREFIX.concat(id.toString());
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }
}
