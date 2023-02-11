package com.ssd.evstation.Services;

import com.ssd.evstation.POJO.EVStation;
import com.ssd.evstation.POJO.ImageData;
import com.ssd.evstation.POJO.Request.UpdateEVStationRequest;
import com.ssd.evstation.POJO.Response.UpdateEVStation;
import com.ssd.evstation.Repository.EVStationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EVStationServiceImp implements EVStationSerivce{
    @Autowired
    private EVStationRepo evStationRepo;
    @Autowired
    ImageDataService imageDataService;
    @Override
    @Transactional
    public EVStation addNewStation(UpdateEVStationRequest evStation) {
        EVStation evStation1 = new EVStation();
        evStation1.setStationName(evStation.getStationName());
        evStation1.setStationCity(evStation.getStationCity());
        evStation1.setStationAddress(evStation.getStationAddress());
        evStation1.setStationPrice(evStation.getStationPrice());
//        evStation1.setStationImage();
        evStationRepo.save(evStation1);
        if(evStation.getStationImage()!=null)
        {
            Optional<ImageData> imageData=imageDataService.findByImageId(evStation.getStationImage());
            evStationRepo.updateImage(imageData,evStation.getStationName());
        }
        return evStationRepo.findByStationName(evStation.getStationName());
    }

    @Override
    public Optional<EVStation> findById(Long id) {
        return evStationRepo.findById(id);
    }


    @Override
    public UpdateEVStation updateStation(UpdateEVStationRequest evStation,Long id) {
        if(evStation.getStationImage()!=null)
        {
            Optional<ImageData> imageData=imageDataService.findByImageId(evStation.getStationImage());
            evStationRepo.updateImage(imageData,evStation.getStationName());
        }
        evStationRepo.update(evStation.getStationAddress(),evStation.getStationCity(),evStation.getStationPrice(),id);
        return UpdateEVStation.builder()
                .message("Updated Sucessfully")
                .stationName(evStation.getStationName())
                .stationAddress(evStation.getStationAddress())
                .stationCity(evStation.getStationCity())
                .stationPrice(evStation.getStationPrice())
                .build();
    }

    @Override
    @Transactional
    public String removeStation(Long stationName) {
        evStationRepo.deleteById(stationName);
        return stationName.toString();
    }

    @Override
    public List<EVStation> findByCityName(String stationCity) {
        List<EVStation> evStationList=evStationRepo.findAllByStationCity(stationCity);
        return evStationList;
    }

    @Override
    public List<EVStation> findByCityNameAndPrice(String stationCity) {
        List<EVStation> evStationList=evStationRepo.findAllByStationCityOrderByPrice(stationCity);
        return evStationList;
    }

    @Override
    public List<EVStation> findAllStation() {
        return evStationRepo.findAll();
    }

//    @Override
//    public List<EVStation> findAllStationByLimit(int limit) {
//        return evStationRepo.findAllByLimit(limit);
//    }

}
