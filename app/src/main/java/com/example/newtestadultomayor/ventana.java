package com.example.newtestadultomayor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ventana extends Activity {
    Button b1, b2;
    LinearLayout mykonten, overbox;
    ImageView im;
    Animation fromsmall, fromnothing,forloci,togo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana);

        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.aceptar);

        mykonten = (LinearLayout) findViewById(R.id.mykonten);
        overbox = (LinearLayout) findViewById(R.id.overbox);

        im = (ImageView) findViewById(R.id.imageView13);

        fromsmall = AnimationUtils.loadAnimation(this, R.anim.fromsmall);
        fromnothing = AnimationUtils.loadAnimation(this, R.anim.fromnothing);
        forloci = AnimationUtils.loadAnimation(this, R.anim.forloci);
        togo = AnimationUtils.loadAnimation(this, R.anim.togo);

        mykonten.setAlpha(0);
        overbox.setAlpha(0);
        im.setVisibility(View.GONE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                im.setVisibility(View.VISIBLE);
                im.startAnimation(forloci);

                overbox.setAlpha(1);
                overbox.startAnimation(fromnothing);

                mykonten.setAlpha(1);
                mykonten.startAnimation(fromsmall);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                overbox.startAnimation(togo);
                mykonten.startAnimation(togo);
                im.startAnimation(togo);
                im.setVisibility(View.GONE);

                ViewCompat.animate(mykonten).setStartDelay(1000).alpha(0).start();
                ViewCompat.animate(overbox).setStartDelay(1000).alpha(0).start();

            }
        });
    }
}