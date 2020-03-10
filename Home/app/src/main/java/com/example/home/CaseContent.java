package com.example.home;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;

public class CaseContent extends AppCompatActivity {

    private Caja caja;
    private Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_content);
        Bundle b = getIntent().getExtras();
        if (b != null) {
            if(b.containsKey("caja")){
            caja = (Caja) b.getSerializable("caja");
            }

            if(b.containsKey("usuario")){
            user = (Usuario) b.getSerializable("usuario");
            }

            GridView grid = (GridView) findViewById(R.id.gridArmas);

            ArmaGridAdapter gridAdapter = new ArmaGridAdapter(this, caja.getContenido());
            grid.setAdapter(gridAdapter);


        }

    }

    public void openCase (View view){

        Intent toRollScreen = new Intent(this, RollScreen.class);
        Bundle b2 = new Bundle();
        b2.putSerializable("caja", caja);
        b2.putSerializable("usuario",user);
        toRollScreen.putExtras(b2);
        Vibrator vib = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
        vib.vibrate(500);
        startActivity(toRollScreen);


    }

}


