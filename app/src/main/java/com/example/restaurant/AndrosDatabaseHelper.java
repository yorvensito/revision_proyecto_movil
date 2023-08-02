package com.example.restaurant;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class AndrosDatabaseHelper extends SQLiteOpenHelper {
    //private static final String DATABASE_NOMBRE = "andros.db";


    //private static final String TABLA_PLATILLOS = "platillos";
    //private static final String PLATILLOS_COLUMNA_ID = "id";
    //private static final String PLATILLOS_COLUMNA_NOMBRE = "nombre";
    //private static final String PLATILLOS_COLUMNA_CALIFICACION = "calificacion";

    private static final int DATABASE_VERSION = 1;

    // Tabla para guardar la informacion de los clientes
    private static final String TABLA_CLIENTE = "cliente";
    private static final String CLIENTE_COLUMNA_ID = "_id";
    private static final String CLIENTE_COLUMNA_NOMBRE = "nombre";
    private static final String CLIENTE_COLUMNA_APELLIDO = "apellido";
    private static final String CLIENTE_COLUMNA_EDAD = "edad";
    private static final String CLIENTE_COLUMNA_SEXO = "sexo";
    private static final String CLIENTE_COLUMNA_DIRECCION = "direccion";
    private static final String CLIENTE_COLUMNA_CORREO = "email";
    private static final String CLIENTE_COLUMNA_NIVEL = "nivel";
    private static final String CLIENTE_COLUMNA_COMENTARIO = "comentario";
    private static final String CLIENTE_TABLA_CREATE =
            "CREATE TABLE " + TABLA_CLIENTE + " (" +
                    CLIENTE_COLUMNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    CLIENTE_COLUMNA_NOMBRE + " TEXT, " +
                    CLIENTE_COLUMNA_APELLIDO + " TEXT, " +
                    CLIENTE_COLUMNA_EDAD + " INTEGER, " +
                    CLIENTE_COLUMNA_SEXO + " TEXT, " +
                    CLIENTE_COLUMNA_DIRECCION + " TEXT, " +
                    CLIENTE_COLUMNA_CORREO + " TEXT, " +
                    CLIENTE_COLUMNA_NIVEL + " TEXT, " +
                    CLIENTE_COLUMNA_COMENTARIO + " TEXT" + ")";

    // Tabla para guardar la informacion de los platillos


    private static final String TABLA_PLATILLO = "platillos";
    private static final String PLATILLO_COLUMNA_ID = "id";
    private static final String PLATILLO_COLUMNA_NOMBRE = "nombre";
    private static final String PLATILLO_COLUMNA_CALIFICACION = "calificacion";
    private static final String PLATILLO_TABLA_CREATE =
            "CREATE TABLE " + TABLA_PLATILLO + " (" +
                    PLATILLO_COLUMNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    PLATILLO_COLUMNA_NOMBRE + " TEXT, " +
                    PLATILLO_COLUMNA_CALIFICACION + " REAL"
                    + ")";
    private static final String DATABASE_NAME = "andros.db";
    private static final String TABLA_PLATILLOS = "platillos";
    private static final String TABLA_PLATILLOS_PLATILLOS = "platillos" ;
    private static final String PLATILLO_COLUMNACOLUMN_CALIFICACION = "calificacion";


    public AndrosDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CLIENTE_TABLA_CREATE);
        db.execSQL(PLATILLO_TABLA_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_CLIENTE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_PLATILLOS);
        onCreate(db);
    }

    // Método para insertar un cliente en la tabla clientes
    public void guardarCliente(Cliente cliente) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CLIENTE_COLUMNA_NOMBRE, cliente.getNombres());
        values.put(CLIENTE_COLUMNA_APELLIDO, cliente.getApellidos());
        values.put(CLIENTE_COLUMNA_EDAD, cliente.getEdad());
        values.put(CLIENTE_COLUMNA_SEXO, cliente.getSexo());
        values.put(CLIENTE_COLUMNA_DIRECCION, cliente.getDireccion());
        values.put(CLIENTE_COLUMNA_CORREO, cliente.getCorreo());
        values.put(CLIENTE_COLUMNA_NIVEL, cliente.getNivel());
        values.put(CLIENTE_COLUMNA_COMENTARIO, cliente.getComentario());

        db.insert(TABLA_CLIENTE, null, values);
        db.close();
    }

    // Método para obtener los últimos comentarios de la tabla clientes
    @SuppressLint("Range")
    public List<Cliente> getUltimosComentarios() {
        List<Cliente> comentarios = new ArrayList<>();
        String query = "SELECT * FROM " + TABLA_CLIENTE + " ORDER BY " + CLIENTE_COLUMNA_ID + " DESC LIMIT 10";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                Cliente cliente = new Cliente();
                cliente.setNombre(cursor.getString(cursor.getColumnIndex(CLIENTE_COLUMNA_NOMBRE)));
                cliente.setApellido(cursor.getString(cursor.getColumnIndex(CLIENTE_COLUMNA_APELLIDO)));
                cliente.setEdad(cursor.getInt(cursor.getColumnIndex(CLIENTE_COLUMNA_EDAD)));
                cliente.setSexo(cursor.getString(cursor.getColumnIndex(CLIENTE_COLUMNA_SEXO)));
                cliente.setDireccion(cursor.getString(cursor.getColumnIndex(CLIENTE_COLUMNA_DIRECCION)));
                cliente.setCorreo(cursor.getString(cursor.getColumnIndex(CLIENTE_COLUMNA_CORREO)));
                cliente.setNivelEstudios(cursor.getString(cursor.getColumnIndex(CLIENTE_COLUMNA_NIVEL)));
                cliente.setComentario(cursor.getString(cursor.getColumnIndex(CLIENTE_COLUMNA_COMENTARIO)));

                comentarios.add(cliente);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return comentarios;
    }

    // Método para insertar una calificación para un platillo
    public void insertCalificacion(Platillo platillo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PLATILLO_COLUMNA_NOMBRE, platillo.getNombre);
        values.put(PLATILLO_COLUMNA_CALIFICACION, platillo.getCalificacion);
        db.insert(TABLA_PLATILLOS, null, values);
        db.close();
    }

    // Método para obtener el platillo más votado
    public String obtenerPlatilloMasVotado() {
        String platilloMasVotado = "";
        double maxCalificacion = 0.0;

        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + PLATILLO_COLUMNA_NOMBRE + " FROM " + TABLA_PLATILLOS +
                " WHERE " + PLATILLO_COLUMNA_CALIFICACION + " = (SELECT MAX(" + PLATILLO_COLUMNA_CALIFICACION + ") FROM " + TABLA_PLATILLOS + ")";

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            platilloMasVotado = cursor.getString(cursor.getColumnIndex(PLATILLO_COLUMNA_NOMBRE));
        }

        cursor.close();
        db.close();
        return platilloMasVotado;
    }

    // Método para obtener los últimos platillos calificados
    public List<Platillo> getUltimosPlatillosCalificados() {
        List<Platillo> ultimosPlatillos = new ArrayList<>();
        String query = "SELECT * FROM " + TABLA_PLATILLOS_PLATILLOS +
                " ORDER BY " + "DESC LIMIT 10";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                Platillo platillo = new Platillo();
                platillo.setNombre(cursor.getString(cursor.getColumnIndex(PLATILLO_COLUMNA_NOMBRE)));
                platillo.setCalificacion(cursor.getDouble(cursor.getColumnIndex(PLATILLO_COLUMNACOLUMN_CALIFICACION)));

                ultimosPlatillos.add(platillo);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return ultimosPlatillos;
    }
}