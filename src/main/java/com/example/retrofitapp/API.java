package com.example.retrofitapp;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface API {
    @GET ("api/data/")
    public Call<ArrayList<Data>> getAllData();
    @GET ("api/data/{Email}/{Password}/")
    public Call<Data> getyourProfile(@Path(value = "Email" , encoded = true) String email
    , @Path(value = "Password" , encoded = true) String password);
    @POST ("api/data/")
    public Call<ResponseBody> postAllData(@Body Data data);
}
