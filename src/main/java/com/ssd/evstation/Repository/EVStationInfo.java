package com.ssd.evstation.Repository;

/**
 * A Projection for the {@link com.ssd.evstation.POJO.EVStation} entity
 */
public interface EVStationInfo {
    String getStationName();

    String getStationAddress();

    String getStationCity();

    Float getStationPrice();
}