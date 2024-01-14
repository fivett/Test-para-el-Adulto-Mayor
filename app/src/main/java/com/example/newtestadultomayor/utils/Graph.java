package com.example.newtestadultomayor.utils;

import android.content.Context;
import android.graphics.Color;

import com.example.newtestadultomayor.GraphData;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Graph {

    private float[] values = new float[]{0, 0, 0};
    private int[] colors = new int[]{0xFFEC7063, 0xFFAFD418, 0xFF2ECC71};
    private String[] legend_values = new String[]{"Mal", "Regular", "Bien"};
    private BarChart barChart;

    public Graph(float[] values, String[] legend_values) {
        if (values.length != legend_values.length) {
            throw new IllegalArgumentException("Bad Arguments");
        }
        this.values = Arrays.copyOf(values, values.length);
        this.legend_values = Arrays.copyOf(legend_values, legend_values.length);
        colors = new int[] {0xFFEC7063, 0xFFAFD418, 0xFF2ECC71};
//        Random rand = new Random();
//        for (int i = 0; i < colors.length; i++) {
//            colors[i]=rand.nextInt();
//        }
    }

    public void execute(BarChart barChart){
        this.barChart = barChart;
        createCharts();
    }

    public BarChart getBarChart() {
        return barChart;
    }

    public void setBarChart(BarChart barChart) {
        this.barChart = barChart;
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
        for (int i = 0; i < legend_values.length; i++) {
            LegendEntry entry = new LegendEntry();
            entry.formColor = colors[i];
            entry.label = legend_values[i];
            entries.add(entry);
        }
        legend.setCustom(entries);
    }

    private ArrayList<BarEntry> getBarEntries() {
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i < values.length; i++)
            entries.add(new BarEntry(i, (float) values[i]));
        return entries;
    }

    private void axisX(XAxis axis) {
        axis.setGranularityEnabled(true);
        axis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);
        axis.setValueFormatter(new IndexAxisValueFormatter(legend_values));
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
}
