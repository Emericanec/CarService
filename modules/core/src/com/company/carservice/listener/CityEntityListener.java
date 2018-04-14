package com.company.carservice.listener;

import com.company.carservice.service.CityService;
import org.springframework.stereotype.Component;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import com.haulmont.cuba.core.EntityManager;
import com.company.carservice.entity.City;
import com.haulmont.cuba.core.listener.BeforeUpdateEntityListener;

import javax.inject.Inject;

@Component("carservice_CityEntityListener")
public class CityEntityListener implements BeforeInsertEntityListener<City>, BeforeUpdateEntityListener<City> {


    @Inject
    private CityService cityService;

    @Override
    public void onBeforeInsert(City entity, EntityManager entityManager) {
        if(entity.getIsDefault()) {
            cityService.resetDefaultCity(entity.getId());
        }
    }


    @Override
    public void onBeforeUpdate(City entity, EntityManager entityManager) {
        if(entity.getIsDefault()) {
            cityService.resetDefaultCity(entity.getId());
        }
    }


}