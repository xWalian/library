//package com.example.library.model;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Size;
//
//@Entity
//public class User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NotBlank(message = "Imię użytkownika jest wymagane")
//    private String firstName;
//
//    @NotBlank(message = "Nazwisko użytkownika jest wymagane")
//    private String lastName;
//
//    @NotBlank(message = "Adres email jest wymagany")
//    @Email(message = "Podaj poprawny adres email")
//    private String email;
//
//    @NotBlank(message = "Hasło jest wymagane")
//    @Size(min = 6, message = "Hasło musi zawierać co najmniej 6 znaków")
//    private String password;
//
//    // Gettery i settery
//    // ...
//}
