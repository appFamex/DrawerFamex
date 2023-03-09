package com.example.drawerfamex.backend.interfaces;

import com.example.drawerfamex.backend.models.login.MessageLogin;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginClient {

    @POST("/orchestration/service/login")
    Call<MessageLogin> login (@Body MessageLogin message);

}
