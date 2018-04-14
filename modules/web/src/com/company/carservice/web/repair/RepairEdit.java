package com.company.carservice.web.repair;

import com.company.carservice.entity.CarServiceCenter;
import com.company.carservice.entity.Employee;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.carservice.entity.Repair;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.PickerField;
import com.haulmont.cuba.gui.data.Datasource;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class RepairEdit extends AbstractEditor<Repair> {

    @Inject
    private Datasource<Repair> repairDs;

    @Named("fieldGroup.employee")
    private PickerField employeeField;

    protected void postInit() {
        Map<String, Object> lookUpParams = new HashMap<>();

        CarServiceCenter centerInit = repairDs.getItem().getCenter();
        if(centerInit != null) {
            lookUpParams.put("centerId", centerInit.getId());
            employeeField.getLookupAction().setLookupScreenParams(lookUpParams);
        }

        repairDs.addItemPropertyChangeListener(e -> RepairItemPropertyChangeListener(e, lookUpParams));
    }

    private void RepairItemPropertyChangeListener(Datasource.ItemPropertyChangeEvent<Repair> e, Map<String, Object> lookUpParams) {
        CarServiceCenter center = e.getItem().getCenter();
        Employee employee = e.getItem().getEmployee();
        if(center != null) {
            lookUpParams.put("centerId", center.getId());
            employeeField.getLookupAction().setLookupScreenParams(lookUpParams);

            if (employee != null && !employee.getCenter().getId().equals(center.getId())) {
                e.getItem().setEmployee(null);
            }
        }
    }
}