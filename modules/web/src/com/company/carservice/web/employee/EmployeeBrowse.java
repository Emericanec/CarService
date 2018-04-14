package com.company.carservice.web.employee;

import com.company.carservice.entity.Employee;
import com.haulmont.cuba.core.global.filter.Clause;
import com.haulmont.cuba.core.global.filter.QueryFilter;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.data.GroupDatasource;

import javax.inject.Inject;
import java.util.Map;
import java.util.UUID;

public class EmployeeBrowse extends AbstractLookup {

    @Inject
    private GroupDatasource<Employee, UUID> employeesDs;

    @Override
    public void init(Map<String, Object> params) {
        if(params.containsKey("centerId")) {
            String consent = String.format("e.center.id = '%s'", params.get("centerId"));
            Clause clause = new Clause("byCenterId", consent, null, null, null);
            QueryFilter queryFilter = new QueryFilter(clause);
            employeesDs.setQueryFilter(queryFilter);
        }
    }
}