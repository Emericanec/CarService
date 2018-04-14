package com.company.carservice.service;

import com.company.carservice.entity.City;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.UUID;

@Service(CityService.NAME)
public class CityServiceBean implements CityService {

    @Inject
    private DataManager dataManager;

    public City getDefaultCity() {
        LoadContext context = LoadContext.create(City.class).setQuery(
                LoadContext.createQuery("select c from carservice$City c where c.isDefault = :isDefault")
                        .setParameter("isDefault", true));
        return (City) dataManager.load(context);
    }

    @Inject
    private Persistence persistence;

    public void resetDefaultCity(UUID cityId) {
        persistence.getEntityManager()
                .createQuery("update carservice$City c set c.isDefault = :isNotDefault where c.isDefault = :isDefault AND c.id <> :uuid")
                .setParameter("isNotDefault", false)
                .setParameter("isDefault", true)
                .setParameter("uuid", cityId)
                .executeUpdate();
    }
}