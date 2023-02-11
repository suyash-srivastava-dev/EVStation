package com.ssd.evstation.Services;

import com.ssd.evstation.POJO.ImageData;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

public interface ImageDataService {
    String uploadImage(MultipartFile file) throws IOException;
    ImageData getInfoByImageByName(String name);
    byte[] getImage(String name);

    Object findById(Long imageId);
    
    Optional<ImageData> findByImageId(Long stationImage);
}
