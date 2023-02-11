package com.ssd.evstation.Services;

import com.ssd.evstation.POJO.ImageData;
import com.ssd.evstation.Repository.ImageDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Optional;

@Service
public class ImageDataServiceImp implements ImageDataService{

    @Autowired
    private ImageDataRepository imageDataRepository;

    public String uploadImage(MultipartFile file) throws IOException {

        imageDataRepository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(file.getBytes()).build());

        return "Image uploaded successfully: " +
                file.getOriginalFilename();

    }

    @Transactional
    public ImageData getInfoByImageByName(String name) {
        Optional<ImageData> dbImage = imageDataRepository.findByName(name);

        return ImageData.builder()
                .id(dbImage.get().getId())
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .imageData(dbImage.get().getImageData()).build();

    }

    @Transactional
    public byte[] getImage(String name) {
        Optional<ImageData> dbImage = imageDataRepository.findByName(name);
        byte[] image =dbImage.get().getImageData();
        return image;
    }

    @Override
    public Object findById(Long imageId) {

       if(imageDataRepository.findById(imageId).isPresent()) {
           return imageDataRepository.findById(imageId);
       }
       else
           return new ImageData();
    }

    @Override
    public Optional<ImageData> findByImageId(Long stationImage) {
        return imageDataRepository.findById(stationImage);
    }


}
