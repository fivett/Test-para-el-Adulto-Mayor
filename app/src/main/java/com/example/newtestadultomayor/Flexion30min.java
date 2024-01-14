package com.example.newtestadultomayor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newtestadultomayor.utils.MinMax;
import com.example.newtestadultomayor.utils.UserData;

public class Flexion30min extends AppCompatActivity {
    Button atras;
    Button terminar;

    EditText editText;
    TextView textViewValue;

    private MinMax[] minMaxArray = new MinMax[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flexion30min);

        atras = (Button) findViewById(R.id.atras);
        terminar = (Button) findViewById(R.id.terminar);

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Inicio.class);
                startActivityForResult(intent, 0);
                finish();
            }
        });

        terminar.setOnClickListener(v -> {
            textViewValue = findViewById(R.id.textViewResultValue);
            if (textViewValue.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "ERROR, Debe introducir un valor para la actividad", Toast.LENGTH_SHORT).show();
                return;
            }
            int age = UserData.getAge();
            boolean male = UserData.isSex();
            boolean result = false;
            llenarDatos();
            editText = findViewById(R.id.edtdemo);
            String txt = editText.getText().toString();
            String pattern = "^(-?[1-9]+\\d*([.]\\d+)?)$|^(-?0[.]\\d*[1-9]+)$|^0$|^0.0$";
            if (!txt.matches(pattern)) {
                Toast.makeText(getApplicationContext(), "Existen errores en la entrada de datos. Solo deben introducirse números válidos.", Toast.LENGTH_SHORT).show();
                return;
            }
            float input = Float.parseFloat(editText.getText().toString());
            for (MinMax minMax : minMaxArray) {
                if (age >= minMax.minage && age <= minMax.maxage) {
                    if (male && input >= minMax.minresultm) {
                        result = true;
                        break;
                    } else if (!male && input >= minMax.minresultf) {
                        result = true;
                        break;
                    } else result = false;
                }
            }
            if (result) {
                textViewValue.setText("Bien");
                textViewValue.setTextColor(Color.GREEN);
            } else {
                textViewValue.setText("Mal");
                textViewValue.setTextColor(Color.RED);
            }
        });
    }

    private void llenarDatos() {
        minMaxArray[0] = new MinMax(60, 64, 16, 22, 13, 19);
        minMaxArray[1] = new MinMax(65, 69, 15, 21, 12, 18);
        minMaxArray[2] = new MinMax(70, 74, 14, 21, 12, 17);
        minMaxArray[3] = new MinMax(75, 79, 13, 19, 12, 17);
        minMaxArray[4] = new MinMax(80, 84, 13, 19, 10, 16);
        minMaxArray[5] = new MinMax(85, 89, 11, 17, 10, 15);
        minMaxArray[6] = new MinMax(90, 999, 10, 14, 8, 13);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}