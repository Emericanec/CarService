package com.company.carservice.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|name")
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
@Table(name = "CARSERVICE_COMPANY")
@Entity(name = "carservice$Company")
public class Company extends Customer {
    private static final long serialVersionUID = 2538338813018446177L;

    @NotNull
    @Column(name = "INN", nullable = false)
    protected String inn;

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getInn() {
        return inn;
    }


}