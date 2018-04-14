package com.company.carservice.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|name")
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
@Table(name = "CARSERVICE_INDIVIDUAL")
@Entity(name = "carservice$Individual")
public class Individual extends Customer {
    private static final long serialVersionUID = 1237424595737614151L;

    @NotNull
    @Column(name = "PASSPORT_NO", nullable = false)
    protected String passportNo;

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getPassportNo() {
        return passportNo;
    }


}