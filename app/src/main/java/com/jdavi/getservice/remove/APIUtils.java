package com.jdavi.getservice.remove;

public class APIUtils {

    public static final String BASE_URL="http://api.geonames.org/"; //Produccion
    public static final String BASE_URL_QA="http://qa.api.geonames.org/"; //Entorno de pruebas


    public static WebServices getDataField(){

        return RetrofitClient.getClient(BASE_URL).create(WebServices.class);
    }

    public static WebServices getDataFieldQA(){

        return RetrofitClient.getClient(BASE_URL_QA).create(WebServices.class);
    }


}
