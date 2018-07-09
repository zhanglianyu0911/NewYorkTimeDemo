package com.example.lianyuzhang.newyorktimedemo.activity.api;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
* A RetrofitService to create Retrofit object
*/
public class RetrofitService {
    private static NewsListService mInstance = null;
    private static final String API_KEY = "d31fe793adf546658bd67e2b6a7fd11a";
    private static final String API_BASE_URL = "https://api.nytimes.com/svc/search/v2/";
    public static final String API_IMAGE_BASE_URL = "http://www.nytimes.com/";

    private RetrofitService() {}

    public static NewsListService getInstance() {
        if (mInstance == null) {
            mInstance = getRetrofit().create(NewsListService.class);
        }
        return mInstance;
    }

    private static Retrofit getRetrofit() {

        // Customise Gson instance
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

        // Append api-key parameter to every query
        Interceptor apiKeyInterceptor = chain -> {
            Request request = chain.request();
            HttpUrl url = request.url().newBuilder().addQueryParameter("api-key", API_KEY).build();
            request = request.newBuilder().url(url).build();
            return chain.proceed(request);
        };

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(apiKeyInterceptor)
                .addNetworkInterceptor(new StethoInterceptor())  // Enable Stetho network inspection
                .build();

        // Create Retrofit instance
        return new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}
