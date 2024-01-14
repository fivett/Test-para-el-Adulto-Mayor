package com.example.newtestadultomayor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.newtestadultomayor.utils.GraphUtil;
import com.github.mikephil.charting.charts.BarChart;

public class GraphData extends AppCompatActivity {

    private BarChart barChart;
    private TextView textView20;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_data);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        barChart = findViewById(R.id.graph);
        textView20 = findViewById(R.id.textView20);
        GraphUtil.getGraphbar().execute(barChart);
        Button buttonBack = findViewById(R.id.terminar);
        String percent = Float.toString(GraphUtil.getAceptPercent());
        percent = percent.substring(0, percent.indexOf(".") + 2);
        textView20.setText(percent + " %");
        buttonBack.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), Inicio.class);
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