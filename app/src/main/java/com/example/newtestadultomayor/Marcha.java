package com.example.newtestadultomayor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.newtestadultomayor.utils.Graph;
import com.example.newtestadultomayor.utils.GraphUtil;

public class Marcha extends AppCompatActivity {
    Button atras;
    Button terminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcha);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        atras = findViewById(R.id.atras);
        terminar = findViewById(R.id.terminar);

        atras.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), Inicio.class);
            startActivityForResult(intent, 0);
            finish();
        });
        terminar.setOnClickListener(v -> {
            RadioGroup radioGroup = findViewById(R.id.radioGroup);
            RadioGroup radioGroup1 = findViewById(R.id.radioGroup1);
            RadioGroup radioGroup2 = findViewById(R.id.radioGroup2);
            RadioGroup radioGroup3 = findViewById(R.id.radioGroup3);
            RadioGroup radioGroup4 = findViewById(R.id.radioGroup4);
            int idSelectedGroup1 = radioGroup.getCheckedRadioButtonId();
            int idSelectedGroup2 = radioGroup1.getCheckedRadioButtonId();
            int idSelectedGroup3 = radioGroup2.getCheckedRadioButtonId();
            int idSelectedGroup4 = radioGroup3.getCheckedRadioButtonId();
            int idSelectedGroup5 = radioGroup4.getCheckedRadioButtonId();
            if (idSelectedGroup1 == -1 || idSelectedGroup2 == -1 || idSelectedGroup3 == -1 || idSelectedGroup4 == -1 || idSelectedGroup5 == -1) {
                Toast.makeText(getApplicationContext(), "Existen elementos que no han sido llenados correctamente, verifique por favor.", Toast.LENGTH_SHORT).show();
                return;
            }
            int[] values = new int[5];
            float[] results = new float[3];
            values[0] = radioGroup.indexOfChild(findViewById(idSelectedGroup1));
            values[1] = radioGroup1.indexOfChild(findViewById(idSelectedGroup2));
            values[2] = radioGroup2.indexOfChild(findViewById(idSelectedGroup3));
            values[3] = radioGroup3.indexOfChild(findViewById(idSelectedGroup4));
            values[4] = radioGroup4.indexOfChild(findViewById(idSelectedGroup5));

            float points = 0;
            for (int i = 0; i < values.length; i++) {
                if (i == 0) {
                    if (values[i] == 1) results[2]++;
                    else results[0]++;
                    continue;

                }
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
                results[i] = results[i] * 100 / 5;
            }
            points = results[1]+results[2];
            GraphUtil.setAceptPercent(points);
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