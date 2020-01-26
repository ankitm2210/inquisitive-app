package com.inquisitive.userservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ankitmishra on 26/01/20.
 */

@Entity
@Table(name = "user")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"},
        allowGetters = true)
@EntityListeners(AuditingEntityListener.class)
public class Account implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    private String name;
    private Address address;
    private String email;
    private long phone;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;
    @Enumerated(EnumType.STRING)
    private Role role;

    public Account() {
        super();
    }

    public Account(String password, AccountStatus status, String name, Address address, String email, Long phone,Role role) {
        this.password = password;
        this.status = status;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    public Account(String password, AccountStatus status, String name, Address address, String email, Long phone,Date createdAt,Role role) {
        this.password = password;
        this.status = status;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.createdAt =createdAt;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public Long getPhone() {
        return phone;
    }

    public Role getRole() {
        return role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
