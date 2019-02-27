package com.jdavi.getservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.jdavi.getservice.models.MyEarthquake;
import com.jdavi.getservice.remove.APIUtils;
import com.jdavi.getservice.remove.WebServices;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public Button llamado;
    public WebServices webServices;
    public static String URL="http://api.geonames.org/earthquakesJSON?north=44.1&south=-0.3012878&east=-79.4&west=-61.0184629&username=javierjordan23";
    public static String CLASS_TAG=MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webServices=APIUtils.getDataField();
        llamado=findViewById(R.id.button);

        llamado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webServices.getEartquakeData(URL).enqueue(new Callback<MyEarthquake>() {
                    @Override
                    public void onResponse(Call<MyEarthquake> call, Response<MyEarthquake> response) {
                        //almacena en el string la respuesta del response
                        if (response.isSuccessful()){ //Respuesta efectiva
                            String response1=new Gson().toJson(response.body());
                            Log.e(CLASS_TAG, "response JSON"+response1);
                            try {
                                JSONObject terremoto = new JSONObject(response1);
                                Log.e(CLASS_TAG, "response JSON"+response1);
                                JSONArray jsonArray=terremoto.getJSONArray("earthquakes");
                                Log.e(CLASS_TAG, "response JSON JSONArray"+jsonArray);

                                for (int i=0; i<response.body().getEarthquakes().size();i++){
                                    //TAREA: vacio la lista en un list view si toco una me lleva a esa posicion en el mapa
                                    //si le doy ver all me muestra eso en el mapa
                                    Log.e(CLASS_TAG, "response retrofit"+response.body().getEarthquakes().get(i).getDatetime());
                                    Log.e(CLASS_TAG, "response retrofit"+response.body().getEarthquakes().get(i).getDepth());
                                    Log.e(CLASS_TAG, "response retrofit"+response.body().getEarthquakes().get(i).getLat());
                                    Log.e(CLASS_TAG, "response retrofit"+response.body().getEarthquakes().get(i).getLng());
                                }

                            }catch (JSONException e){
                                e.printStackTrace();
                            }

                        }else{
                            int code=response.code();
                            Log.e(CLASS_TAG, "code"+code);
                        }
                    }

                    @Override
                    public void onFailure(Call<MyEarthquake> call, Throwable t) {

                        Log.e(CLASS_TAG, "ronFailure"+t.getMessage());

                    }
                });
            }
        });
    }
}
