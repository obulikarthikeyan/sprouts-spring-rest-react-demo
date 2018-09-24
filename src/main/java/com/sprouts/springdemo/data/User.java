package com.sprouts.springdemo.data;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@Entity
@ToString
public class User {

    @Id
    @GeneratedValue Long id;
    @NotNull
    private String firstName;
    private String lastName;
    @NotNull
    private String emailId;
    private Long phoneNumber;
    private Boolean isActive;
    private Long timeCreated;
    private Long timeUpdated;
}
