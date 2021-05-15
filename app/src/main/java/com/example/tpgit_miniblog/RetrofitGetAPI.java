package com.example.tpgit_miniblog;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitGetAPI {
    @GET("register")
    Call<List<GetUserData>> getUsers();
}
