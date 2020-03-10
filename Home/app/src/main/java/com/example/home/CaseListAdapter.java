package com.example.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CaseListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Caja> cajas;
    private Usuario user;

    public CaseListAdapter(Context context, ArrayList<Caja> cajas) {
        this.cajas=cajas;
        this.context = context;

    }

    @Override
    public int getCount() {
        return cajas.size();
    }

    @Override
    public Object getItem(int position) {
        return cajas.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.case_view_layout, null);

        String nombreCaja=cajas.get(position).getNombre();
        Double costoCaja=cajas.get(position).getCosto();
        ArrayList<Arma> listaArmas=cajas.get(position).getContenido();
        int img=cajas.get(position).getImg();

        ImageButton btnImg = (ImageButton) convertView.findViewById(R.id.btnCaseImg);
        TextView liCaseCost = (TextView) convertView.findViewById(R.id.caseCost);
        btnImg.setImageResource(img);
        liCaseCost.setText(nombreCaja+"\n"+Double.toString(costoCaja)+"€");

        btnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CaseContent.class);
                Caja cajaBundle = cajas.get(position);
                Usuario usuario = user;
                Bundle b = new Bundle();
                b.putSerializable("usuario",usuario);
                b.putSerializable("caja", cajaBundle);
                intent.putExtras(b);
                context.startActivity(intent);
                Vibrator vib = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                vib.vibrate(300);

            }
        });
        return convertView;
    }


    public void recibirUsuario(Usuario u){
        this.user = u;
    }
}