package com.platzi.tasker;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by andres on 25/06/15.
 */
public class TareasAdapter extends RecyclerView.Adapter<TareaViewHolder> {

    List<Map<String,Object>> datos;
    Context context;
    private LayoutInflater ensamblador = null;

    public TareasAdapter(Context context, List<Map<String,Object>> datos){
        if(datos==null){
            datos = new ArrayList<>();
        }
        this.datos = datos;
        this.context = context;
        this.ensamblador = LayoutInflater.from(this.context);
    }


    @Override
    public TareaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = ensamblador.inflate(R.layout.cell_tarea, parent, false);
        return new TareaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TareaViewHolder holder, int position) {
        Map<String, Object> dato = (Map<String, Object>) this.datos.get(position);
        holder.titulo.setText(dato.get("titulo").toString());
        holder.descripcion.setText(dato.get("descripcion").toString());
        holder.hecho.setChecked((boolean)dato.get("hecho"));
    }

    @Override
    public int getItemCount() {
        return this.datos.size();
    }

}
