package com.inquisitive.datawrite.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * Created by ankitmishra on 27/01/20.
 */
@Entity
@Table(name = "tag")
@EntityListeners(AuditingEntityListener.class)
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String name;
    private String description;
    private Long weeklysearchCount;

    public Tag(String name, String description, Long weeklysearchCount) {
        this.name = name;
        this.description = description;
        this.weeklysearchCount = weeklysearchCount;
    }

    public Tag() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getWeeklysearchCount() {
        return weeklysearchCount;
    }

    public void setWeeklysearchCount(Long weeklysearchCount) {
        this.weeklysearchCount = weeklysearchCount;
    }
}
