package com.ssd.evstation.Controller;

import com.ssd.evstation.POJO.EVStation;
import com.ssd.evstation.POJO.Request.UpdateEVStationRequest;
import com.ssd.evstation.POJO.Response.ListOfEVStation;
import com.ssd.evstation.POJO.Response.UpdateEVStation;
import com.ssd.evstation.Services.EVStationSerivce;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
@AllArgsConstructor
public class EVStationController {

    @Autowired
    EVStationSerivce evStationService;


    @PostMapping("/")
    public ResponseEntity<EVStation> addStation(@RequestBody UpdateEVStationRequest evStation) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(evStationService.addNewStation(evStation));
    }
    @GetMapping("/show/{id}")
    public ResponseEntity<Optional<EVStation>> listStation(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(evStationService.findById(id));
    }
    @GetMapping("/")
    public ResponseEntity<List<EVStation>> listOfAllStation(@RequestParam(required = false) int limit) {

//        if(limit != null){
//            return ResponseEntity.status(HttpStatus.OK)
//                    .body(evStationService.findAllStationByLimit(limit));
//        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(evStationService.findAllStation());
    }
    @PutMapping("/{id}/edit")
    public ResponseEntity<UpdateEVStation> updateStation(@RequestBody UpdateEVStationRequest evStation,@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(evStationService.updateStation(evStation,id));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> removeStation(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(evStationService.removeStation(id)+" Removed Successfully");

    }
    @GetMapping("/listOfStation/{stationCity}")
    public ResponseEntity<List<EVStation>> listStation(@PathVariable String stationCity) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(evStationService.findByCityName(stationCity));
    }
    @GetMapping("/listOfStationByPrice/{stationCity}")
    public ResponseEntity<List<EVStation>> listStationByPrice(@PathVariable String stationCity) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(evStationService.findByCityNameAndPrice(stationCity));

    }

}
