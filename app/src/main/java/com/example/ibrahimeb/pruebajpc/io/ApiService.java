package com.example.ibrahimeb.pruebajpc.io;

import com.example.ibrahimeb.pruebajpc.io.response.ResponseGet;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ibrahimeb on 17/1/2018.
 */

public interface ApiService {

    //Llamadas http

    @GET("get")
    Call<ResponseGet> get();
}
