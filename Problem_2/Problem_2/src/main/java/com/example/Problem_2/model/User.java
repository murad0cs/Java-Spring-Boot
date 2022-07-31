package com.example.Problem_2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import java.util.UUID;

public class User {
    private final UUID id;
    @NonNull
    private final String name;
    @NonNull
    private final String dob;
    @NonNull
    private final String address;

    @NonNull
    private final String email;

    private Gender gender;



    public User(@JsonProperty("id") UUID id,
                @JsonProperty("name") String name,
                @JsonProperty("dob") String dob,
                @JsonProperty("address") String address,
                @JsonProperty("email") String email,
                @JsonProperty("gender") Gender gender) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.email = email;
        this.gender = gender;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public Enum<Gender> getGender() {
        return gender;
    }

//    public static gender getGender(String gender) {
//        if (gender.startsWith("Ma")) {
//            return Male;
//        } else if (gender.startsWith("Fe")) {
//
//            return Female;
//
//        }
//        return Other;
//    }
}
