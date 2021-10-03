package com.example.vendingstore.Domain.Model;

import java.time.LocalDate;
import java.time.OffsetDateTime;

public class User
{
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private OffsetDateTime registrationTime;
    private LocalDate birthDate;

    public User(String email, String firstName, String lastName, String phone, LocalDate birthDate)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.registrationTime = OffsetDateTime.now();
        this.birthDate = birthDate;
    }

    //region getters and setters
    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public OffsetDateTime getRegistrationTime()
    {
        return registrationTime;
    }

    public void setRegistrationTime(OffsetDateTime registrationTime)
    {
        this.registrationTime = registrationTime;
    }

    public LocalDate getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate)
    {
        this.birthDate = birthDate;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
    //endregion
}

