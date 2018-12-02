package com.firstapp.mvpmodel.apicontent;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    //    private final static String BASE_API_URL = "";
    public static final String BASE_API_URL ="http://falkentyres.projectdevelopment.co/";
    private static Retrofit retrofit1;
    public static Retrofit retrofit = null;
    private static Gson gson = new GsonBuilder().create();

    private static HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    private static OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor);

    private static OkHttpClient okHttpClient = okHttpClientBuilder.build();

    public static Retrofit getClient() {
        if (retrofit == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(100, TimeUnit.SECONDS)
                    .readTimeout(100, TimeUnit.SECONDS).build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_API_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            System.out.println("OKHTTPRESPONSE " + client);
        }

        return retrofit;
    }


    private static OkHttpClient.Builder httpclient = new OkHttpClient.Builder();
    private static HttpLoggingInterceptor loggin = new HttpLoggingInterceptor();


    private static ApiClient mInstance;

    public static ApiClient getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new ApiClient(context);
        }
        return mInstance;
    }


    public static Retrofit getClients() {
        try {
            if (retrofit == null) {
                OkHttpClient client = new OkHttpClient.Builder()
                        .connectTimeout(100, TimeUnit.SECONDS)
                        .readTimeout(100, TimeUnit.SECONDS).build();
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_API_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retrofit;
    }

    public static Retrofit getClientsPost() {
        try {
            if (retrofit == null) {
                OkHttpClient client = new OkHttpClient.Builder()
                        .connectTimeout(1000, TimeUnit.SECONDS)
                        .readTimeout(1000, TimeUnit.SECONDS).build();
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_API_URL)
                        .client(client)
                        .addConverterFactory(GsonConverterFactory.create())
                        //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retrofit;
    }

    private ApiClient(Context context) {
        Gson gson = new GsonBuilder().setLenient().create();
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(1000, TimeUnit.SECONDS)
                .readTimeout(1000, TimeUnit.SECONDS).build();
        loggin.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpclient.addInterceptor(loggin);
        retrofit = new Retrofit.Builder().baseUrl(BASE_API_URL)
                //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .addConverterFactory(GsonConverterFactory.
                        create(gson)).
                        client(httpclient.build())
                .build();
    }


    public <S> S createService(Class<S> serviceclass) {
        return retrofit1.create(serviceclass);
    }


}