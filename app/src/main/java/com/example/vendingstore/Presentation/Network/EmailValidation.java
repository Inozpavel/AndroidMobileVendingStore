package com.example.vendingstore.Presentation.Network;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.vendingstore.BuildConfig;
import com.example.vendingstore.Presentation.Network.Abstractions.IMailBoxLayerApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EmailValidation
{
    private final IMailBoxLayerApi mailBoxLayerApi;

    public EmailValidation()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://apilayer.net")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mailBoxLayerApi = retrofit.create(IMailBoxLayerApi.class);
    }

    public LiveData<Boolean> ValidateEmail(String email)
    {
        MutableLiveData<Boolean> data = new MutableLiveData<>();

        mailBoxLayerApi.validateEmail(email, BuildConfig.API_KEY).enqueue(new Callback<ValidationResponse>()
        {
            @Override
            public void onResponse(Call<ValidationResponse> call, Response<ValidationResponse> response)
            {
                if (response.isSuccessful() && response.body() != null)
                {
                    data.setValue(response.body().getFormat_valid());
                }
            }

            @Override
            public void onFailure(Call<ValidationResponse> call, Throwable t)
            {

            }
        });

        return data;
    }

    public static class ValidationResponse
    {
        private String email;
        private String user;
        private String domain;
        private boolean format_valid;

        public String getEmail()
        {
            return email;
        }

        public void setEmail(String email)
        {
            this.email = email;
        }

        public String getUser()
        {
            return user;
        }

        public void setUser(String user)
        {
            this.user = user;
        }

        public String getDomain()
        {
            return domain;
        }

        public void setDomain(String domain)
        {
            this.domain = domain;
        }

        public boolean getFormat_valid()
        {
            return format_valid;
        }

        public void setFormat_valid(boolean format_valid)
        {
            this.format_valid = format_valid;
        }
    }
}
