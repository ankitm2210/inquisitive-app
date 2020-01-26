package com.inquisitive.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.id.IncrementGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ankitmishra on 26/01/20.
 */

@Entity
@Table(name = "address")
@JsonIgnoreProperties(value = {"id"},
        allowGetters = true)
public class Address implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String country;
    private String pinCode;

    public Address() {
        super();
    }

    public Address(String addressLine1, String addressLine2, String city, String country, String pinCode) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.country = country;
        this.pinCode = pinCode;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPinCode() {
        return pinCode;
    }

    public Long getId() {
        return id;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}
