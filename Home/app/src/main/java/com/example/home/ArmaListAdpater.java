package com.example.home;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import java.util.ArrayList;

public class ArmaListAdpater extends ArrayAdapter<Arma> {
    private Context context;
    private int resource;

    public ArmaListAdpater(Context context, int resource,ArrayList<Arma> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String tipoArma= getItem(position).getTipoArma();
        String nombreSkin = getItem(position).getNombreSkin();
        Double valorSkin = getItem(position).getValor();
        String calidad = getItem(position).getCalidad();
        boolean usado = getItem(position).isUsado();
        int img = getItem(position).getImagen();

        Arma armaAux = new Arma(tipoArma,nombreSkin,calidad,valorSkin,usado,img);
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource,parent,false);

        ImageView liImg = (ImageView) convertView.findViewById(R.id.skinImage);
        TextView liNombreArma = (TextView) convertView.findViewById(R.id.wpnName);
        TextView liNombreSkin = (TextView) convertView.findViewById(R.id.skinName);

        liImg.setImageResource(img);
        liNombreArma.setText(tipoArma);
        liNombreSkin.setText(nombreSkin);

        return convertView;

    }
}
