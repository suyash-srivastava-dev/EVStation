package com.ssd.evstation.POJO.Request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateEVStationRequest {
    private String stationName;
    private String stationAddress;
    private String stationCity;
    private Float stationPrice;
    private Long stationImage;

}
