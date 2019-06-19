package com.javahelps.com.javahelps.turismoapp;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    private DestinoDbAdapter dbAdapter;
    private Cursor cursor;
    private DestinoCursorAdapter destinoAdapter ;
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(android.R.id.list);

        dbAdapter = new DestinoDbAdapter(this);
        dbAdapter.abrir();

        consultar();
        /*
         * Declaramos el controlador de la BBDD y accedemos en modo escritura
         */
        DestinoDbHelper dbHelper = new DestinoDbHelper(getBaseContext());

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Toast.makeText(getBaseContext(), "Base de datos preparada", Toast.LENGTH_LONG).show();
    }

    private void consultar()
    {
       cursor = dbAdapter.getCursor();
        startManagingCursor(cursor);
        destinoAdapter = new DestinoCursorAdapter(this, cursor);
        lista.setAdapter(destinoAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.destino, menu);
        return true;
    }
}
