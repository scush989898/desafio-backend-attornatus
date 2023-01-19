package com.api.testetecnicoattornatus.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "address")

public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 130)
    private String addressDetail;

    @Column(nullable = false, length = 50)
    private String city;

    @Column(nullable = false, length = 8)
    private String zipCode;

    @Column(nullable = true, length = 10)
    private String number;

    @ManyToOne
    @JoinColumn(name = "person_owner_id", nullable = false)
    private Person addressOwner;

    @OneToOne(mappedBy = "mainAddress")
    private Person mainAddressOwner;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @JsonBackReference
    public Person getAddressOwner() {
        return addressOwner;
    }

    public void setAddressOwner(Person addressOwner) {
        this.addressOwner = addressOwner;
    }

    @JsonBackReference
    public Person getMainAddressOwner() {
        return mainAddressOwner;
    }

    public void setMainAddressOwner(Person mainAddressOwner) {
        this.mainAddressOwner = mainAddressOwner;
    }
}
