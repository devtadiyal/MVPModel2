package com.firstapp.mvpmodel.apicontent;

import com.firstapp.mvpmodel.responsemodel.TyreListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("api/V1/TyresList")
    Call<TyreListResponse> tyre_list(@Header("Authorization") String authorization,
                                     @Header("Content-Type") String content_type);



}