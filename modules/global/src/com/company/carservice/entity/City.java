package com.company.carservice.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.Listeners;

@Listeners("carservice_CityEntityListener")
@NamePattern("%s|name")
@Table(name = "CARSERVICE_CITY")
@Entity(name = "carservice$City")
public class City extends StandardEntity {
    private static final long serialVersionUID = 3687034118114328528L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @NotNull
    @Column(name = "CODE", nullable = false)
    protected String code;

    @NotNull
    @Column(name = "IS_DEFAULT", nullable = false)
    protected Boolean isDefault = false;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setIsDefault(Boolean value) {
        this.isDefault = value;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }


}