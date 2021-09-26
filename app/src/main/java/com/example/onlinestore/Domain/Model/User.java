package com.example.onlinestore.Domain.Model;

import java.time.OffsetDateTime;

public class User
{
    private String firstName;
    private String lastName;
    private String phone;
    private OffsetDateTime registrationTime;

    public User(String firstName, String lastName, String phone)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        registrationTime = OffsetDateTime.now();
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
    //endregion
}

