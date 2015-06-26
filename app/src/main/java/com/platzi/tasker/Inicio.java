package com.platzi.tasker;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Inicio extends ActionBarActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        this.lista = (ListView) findViewById(R.id.lvTareas);
        this.lista.setAdapter(new TareasAdapter(this, getDatos()));
    }

    public List<Map<String,Object>> getDatos(){
        List<Map<String, Object>> datos = new ArrayList<>();
        for(int contador=1;contador<=10;contador++){
            Map<String, Object> m = new HashMap<>();
            m.put("titulo", "Titulo "+contador);
            m.put("descripcion", "Descripción "+contador);
            m.put("hecho", contador%3==0);
            datos.add(m);
        }
        return datos;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inicio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
