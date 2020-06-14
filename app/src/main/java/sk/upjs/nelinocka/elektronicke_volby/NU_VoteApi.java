package sk.upjs.nelinocka.elektronicke_volby;

import java.util.List;

import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.*;

public interface NU_VoteApi {
    String BASE_URL =
            "http://localhost:3000/";

    @GET("Muggles")
    Call<List<NU_User>> getUsers();

    @GET("Muggles/{op}")
    Call<List<NU_User>> getUsersOP(@Path(value = "op", encoded = true) String op);

    @GET("Muggles/{pin}")
    Call<List<NU_User>> getUsersPIN(@Path(value = "pin", encoded = true) String pin);

    @GET("Muggles/{kraj}")
    Call<List<NU_User>> getUsersKraj(@Path(value = "kraj", encoded = true) String kraj);

    @GET("Muggles/{hlasoval}")
    Call<List<NU_User>> getUsersHlasoval(@Path(value = "hlasoval", encoded = true) int hlasoval);

    @PUT("Muggles/{plantId}")
    Call<NU_User> updateUser(@Path(value = "op", encoded = true) String op, @Body NU_User user);

    Retrofit RETROFIT = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    NU_VoteApi API = RETROFIT.create(NU_VoteApi.class);
}