package com.example.newtestadultomayor;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;

public class Barra extends AppCompatActivity {

    int suma0 = 0;
    int suma1 = 1;
    int suma2 = 2;

    TextView text;

    DBHandler db;
    String a;
    String[] arg;
    int rb;
    int rm;
    int ra;
    int pa;
    int total;
    private float[] sale = new float[]{0, 0, 0};
    private int[] colors = new int[]{0xFFEC7063, 0xFFAFD418, 0xFF2ECC71};
    private String[] months = new String[]{"Mal", "Regular", "Bien"};

    private BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barra);

        text = (TextView) findViewById(R.id.total);

        barChart = (BarChart) findViewById(R.id.barChart);
        llenandoGrafico();
        createCharts();

    }

    private Chart getSameChart(Chart chart, String descrption, int textColor, int background, int animateY) {
        chart.getDescription().setText(descrption);
        chart.getDescription().setTextSize(15);
        chart.setBackgroundColor(background);
        chart.animateY(animateY);
        legend(chart);
        return chart;
    }

    private void legend(Chart chart) {
        Legend legend = chart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);

        ArrayList<LegendEntry> entries = new ArrayList<>();
        for (int i = 0; i < months.length; i++) {
            LegendEntry entry = new LegendEntry();
            entry.formColor = colors[i];
            entry.label = months[i];
            entries.add(entry);
        }
        legend.setCustom(entries);
    }

    private ArrayList<BarEntry> getBarEntries() {
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i < sale.length; i++)
            entries.add(new BarEntry(i, (float) sale[i]));
        return entries;
    }

    private void axisX(XAxis axis) {
        axis.setGranularityEnabled(true);
        axis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);
        axis.setValueFormatter(new IndexAxisValueFormatter(months));
    }

    private void axisLeft(YAxis axis) {
        axis.setSpaceTop(30);
        axis.setAxisMinimum(0);
    }

    private void axisRight(YAxis axis) {
        axis.setEnabled(false);
    }

    public void createCharts() {
        barChart = (BarChart) getSameChart(barChart, "", Color.RED, Color.WHITE, 3000);
        barChart.setDrawGridBackground(false);
        barChart.setDrawBarShadow(false);
        barChart.setData(getBarData());
        barChart.invalidate();
        axisX(barChart.getXAxis());
        axisLeft(barChart.getAxisLeft());
        axisRight(barChart.getAxisRight());
    }

    private DataSet getData(DataSet dataSet) {
        dataSet.setColors(colors);
        dataSet.setValueTextSize(Color.WHITE);
        dataSet.setValueTextSize(10);
        return dataSet;
    }

    private BarData getBarData() {
        BarDataSet barDataSet = (BarDataSet) getData(new BarDataSet(getBarEntries(), ""));
        barDataSet.setBarShadowColor(Color.GRAY);
        BarData barData = new BarData(barDataSet);
        barData.setBarWidth(0.45f);
        return barData;
    }

//    public void muestra() {
//        a = db.getRecords();
//        arg = a.split(",");
//
//        for (int i = 0; i < arg.length; i++) {
//
//            if (arg[i].equals("Riesgo Bajo")) {
//                rb++;
//            } else {
//                if (arg[i].equals("Riesgo Medio")) {
//                    rm++;
//                } else {
//                    if (arg[i].equals("Riesgo Alto")) {
//                        ra++;
//                    } else {
//                        if (arg[i].equals("Probable adicción")) {
//                            pa++;
//                        }
//                    }
//                }
//            }
//        }
//
//        total = rb + rm + ra + pa;
//        CalculatePercents(rb, rm, ra, pa, total);
//        tt.setText("Riesgo Bajo: " + rb);
//        tt1.setText("Riesgo Medio: " + rm);
//        tt2.setText("Riesgo Alto: " + ra);
//        tt3.setText("Probable adicción: " + pa);
//
//        tt4.setText("Cantidad de test realizados: " + total);
//
//    }

    private void llenandoGrafico() {

        if (suma0 != 0) {
            sale[0] = suma0 * 100 / 13;
        }

        if (suma1 != 0) {
            sale[1] = suma1 * 100 / 13;
        }

        if (suma2 != 0) {
            sale[2] = suma2 * 100 / 13;
        }

        System.out.println("antes de sum");

        double sum = (suma0 + suma1 + suma2) * 100 / 26;

        System.out.println("saliendo sum y mandando texview");

        text.setText(Double.toString(sum));

        System.out.println("despues textview");

    }

//    private void CalculatePercents(int rb, int rm, int ra, int pa, int total) {
//        if (total != 0) {
//            sale[0] = rb * 100 / total;
//            sale[1] = rm * 100 / total;
//            sale[2] = ra * 100 / total;
//            sale[3] = pa * 100 / total;
//        }else{
//            sale[0] = 0;
//            sale[1] = 0;
//            sale[2] = 0;
//            sale[3] = 0;
//        }
//    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}