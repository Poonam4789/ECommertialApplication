package com.demo.example.ecommertialapplication.network;

import com.demo.example.ecommertialapplication.CommercialProductsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApiInterface
{
    @GET("/json")
    Call<CommercialProductsResponse> getCommercialProducts();
}