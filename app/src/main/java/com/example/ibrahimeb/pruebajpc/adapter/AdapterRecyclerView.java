package com.example.ibrahimeb.pruebajpc.adapter;

import android.app.Activity;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ibrahimeb.pruebajpc.R;

import java.util.ArrayList;

/**
 * Created by ibrahimeb on 17/1/2018.
 */

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolderReclyclerView> {

    private int resource;
    private Activity activity;
    private ArrayList<Integer> items;

    public AdapterRecyclerView(int resource, Activity activity, ArrayList<Integer> items) {
        this.resource = resource;
        this.activity = activity;
        this.items = items;
    }

    @Override
    public ViewHolderReclyclerView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);

        return new ViewHolderReclyclerView(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolderReclyclerView holder, final int position) {

        //Actualiza el textview con el valor del elemento
        holder.numero.setText(String.valueOf(items.get(position).toString()));

        holder.layout.setOnClickListener(new View.OnClickListener() {
            //Oculta elemento y lo remueve de la lista de elementos
            @Override
            public void onClick(View view) {
                holder.layout.setVisibility(View.INVISIBLE);
                items.remove(position);
            }
        });
    }

    //Devuelve el tamaño de la lista
    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolderReclyclerView extends RecyclerView.ViewHolder{

        private ConstraintLayout layout;
        private TextView numero;

        public ViewHolderReclyclerView(View itemView) {
            super(itemView);

            layout = (ConstraintLayout) itemView.findViewById(R.id.layout);
            numero = (TextView) itemView.findViewById(R.id.numero);
        }
    }
}
