package com.example.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RollScreen extends AppCompatActivity {

    private List<Integer> mImages = new ArrayList<Integer>();
    private Caja caja;
    Context context = this;
    private Usuario user;
    CarouselView carouselView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_screen);

        Bundle b = getIntent().getExtras();
        if (b != null) {
            if(b.containsKey("caja")){
            caja = (Caja) b.getSerializable("caja");

            for (Arma a : caja.getContenido()) {
                mImages.add(a.getImagen());
            }

            carouselView = findViewById(R.id.carousel);

            carouselView.setPageCount(mImages.size());
            carouselView.setImageListener(new ImageListener() {
                @Override
                public void setImageForPosition(int position, ImageView imageView) {
                    Random r = new Random();
                    int i = r.nextInt(mImages.size() - 1);
                    imageView.setImageResource(mImages.get(i));
                }
            });

            if(b.containsKey("usuario")){
                user = (Usuario) b.getSerializable("usuario");
            }
            }


            openCase();


        }
    }

    public void openCase(){

        new CountDownTimer(6000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                //int i = carouselView.getSlideInterval();
                //carouselView.setSlideInterval(i+500);
            }

            @Override
            public void onFinish() {

                Intent toShowWeapon =  new Intent(context,ShowWeapon.class);

                Random r = new Random();
                int it = r.nextInt(caja.getContenido().size());
                Arma arma = caja.getContenido().get(it);
                Bundle b2 = new Bundle();
                b2.putSerializable("arma", arma);
                b2.putSerializable("usuario",user);
                toShowWeapon.putExtras(b2);

                startActivity(toShowWeapon);
            }






        }.start();


    }

}
