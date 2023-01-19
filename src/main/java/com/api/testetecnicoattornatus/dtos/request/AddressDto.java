package com.api.testetecnicoattornatus.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class AddressDto {

    @NotBlank
    @Size(max = 130)
    private String addressDetail;

    @NotBlank
    @Size(max = 50)
    private String city;

    @NotBlank
    @Size(max = 8)
    private String zipCode;

    @Size(max = 10)
    private String number;

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
}
