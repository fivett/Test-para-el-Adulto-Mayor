package com.example.newtestadultomayor;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.newtestadultomayor.utils.UserData;


public class Principal extends AppCompatActivity {
    ImageButton info;

    Button empezar;

    EditText edad;
    RadioButton f;
    RadioButton m;

    Button aceptar, salir;
    LinearLayout mykonten, overbox;
    ImageView im;
    Animation fromsmall, fromnothing, forloci, togo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        info = (ImageButton) findViewById(R.id.info);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Information.class);
                startActivityForResult(intent, 0);
            }
        });

        empezar = (Button) findViewById(R.id.button_empezar);
        aceptar = (Button) findViewById(R.id.aceptar);

        edad = (EditText) findViewById(R.id.editedad);
        f = (RadioButton) findViewById(R.id.radiof);
        m = (RadioButton) findViewById(R.id.radiom);


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


        empezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                im.setVisibility(View.VISIBLE);
                im.startAnimation(forloci);

                overbox.setAlpha(1);
                overbox.startAnimation(fromnothing);

                mykonten.setAlpha(1);
                mykonten.startAnimation(forloci);
            }
        });

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                overbox.startAnimation(togo);
//                mykonten.startAnimation(togo);
//                im.startAnimation(togo);
//                im.setVisibility(View.GONE);
//
//                ViewCompat.animate(mykonten).setStartDelay(1000).alpha(0).start();
//                ViewCompat.animate(overbox).setStartDelay(1000).alpha(0).start();

                if (edad.getText().toString().equals("") && (!f.isChecked() && !m.isChecked())) {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Debe llenar todos los campos", Toast.LENGTH_SHORT);
                    toast1.show();
                    return;
                }

                if (edad.getText().toString().equals("")) {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Debe insertar su edad", Toast.LENGTH_SHORT);
                    toast1.show();
                    return;
                }
                if (edad.getText().length() > 3) {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "La edad insertada no existe", Toast.LENGTH_SHORT);
                    toast1.show();
                    return;
                }
                if (!f.isChecked() && !m.isChecked()) {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Debe seleccionar sus sexo", Toast.LENGTH_SHORT);
                    toast1.show();
                    return;
                }
                if(Integer.parseInt(edad.getText().toString())<60){
                    Toast toast1 = Toast.makeText(getApplicationContext(), "La edad debe ser mayor de 59 años.", Toast.LENGTH_SHORT);
                    toast1.show();
                    return;
                }
                UserData.setAge(Integer.parseInt(edad.getText().toString()));
                UserData.setSex(m.isChecked());
                Intent intent = new Intent(v.getContext(), Inicio.class);
                startActivityForResult(intent, 0);
                finish();


            }
        });

        salir = findViewById(R.id.button_salir);
        salir.setOnClickListener(v->{
            onBackPressed();
        });
    }

    @Override
    public void onBackPressed() {  //cuando presionas boton fisico atras

        AlertDialog.Builder adb = new AlertDialog.Builder(Principal.this);
        adb.setTitle("Salir");
        adb.setMessage("¿Seguro que quiere salir?");
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
}