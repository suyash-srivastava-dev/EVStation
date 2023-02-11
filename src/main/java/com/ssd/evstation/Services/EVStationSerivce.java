package com.ssd.evstation.Services;


import com.ssd.evstation.POJO.EVStation;
import com.ssd.evstation.POJO.Request.UpdateEVStationRequest;
import com.ssd.evstation.POJO.Response.UpdateEVStation;

import java.util.List;
import java.util.Optional;

public interface EVStationSerivce{

    EVStation addNewStation(UpdateEVStationRequest evStation);
    Optional<EVStation> findById(Long id);

    UpdateEVStation updateStation(UpdateEVStationRequest evStation,Long id);

    String removeStation(Long stationName);

    List<EVStation> findByCityName(String stationCity);


    List<EVStation>  findByCityNameAndPrice(String stationCity);

    List<EVStation> findAllStation();

//    List<EVStation> findAllStationByLimit(int parseInt);
}
