package com.example.home;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";
    private static final String TABLE_NAME = "usuariosPrueba";
    private static final String COL1 = "Usuario";
    private static final String COL2 = "Pass";
    private static final String COL3 = "Dinero";
    private static final String COL4 = "Inventario";


    public DatabaseHelper(Context context) {
        super(context, TABLE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTable = " CREATE TABLE " + TABLE_NAME + " (" + COL1 + " varchar(25) PRIMARY KEY, " +
                COL2 + " varchar(25), " + COL3 + " double, " + COL4 + " varchar(10000))";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public boolean addData(String nombre, String contrasenia, Double dinero) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, nombre);
        contentValues.put(COL2, contrasenia);
        contentValues.put(COL3, dinero);

        Log.d(TAG, "addData: Adding " + nombre + " to " + TABLE_NAME);
        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public boolean addDataInventario(String inventario) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL4, inventario);


        Log.d(TAG, "addData: Adding " + inventario + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public void actualizarDinero(Double dinero, String nombre) {
        SQLiteDatabase db = this.getWritableDatabase();
        String updateDinero = "UPDATE " + TABLE_NAME + " SET " + COL3 + " = " + dinero + "WHERE [Usuario] = '" + nombre + "'";
        db.execSQL(updateDinero);
    }

    public Usuario comprobarUsuario(String nombre, String pass) {
        Usuario u = new Usuario();
        SQLiteDatabase db = this.getWritableDatabase();
        String consulta = "SELECT * FROM " + TABLE_NAME+ " WHERE Usuario = '" + nombre + "'";
        Cursor c = db.rawQuery(consulta, null);
        c.moveToFirst();
        String nombredb = c.getString(0);
        String passdb = c.getString(1);
        String dinerodb = c.getString(2);
        //String inventariodb = c.getString(4);
        c.close();

        if (nombre.equals(nombredb) && pass.equals(passdb)) {
            u = new Usuario(nombredb, passdb, null, Double.parseDouble(dinerodb));
        }
        return u;
    }

}
