package com.example.newtestadultomayor;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.newtestadultomayor.utils.Graph;
import com.example.newtestadultomayor.utils.GraphUtil;

public class EscalaTineti extends AppCompatActivity {

    Button atras;
    Button terminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escala_tineti);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        atras = findViewById(R.id.atras);
        terminar = findViewById(R.id.terminar);

        atras.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), Inicio.class);
            startActivityForResult(intent, 0);
            finish();
        });

        terminar.setOnClickListener(v->{
            RadioGroup radioGroup = findViewById(R.id.radioGroup);
            RadioGroup radioGroup1 = findViewById(R.id.radioGroup1);
            RadioGroup radioGroup2 = findViewById(R.id.radioGroup2);
            RadioGroup radioGroup3 = findViewById(R.id.radioGroup4);
            RadioGroup radioGroup4 = findViewById(R.id.radioGroup5);
            RadioGroup radioGroup5 = findViewById(R.id.radioGroup6);
            RadioGroup radioGroup6 = findViewById(R.id.radioGroup7);
            RadioGroup radioGroup7 = findViewById(R.id.radioGroup8);
            RadioGroup radioGroup8 = findViewById(R.id.radioGroup9);
            RadioGroup radioGroup9 = findViewById(R.id.radioGroup10);
            RadioGroup radioGroup10 = findViewById(R.id.radioGroup11);
            RadioGroup radioGroup11 = findViewById(R.id.radioGroup12);
            RadioGroup radioGroup12 = findViewById(R.id.radioGroup13);
            int idSelectedGroup1 = radioGroup.getCheckedRadioButtonId();
            int idSelectedGroup2 = radioGroup1.getCheckedRadioButtonId();
            int idSelectedGroup3 = radioGroup2.getCheckedRadioButtonId();
            int idSelectedGroup4 = radioGroup3.getCheckedRadioButtonId();
            int idSelectedGroup5 = radioGroup4.getCheckedRadioButtonId();
            int idSelectedGroup6 = radioGroup5.getCheckedRadioButtonId();
            int idSelectedGroup7 = radioGroup6.getCheckedRadioButtonId();
            int idSelectedGroup8 = radioGroup7.getCheckedRadioButtonId();
            int idSelectedGroup9 = radioGroup8.getCheckedRadioButtonId();
            int idSelectedGroup10 = radioGroup9.getCheckedRadioButtonId();
            int idSelectedGroup11 = radioGroup10.getCheckedRadioButtonId();
            int idSelectedGroup12 = radioGroup11.getCheckedRadioButtonId();
            int idSelectedGroup13 = radioGroup12.getCheckedRadioButtonId();
            if (idSelectedGroup1 == -1 || idSelectedGroup2 == -1 || idSelectedGroup3 == -1 || idSelectedGroup4 == -1 || idSelectedGroup5 == -1 || idSelectedGroup6 == -1
                    || idSelectedGroup7 == -1 || idSelectedGroup8 == -1 || idSelectedGroup9 == -1 || idSelectedGroup10 == -1 || idSelectedGroup11 == -1 || idSelectedGroup12 == -1
                    || idSelectedGroup13 == -1) {
                Toast.makeText(getApplicationContext(), "Existen elementos que no han sido llenados correctamente, verifique por favor.", Toast.LENGTH_SHORT).show();
                return;
            }
            int[] values = new int[13];
            float[] results = new float[3];
            values[0] = radioGroup.indexOfChild(findViewById(idSelectedGroup1));
            values[1] = radioGroup1.indexOfChild(findViewById(idSelectedGroup2));
            values[2] = radioGroup2.indexOfChild(findViewById(idSelectedGroup3));
            values[3] = radioGroup3.indexOfChild(findViewById(idSelectedGroup4));
            values[4] = radioGroup4.indexOfChild(findViewById(idSelectedGroup5));
            values[5] = radioGroup5.indexOfChild(findViewById(idSelectedGroup6));
            values[6] = radioGroup6.indexOfChild(findViewById(idSelectedGroup7));
            values[7] = radioGroup7.indexOfChild(findViewById(idSelectedGroup8));
            values[8] = radioGroup8.indexOfChild(findViewById(idSelectedGroup9));
            values[9] = radioGroup9.indexOfChild(findViewById(idSelectedGroup10));
            values[10] = radioGroup10.indexOfChild(findViewById(idSelectedGroup11));
            values[11] = radioGroup11.indexOfChild(findViewById(idSelectedGroup12));
            values[12] = radioGroup12.indexOfChild(findViewById(idSelectedGroup13));

            float points = 0;
            for (int i = 0; i < values.length; i++) {
                switch (values[i]) {
                    case 0:
                        results[0]++;
                        break;
                    case 1:
                        results[1]++;
                        break;
                    case 2:
                        results[2]++;
                        break;
                }
            }
            for (int i = 0; i < results.length; i++) {
                float ptos = results[i] * (i);
                points += ptos;
                results[i] = results[i] * 100 / 13;
            }
            GraphUtil.setAceptPercent((points * 100) / 26);
            String[] labels = {"Mal", "Regular", "Bien"};
            Graph graph = new Graph(results, labels);
            GraphUtil.setGraphbar(graph);
            Intent intent = new Intent(v.getContext(), GraphData.class);
            startActivityForResult(intent, 0);
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}