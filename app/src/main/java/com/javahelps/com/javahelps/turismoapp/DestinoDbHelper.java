package com.javahelps.com.javahelps.turismoapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DestinoDbHelper extends SQLiteOpenHelper {

    private static int version = 1;
    private static String name = "DestinoDb" ;
    private static CursorFactory factory = null;

    public DestinoDbHelper(Context context)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        Log.i(this.getClass().toString(), "Creando base de datos");

        db.execSQL( "CREATE TABLE DESTINO(" +
                " _id INTEGER PRIMARY KEY," +
                " d_nombre TEXT NOT NULL, " +
                " d_compania TEXT, " +
                " d_tipo TEXT," +
                " d_precio TEXT," +
                " d_aflu TEXT," +
                " d_fecha TEXT," +
                " d_descripcion TEXT)" );

        db.execSQL( "CREATE UNIQUE INDEX _id ON DESTINO(_id ASC)" );

        Log.i(this.getClass().toString(), "Tabla DESTINO creada");

        /*
         * Insertamos datos iniciales
         */
        db.execSQL("INSERT INTO DESTINO(_id, d_nombre, d_compania, d_tipo, d_precio, d_aflu, d_fecha, d_descripcion) " +
                "VALUES(1,'Viña Rock(Albacete)','amigos','interior',null,'alta','mayo',null)");
        db.execSQL("INSERT INTO DESTINO(_id, d_nombre, d_compania, d_tipo, d_precio, d_aflu, d_fecha, d_descripcion) " +
                "VALUES(2,'Dr Music Festival','familia','costa',null,'media','julio',null)");
        db.execSQL("INSERT INTO DESTINO(_id, d_nombre, d_compania, d_tipo, d_precio, d_aflu, d_fecha, d_descripcion) " +
                "VALUES(3,'Dr Music Festival','amigos','costa',null,'media','julio',null)");
        db.execSQL("INSERT INTO DESTINO(_id, d_nombre, d_compania, d_tipo, d_precio, d_aflu, d_fecha, d_descripcion) " +
                "VALUES(4,'Low Festival(Benidorm)','amigos','costa',null,'media','julio',null)");
        db.execSQL("INSERT INTO DESTINO(_id, d_nombre, d_compania, d_tipo, d_precio, d_aflu, d_fecha, d_descripcion) " +
                "VALUES(5,'Hogueras San Juan','pareja','costa','€','alta','junio',null)");
        db.execSQL("INSERT INTO DESTINO(_id, d_nombre, d_compania, d_tipo, d_precio, d_aflu, d_fecha, d_descripcion) " +
                "VALUES(6,'Hogueras San Juan','solo','costa','€','alta','junio',null)");
        db.execSQL("INSERT INTO DESTINO(_id, d_nombre, d_compania, d_tipo, d_precio, d_aflu, d_fecha, d_descripcion) " +
                "VALUES(7,'Hogueras San Juan','familia','costa','€','alta','junio',null)");

        Log.i(this.getClass().toString(), "Datos iniciales DESTINOS insertados");

        Log.i(this.getClass().toString(), "Base de datos creada");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
