package com.example.training.domain;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Entity
@Table(name = "person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_person", nullable = false)
    private Long id_person;

    @NotEmpty(message="Name is required")
    private String name;

    @NotEmpty(message="Lastname is required")
    private String lastname;

    @NotEmpty(message="Email is required")
    @Email(message="Invalid email format")
    private String email;

//    @NotEmpty(message="Phone is required")
    private String phone;
}
