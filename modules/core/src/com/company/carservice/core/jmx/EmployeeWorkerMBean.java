package com.company.carservice.core.jmx;

import com.haulmont.cuba.core.global.EmailException;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

import java.io.IOException;

@ManagedResource(description = "employees logic")
public interface EmployeeWorkerMBean {

    @ManagedOperation(description = "birthday email")
    void sendGreetings() throws IOException, EmailException;
}
