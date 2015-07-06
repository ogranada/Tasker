package com.platzi.tasker;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by andres on 29/06/15.
 */
public class TareaViewHolder extends RecyclerView.ViewHolder {

    TextView titulo;
    TextView descripcion;
    CheckBox hecho;

    public TareaViewHolder(View item) {
        super(item);
        titulo = (TextView) item.findViewById(R.id.txtTitulo);
        descripcion = (TextView) item.findViewById(R.id.txtDescripcion);
        hecho = (CheckBox) item.findViewById(R.id.chkHecho);
    }



}
