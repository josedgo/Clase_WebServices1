package com.jdavi.getservice.remove;

import com.jdavi.getservice.models.MyEarthquake;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface WebServices {

    @GET
    Call<MyEarthquake> getEartquakeData(@Url String url);




}
