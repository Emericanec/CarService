package com.company.carservice.core.jmx;

import com.company.carservice.entity.Employee;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Query;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.TypedQuery;
import com.haulmont.cuba.core.app.EmailerAPI;
import com.haulmont.cuba.core.global.EmailException;
import com.haulmont.cuba.core.global.EmailInfo;
import groovy.lang.GroovyShell;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.persistence.TemporalType;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Component("carservice_EmployeeWorkerMBean")
public class EmployeeWorker implements EmployeeWorkerMBean {

    @Inject
    private Persistence persistence;

    @Inject
    private EmailerAPI emailerAPI;

    @Override
    public void sendGreetings() throws EmailException {
        List<Employee> employees;
        try (Transaction tx = persistence.createTransaction()) {
            TypedQuery<Employee> query = persistence.getEntityManager().createQuery(
                    "select e from carservice$Employee e", Employee.class);
            employees = query.getResultList();
            for (Employee customer : employees) {
                String mailText = "Поздравляем вас с днем рождения, уважаемый "+customer.getFirstName()+" "+customer.getLastName()+"!\n" +
                        "        Желаем всего наилучшего в ваши "+customer.getBirthDate()+" лет!\n" +
                        "        С уважением, коллектив автосервиса Альфа-колор";
                EmailInfo email = new EmailInfo("aasvetlichniy@gmail.com", "Happy birthday", mailText);
                emailerAPI.sendEmail(email);
            }
            tx.commit();
        }
    }
}
