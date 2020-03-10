package com.example.home;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;

public class PantallaInventario extends AppCompatActivity {
    Arma arma;
    Inventario inventario;
    Usuario user;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pantalla_inventario);
        ListView list = (ListView) findViewById(R.id.lista);
        inventario = new Inventario();
        Bundle b = getIntent().getExtras();

        GsonBuilder gsb = new GsonBuilder();
        gsb.setPrettyPrinting();
        Gson gson = gsb.create();

        File inventarioFile = new File("inventario.json");
        inventarioFile.mkdir();

        if (b != null) {

            if (b.containsKey("item")) {
                user = (Usuario) b.getSerializable("item");
            }



            if (b.containsKey("usuario")) {
                user = (Usuario) b.getSerializable("usuario");
            }


            if(b.containsKey("arma")){
                arma = (Arma) b.getSerializable("arma");
                inventario.addArma(arma);
                user.setDinero(user.getDinero()-arma.getValor());
                try {
                    FileWriter fw = new FileWriter("inventario.json");
                    gson.toJson(inventario, fw);
                    fw.flush();
                    fw.close();


                } catch (IOException e) {
                    e.printStackTrace();
                }


            }



            if(b.containsKey("valor")){
                Double valor = b.getDouble("valor");
                user.setDinero(user.getDinero()+valor);
            }

            TextView userName = findViewById(R.id.tvUserName);
            TextView userMoney = findViewById(R.id.tvUserMoney);
            userName.setText(user.getUser());
            userMoney.setText(String.valueOf(user.getDinero()));

            //Toast.makeText(this, user.getInventario().toString(), Toast.LENGTH_LONG).show();
            inventario = user.getInventario();

            try {
                FileWriter fw = new FileWriter("inventario.json");
                gson.toJson(inventario, fw);
                fw.flush();
                fw.close();

                DatabaseHelper dbh = new DatabaseHelper(this);
                dbh.actualizarDinero(user.getDinero(),user.getUser());

            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        try {
                FileReader fr = new FileReader("inventario.json");
                inventario = gson.fromJson(fr, Inventario.class);
                user.setInventario(inventario);
                DatabaseHelper dbh = new DatabaseHelper(this);
                dbh.addDataInventario(inventario.toString());
        }catch (IOException e) {
            e.printStackTrace();
        }

        ArmaListAdpater armaAdapter = new ArmaListAdpater(this,R.layout.item_view_layout2,inventario.getInventario());
        list.setAdapter(armaAdapter);


    }

    public void irACajas(View view) {
        Intent it = new Intent(this,PantallaSelectCase.class);
        Bundle b2 = new Bundle();
        b2.putSerializable("user2", user);
        it.putExtras(b2);
        startActivity(it);
    }

    public void Preferencias(View view) {
        Intent it = new Intent(this,SettingsActivity.class);
        startActivity(it);
    }
}

