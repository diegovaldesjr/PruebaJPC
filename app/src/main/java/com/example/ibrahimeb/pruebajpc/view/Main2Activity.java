package com.example.ibrahimeb.pruebajpc.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ibrahimeb.pruebajpc.R;
import com.example.ibrahimeb.pruebajpc.adapter.AdapterRecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class Main2Activity extends AppCompatActivity {

    //Lista de elementos
    private static ArrayList<Integer> items;

    private RecyclerView recyclerView;
    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        input = (EditText) findViewById(R.id.input);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Main2Activity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        items = new ArrayList<>();

        Button buttonAdd = (Button) findViewById(R.id.buttonAdd);
        Button buttonRemove = (Button) findViewById(R.id.buttonRemove);
        Button buttonSort = (Button) findViewById(R.id.buttonSort);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            //Obtiene valor colocado en el editext, lo agrega a la lista de elementos
            // y llama a la funcion para actualizar el recyclerview
            @Override
            public void onClick(View view) {
                Integer numero = Integer.parseInt(input.getText().toString());
                items.add(numero);
                actualizarRecyclerView();
            }
        });

        buttonRemove.setOnClickListener(new View.OnClickListener() {
            //Limpia lista de elementos y llama a la funcion para actualizar el recyclerview
            @Override
            public void onClick(View view) {
                items.clear();
                actualizarRecyclerView();
            }
        });

        buttonSort.setOnClickListener(new View.OnClickListener() {
            //Ordena la lista de elementos y llama a la funcion para actualizar el recyclerview
            @Override
            public void onClick(View view) {
                Collections.sort(items);
                actualizarRecyclerView();
            }
        });
    }

    //Funcion que crea y actualiza adaptador del recyclerview
    public void actualizarRecyclerView(){
        AdapterRecyclerView adapterRecyclerView = new AdapterRecyclerView(R.layout.list_elemento, this, items);
        recyclerView.setAdapter(adapterRecyclerView);
    }
}
