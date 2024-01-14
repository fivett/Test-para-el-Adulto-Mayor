package com.example.newtestadultomayor;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Inicio extends AppCompatActivity {
    Button bm;
    Button ba;
    Button br;
    Button bn;
    Button bv;
    Button bao;
    Button bg;
    Button brs;

    ImageButton salir;
    ImageButton info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        bm = (Button) findViewById(R.id.bm);
        ba = (Button) findViewById(R.id.ba);
        br = (Button) findViewById(R.id.br);
        bn = (Button) findViewById(R.id.bn);
        bv = (Button) findViewById(R.id.bv);
        bao = (Button) findViewById(R.id.bao);
        bg = (Button) findViewById(R.id.bg);
        brs = (Button) findViewById(R.id.brs);

        salir = (ImageButton) findViewById(R.id.exit);
        info = (ImageButton) findViewById(R.id.info);

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder adb = new AlertDialog.Builder(Inicio.this);
                adb.setTitle("Salir");
                adb.setMessage("¿Seguro que decea salir?");
                adb.setCancelable(false);
                String yesButtonText = "Si";
                String noButtonText = "No";
                adb.setPositiveButton(yesButtonText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // text.setVisibility(View.INVISIBLE);
                        System.exit(0);
                    }
                });
                adb.setNegativeButton(noButtonText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                adb.show();
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Information.class);
                startActivityForResult(intent, 0);
            }
        });

        bm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), EscalaTineti.class);
                startActivityForResult(intent, 0);
            }
        });

        ba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Marcha.class);
                startActivityForResult(intent, 0);
            }
        });

        br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SentarsePararse.class);
                startActivityForResult(intent, 0);
            }
        });

        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Flexion30min.class);
                startActivityForResult(intent, 0);
            }
        });

        bv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Flexibilidad.class);
                startActivityForResult(intent, 0);
            }
        });

        bao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RascarseEspalda.class);
                startActivityForResult(intent, 0);
            }
        });

        bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PasosDelante.class);
                startActivityForResult(intent, 0);
            }
        });

        brs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MarchaLugar.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    public void onBackPressed() {  //cuando presionas boton fisico atras
        finish();
        Intent intent = new Intent(getApplicationContext(), Principal.class);
        startActivityForResult(intent, 0);

    }

}