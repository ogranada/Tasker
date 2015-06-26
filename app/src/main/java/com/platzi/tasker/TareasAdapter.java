package com.platzi.tasker;

import android.content.Context;
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
public class TareasAdapter extends BaseAdapter {

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
    public int getCount() {
        return this.datos.size();
    }

    @Override
    public Object getItem(int position) {
        return this.datos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Map<String, Object> dato = (Map<String, Object>) getItem(position);
        View item = ensamblador.inflate(R.layout.cell_tarea, null);
        TextView titulo = (TextView) item.findViewById(R.id.txtTitulo);
        TextView descripcion = (TextView) item.findViewById(R.id.txtDescripcion);
        CheckBox hecho = (CheckBox) item.findViewById(R.id.chkHecho);
        titulo.setText(dato.get("titulo").toString());
        descripcion.setText(dato.get("descripcion").toString());
        hecho.setChecked((boolean)dato.get("hecho"));
        return item;
    }
}
