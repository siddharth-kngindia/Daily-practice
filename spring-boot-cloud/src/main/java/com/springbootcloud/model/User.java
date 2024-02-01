package com.springbootcloud.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {
    private String id;
    private String name;
    private String emailId;
}
