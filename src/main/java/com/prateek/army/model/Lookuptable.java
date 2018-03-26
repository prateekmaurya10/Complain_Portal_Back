package com.prateek.army.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Lookuptable {

    @Id
    private int ownerId;
    private int qtrId;
    private int areaId;

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    @Basic
    @Column(name = "ownerId")
    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @Basic
    @Column(name = "qtrId")
    public int getQtrId() {
        return qtrId;
    }

    public void setQtrId(int qtrId) {
        this.qtrId = qtrId;
    }

    @Basic
    @Column(name = "areaId")
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
        Lookuptable that = (Lookuptable) o;
        return ownerId == that.ownerId &&
                qtrId == that.qtrId &&
                areaId == that.areaId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(ownerId, qtrId, areaId);
    }
}
