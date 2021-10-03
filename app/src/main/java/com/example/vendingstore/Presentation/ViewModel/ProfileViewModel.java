package com.example.vendingstore.Presentation.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.vendingstore.Domain.Model.User;

import java.time.LocalDate;

public class ProfileViewModel extends ViewModel
{
    private MutableLiveData<User> data;

    public ProfileViewModel()
    {
        data = new MutableLiveData<>();
        this.data = new MutableLiveData<>();

        User user = new User(
                "iivanov@mail.ru",
                "Иван",
                "Иванов",
                "+7 (999) 999 99 99",
                LocalDate.of(1990, 12, 9));

        data.setValue(user);
    }

    public LiveData<User> getUser()
    {
        return data;
    }
}
