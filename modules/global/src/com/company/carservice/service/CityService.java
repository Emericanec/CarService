package com.company.carservice.service;


import com.company.carservice.entity.City;

import java.util.UUID;

public interface CityService {
    String NAME = "carservice_CityService";

    City getDefaultCity();

    void resetDefaultCity(UUID cityId);
}