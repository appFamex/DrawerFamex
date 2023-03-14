package com.example.drawerfamex.backend.interfaces;

import com.example.drawerfamex.backend.models.customers.MessageCustomer;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CustomersClient {

    @POST("customer")
    Call<MessageCustomer> registerCustomer (@Body MessageCustomer message);

}
