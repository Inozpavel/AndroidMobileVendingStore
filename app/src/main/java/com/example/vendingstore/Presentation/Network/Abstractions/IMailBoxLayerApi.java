package com.example.vendingstore.Presentation.Network.Abstractions;

import com.example.vendingstore.Presentation.Network.EmailValidation;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IMailBoxLayerApi
{
    @GET("/api/check")
    Call<EmailValidation.ValidationResponse> validateEmail(
            @Query(value = "email", encoded = true) String email,
            @Query("access_key") String token);
}
