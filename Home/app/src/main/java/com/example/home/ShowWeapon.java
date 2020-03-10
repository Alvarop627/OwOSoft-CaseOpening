package com.example.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

public class ShowWeapon extends AppCompatActivity {
    SharedPreferences preferences;
    private Usuario user;
    private Arma arma;
    private Button btnVender;
    private Button btnGuardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_weapon);
        PreferenceManager.setDefaultValues(this,R.xml.root_preferences,true);
        preferences= PreferenceManager.getDefaultSharedPreferences(this);
        btnVender=findViewById(R.id.btnVender);
        btnGuardar=findViewById(R.id.btnGuardar);
        Bundle b = getIntent().getExtras();
        if (b != null) {
            if(b.containsKey("arma")) {
                arma = (Arma) b.getSerializable("arma");
                ImageView weaponImage = findViewById(R.id.weaponImage);
                TextView tipoArma = findViewById(R.id.txtTipoArma);
                TextView nombreSkin = findViewById(R.id.txtNombreSkin);
                TextView calidad = findViewById(R.id.txtCalidad);
                TextView valor = findViewById(R.id.txtValor);

                weaponImage.setImageResource(arma.getImagen());
                tipoArma.setText(arma.getTipoArma());
                nombreSkin.setText(arma.getNombreSkin());
                calidad.setText(arma.getCalidad());
                valor.setText(arma.getValor().toString());
            }
            if(b.containsKey("usuario")){
                user = (Usuario) b.getSerializable("usuario");
            }
        }


    }

    public void guardarArma(View view){

        Intent toInventario = new Intent(this, PantallaInventario.class);
        Bundle b2 = new Bundle();
        b2.putSerializable("arma", arma);
        b2.putSerializable("usuario", user);
        toInventario.putExtras(b2);
        if(preferences.getBoolean("vibe_check",true)){
            Vibrator vib = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
            vib.vibrate(500);
        }
        startActivity(toInventario);

    }

    public void venderArma(View view){
        Intent toInventario = new Intent(this, PantallaInventario.class);
        Bundle b2 = new Bundle();
        b2.putDouble("valor", arma.getValor());
        toInventario.putExtras(b2);
        if(preferences.getBoolean("vibe_check",true)){
            Vibrator vib = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
            vib.vibrate(500);
        }
        startActivity(toInventario);
    }

    @Override
    public void onBackPressed() {

    }

}

