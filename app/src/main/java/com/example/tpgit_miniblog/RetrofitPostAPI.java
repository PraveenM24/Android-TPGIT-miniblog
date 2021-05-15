package com.example.tpgit_miniblog;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitPostAPI {

    @POST("register")
    Call<PostUserData> createPost(@Body PostUserData postUserData);
}
