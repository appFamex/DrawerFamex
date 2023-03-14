package com.example.drawerfamex.backend.interfaces;

import com.example.drawerfamex.backend.models.login.MessageLogin;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface SecurityClient {

    @POST("users")
    Call<MessageLogin> createUser (@Body MessageLogin message);

    @PUT("users")
    Call<MessageLogin> updateUser (@Body MessageLogin message);

}
