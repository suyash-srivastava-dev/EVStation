package com.ssd.evstation.POJO.Response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateEVStation {
    private String stationName;
    private String stationAddress;
    private String stationCity;
    private Float stationPrice;
    private String message;

}
