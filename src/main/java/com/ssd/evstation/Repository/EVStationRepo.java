package com.ssd.evstation.Repository;

import com.ssd.evstation.POJO.EVStation;
import com.ssd.evstation.POJO.ImageData;
import com.ssd.evstation.POJO.Response.ListOfEVStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface EVStationRepo extends JpaRepository<EVStation,Long> {
    @Transactional
    @Modifying
    @Query("update EVStation e set e.stationAddress = ?1, e.stationCity = ?2, e.stationPrice = ?3 where e.station_id = ?4")
    void update(String stationAddress, String stationCity, Float stationPrice,Long station_id);

    @Transactional
    @Modifying
    @Query("update EVStation e set e.stationImage = ?1 where e.stationName = ?2")
    int updateImage(Optional<ImageData> stationImage, String stationName);
    @Transactional
    @Query("select e from EVStation e ")
    List<EVStation> findAllEVStations();

//    @Transactional
//    @Query("select e from EVStation e" +
//            "LIMIT  ?1")
//    List<EVStation> findAllByLimit(int limit);
    @Query("select e from EVStation e where e.stationName = ?1")
    EVStation findByStationName(String stationName);
    @Transactional
    @Query("select e from EVStation e where e.stationCity = ?1")
    List<EVStation> findAllByStationCity(String stationCity);
    @Transactional
    @Query("select e from EVStation e where e.stationCity = ?1 order by e.stationPrice")
    List<EVStation> findAllByStationCityOrderByPrice(String stationCity);
}
