package com.example.usersmanagement_software.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor

// "id":1,
//"name":"Reem",
//"username":"rem1",
//"password":"123",
//"email":"Reem@gmail.com",
//"role":"user",
//"age":25


public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "ID Can't be null")
    private Integer id;

    @NotEmpty
    @Column(columnDefinition = "varchar(4) not null")
    private String name;


    @NotEmpty(message = "UserName Can't be null")
    @Column(columnDefinition = "varchar(4) not null unique")
    private String username;


    @NotEmpty(message = "Password Can't be null")
    private String password;


    @NotEmpty(message = "Email Can't be null")
    @Email
    @Column(columnDefinition = "varchar(50) not null unique")
    private String email;

    @NotEmpty(message = "Role Can't be null")
    @Column(columnDefinition = "varchar(20) not null  check( role='admin' or role = 'user' )")
    private String role;


    @NotNull(message = "Age Can't be null")
    @Column(columnDefinition = "int not null unique")
    private Integer age;
}
