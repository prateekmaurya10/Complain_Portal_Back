package com.prateek.army.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Qtrs {
    private int id;
    private int qtrNo;
    private int areaId;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "qtrNo")
    public int getQtrNo() {
        return qtrNo;
    }

    public void setQtrNo(int qtrNo) {
        this.qtrNo = qtrNo;
    }

    @Basic
    @Column(name = "areaID")
    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Qtrs qtrs = (Qtrs) o;
        return id == qtrs.id &&
                qtrNo == qtrs.qtrNo &&
                areaId == qtrs.areaId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, qtrNo, areaId);
    }
}
