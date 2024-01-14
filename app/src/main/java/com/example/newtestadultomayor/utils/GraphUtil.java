package com.example.newtestadultomayor.utils;

import com.example.newtestadultomayor.utils.Graph;

public class GraphUtil {

    static Graph graphbar;
    static float aceptPercent;

    public static Graph getGraphbar() {
        return graphbar;
    }

    public static void setGraphbar(Graph graphbar) {
        GraphUtil.graphbar = graphbar;
    }

    public static float getAceptPercent() {
        return aceptPercent;
    }

    public static void setAceptPercent(float aceptPercent) {
        GraphUtil.aceptPercent = aceptPercent;
    }
}
