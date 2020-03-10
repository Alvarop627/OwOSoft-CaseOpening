package com.example.home;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ArmaGridAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Arma> armas;

    public ArmaGridAdapter(Context context, ArrayList<Arma> armas) {
        this.context = context;
        this.armas = armas;

    }

    @Override
    public int getCount() {
        return armas.size();
    }

    @Override
    public Object getItem(int position) {
        return armas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        //Arma armaAux = new Arma(tipoArma,nombreSkin,calidad,valorSkin,usado,img);
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.item_view_layout,null);
        ImageView liImg = (ImageView) convertView.findViewById(R.id.skinImage);
        TextView liTipoArma = (TextView) convertView.findViewById(R.id.wpnName);
        TextView liNombreSkin = (TextView) convertView.findViewById(R.id.skinName);
        TextView liCalidad =  (TextView) convertView.findViewById(R.id.txtQuality);

        liImg.setImageResource(armas.get(position).getImagen());
        liTipoArma.setText(armas.get(position).getTipoArma());
        liNombreSkin.setText(armas.get(position).getNombreSkin());
        liCalidad.setText(armas.get(position).getCalidad());

        return convertView;

    }
}
