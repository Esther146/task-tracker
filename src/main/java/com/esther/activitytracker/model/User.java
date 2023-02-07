package com.esther.activitytracker.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String firstname;


    private String lastname;


    private String email;


    private String password;

    @OneToMany(
            mappedBy ="user"

    )
    private List<Task> tasks = new ArrayList<>();

}
