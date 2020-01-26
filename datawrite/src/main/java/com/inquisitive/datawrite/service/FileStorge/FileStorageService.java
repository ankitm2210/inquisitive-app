package com.inquisitive.datawrite.service.FileStorge;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by ankitmishra on 27/01/20.
 */

public interface FileStorageService {
    String storeFile(Long id, MultipartFile file);
    Resource loadFileAsResource(Long id);
}
