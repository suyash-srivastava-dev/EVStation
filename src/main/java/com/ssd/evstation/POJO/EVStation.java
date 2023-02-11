package com.ssd.evstation.POJO;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class EVStation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "station_id", nullable = false)
    private Long station_id;
    @NotNull
    @Column(unique=true)
    private String stationName;
    @OneToOne
    @JoinColumn(name = "station_image_id")
    private ImageData stationImage;
    @NotNull
    private String stationAddress;
    @NotNull
    private String stationCity;
    @NotNull
    private Float stationPrice;



}
