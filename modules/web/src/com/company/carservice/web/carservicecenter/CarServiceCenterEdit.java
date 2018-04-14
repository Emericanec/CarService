package com.company.carservice.web.carservicecenter;

import com.company.carservice.entity.City;
import com.company.carservice.entity.Customer;
import com.company.carservice.service.CityService;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.carservice.entity.CarServiceCenter;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.TabSheet;
import com.haulmont.cuba.gui.data.CollectionDatasource;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.UUID;

public class CarServiceCenterEdit extends AbstractEditor<CarServiceCenter> {


    public void onCreate(Component source) {

    }

    public void onRemove(Component source) {
    }

    @Inject
    private CityService cityService;

    @Inject
    private TabSheet tabSheet;

    protected void initNewItem(CarServiceCenter item) {
        City city = cityService.getDefaultCity();
        if (city != null) {
            item.setCity(city);
        }
    }

    @Inject
    private CollectionDatasource<Customer, UUID> customersDs;

    protected void postInit() {
        this.setCustomerCount(customersDs.getItems().size());
        customersDs.addCollectionChangeListener(e -> this.setCustomerCount(e.getItems().size()));
    }

    private void setCustomerCount(Integer count) {
        TabSheet.Tab customers = tabSheet.getTab("customers");
        customers.setCaption("Customers (" + count.toString() + ")");
    }
}