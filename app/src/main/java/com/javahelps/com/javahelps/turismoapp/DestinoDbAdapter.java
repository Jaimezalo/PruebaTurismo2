package com.javahelps.com.javahelps.turismoapp;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class DestinoDbAdapter {

    /**
     * Definimos constante con el nombre de la tabla
     */
    public static final String C_TABLA = "DESTINO" ;

    /**
     * Definimos constantes con el nombre de las columnas de la tabla
     */
    public static final String C_ID   = "_id";
    public static final String C_NOMBRE = "d_nombre";
    public static final String C_COMPANIA = "d_compania";
    public static final String C_TIPO = "d_tipo";
    public static final String C_PRECIO = "d_precio";
    public static final String C_AFLUENCIA = "d_aflu";
    public static final String C_FECHA = "d_fecha";
    public static final String C_DESCRIPCION = "d_descripcion";

    private Context contexto;
    private DestinoDbHelper dbHelper;
    private SQLiteDatabase db;

    public DestinoDbAdapter(Context context)
    {
        this.contexto = context;
    }

    public DestinoDbAdapter abrir() throws SQLException
    {
        dbHelper = new DestinoDbHelper(contexto);
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void cerrar()
    {
        dbHelper.close();
    }

    /**
     * Devuelve cursor con todos las columnas de la tabla
     */
    public Cursor getCursor() throws SQLException
    {
        /**
         * Definimos lista de columnas de la tabla para utilizarla en las consultas a la base de datos
         */
        String[] columnas = new String[]{C_ID, C_NOMBRE, C_COMPANIA, C_TIPO, C_PRECIO, C_AFLUENCIA, C_FECHA, C_DESCRIPCION};
        String seleccion = C_AFLUENCIA + " =?  AND " + C_TIPO + " =?";
        String selectionArgs[] = new String[]{"alta","interior"};
        Cursor c = db.query( true, C_TABLA, columnas, seleccion, selectionArgs, null, null, null, null);

        return c;
    }


}