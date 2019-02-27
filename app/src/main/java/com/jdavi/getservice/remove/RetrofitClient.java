package com.jdavi.getservice.remove;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit=null;
    static OkHttpClient okHttpClient=new OkHttpClient.Builder() //Hacer aut y manejar tipos de respuesta de servicios
            .connectTimeout(1,TimeUnit.MINUTES)
            .readTimeout(30,TimeUnit.SECONDS)
            .writeTimeout(15,TimeUnit.SECONDS)
            .build();   //Autenticador con tiempos de repuesta

    public static Retrofit getClient(String url){  //Verificar logeo efectivo

        if (retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(url)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        Log.d("Retrofit","Local URL"+retrofit.baseUrl());
        return retrofit; //Devolver objeto retrofit
    }

}
