package com.example.drawerfamex.backend.interfaces;

import com.example.drawerfamex.backend.models.MessageLogin;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SecurityClient {

    @POST("users")
    Call<MessageLogin> createUser (@Body MessageLogin message);

    @POST("users")
    Call<MessageLogin> updateUser (@Body MessageLogin message);

}
