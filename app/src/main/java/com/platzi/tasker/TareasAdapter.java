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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by andres on 25/06/15.
 */
public class TareasAdapter extends RecyclerView.Adapter<TareaViewHolder> {

    Map<Object, Map<String, Object>> datos;
    Context context;
    private LayoutInflater ensamblador = null;
    private Object[] keys = null;

    public TareasAdapter(Context context){
        this.context = context;
        this.ensamblador = LayoutInflater.from(this.context);
        datos = new HashMap<>();
    }


    @Override
    public TareaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = ensamblador.inflate(R.layout.cell_tarea, parent, false);
        return new TareaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TareaViewHolder holder, int position) {
        Map<String, Object> dato = (Map<String, Object>) this.datos.get(this.keys[position]);
        if(dato!=null) {
            holder.titulo.setText(dato.get("name").toString());
            holder.descripcion.setText(dato.get("description").toString());
            holder.hecho.setChecked(Boolean.parseBoolean(String.valueOf(dato.get("done"))));
        }
    }

    @Override
    public int getItemCount() {
        return this.datos.size();
    }

    public void setDatos(Map<Object, Map<String, Object>> datos) {
        this.datos = datos;
        this.keys = datos.keySet().toArray();
    }
}
