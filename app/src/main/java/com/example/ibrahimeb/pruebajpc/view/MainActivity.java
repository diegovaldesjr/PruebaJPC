package com.example.ibrahimeb.pruebajpc.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ibrahimeb.pruebajpc.R;
import com.example.ibrahimeb.pruebajpc.io.ApiAdapter;
import com.example.ibrahimeb.pruebajpc.io.response.ResponseGet;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView responseTextView;
    private TextView responseReverseTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonCallService = (Button) findViewById(R.id.buttonCallService);
        Button buttonGoToListActivity = (Button) findViewById(R.id.buttonGoToListActivity);

        responseTextView = (TextView) findViewById(R.id.response);
        responseReverseTextView = (TextView) findViewById(R.id.responseReverse);

        //Al hacer click llama a la funcion que hace la llamada http
        buttonCallService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                llamadaHttp();
            }
        });

        //Al hacer click llama a la funcion para ir a la actividad 2
        buttonGoToListActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPantalla2();
            }
        });

    }


    //Realiza llamada http mediante retrofit2
    public void llamadaHttp(){
        Call<ResponseGet> call = ApiAdapter.getApiService().get();

        call.enqueue(new Callback<ResponseGet>() {
            //Al llegar la respuesta, se le da formato al body y se asignan
            // los valores a los textview respectivos
            @Override
            public void onResponse(Call<ResponseGet> call, Response<ResponseGet> response) {
                if(response.isSuccessful()) {
                    ResponseGet data = response.body();

                    StringBuilder builder = new StringBuilder(data.getOrigin());

                    responseTextView.setText(builder.toString());
                    responseReverseTextView.setText(builder.reverse().toString());
                }
            }

            @Override
            public void onFailure(Call<ResponseGet> call, Throwable t) {
                Log.d("Error", "Error Respuesta en JSON: " +t.getMessage());
            }
        });
    }

    //Ir a la pantalla 2 donde se encuentra la lista de elementos
    public void showPantalla2(){
        startActivity(new Intent(this, Main2Activity.class));
    }
}
