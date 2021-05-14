package com.example.tpgit_miniblog;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitAPI {
    @POST("register")
    Call<DataModal> createPost(@Body DataModal dataModal);
}
