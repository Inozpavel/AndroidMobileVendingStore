package com.example.onlinestore.Domain.Model;

public class Person
{
    private String name;
    private String lastName;
    private String phone;

    public Person(String name, String lastName)
    {
        this.name = name;
        this.lastName = lastName;
    }
    
    //region getters and setters
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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
    //endregion
}

