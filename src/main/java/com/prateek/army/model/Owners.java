package com.prateek.army.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Owners {
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String rank;
    private Integer qtrsId=1;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "middleName")
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Basic
    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "rank")
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Basic
    @Column(name = "qtrsId")
    public Integer getQtrsId() {
        return qtrsId;
    }

    public void setQtrsId(Integer qtrsId) {
        this.qtrsId = qtrsId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owners owners = (Owners) o;
        return  Objects.equals(firstName, owners.firstName) &&
                Objects.equals(middleName, owners.middleName) &&
                Objects.equals(lastName, owners.lastName) &&
                Objects.equals(rank, owners.rank) &&
                Objects.equals(qtrsId, owners.qtrsId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstName, middleName, lastName, rank, qtrsId);
    }
}
