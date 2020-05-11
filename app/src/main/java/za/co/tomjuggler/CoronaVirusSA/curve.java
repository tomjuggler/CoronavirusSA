package za.co.tomjuggler.CoronaVirusSA;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import processing.core.*;
import processing.data.*;
//
import org.gicentre.utils.stat.*;

public class curve extends PApplet {
    Table table;
    String[] provinceNames = {"WC", "KZN", "GP", "MP", "LP", "NW", "FS", "EC", "NC", "UNKNOWN", "total"};
    int total = 0;

    float[] risingTotal= {0};

    PImage map1;

    BarChart barChart;

    int province = 1;
    SharedPreferences preferences;

    public void setup() {
        //load saved province
        preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        province = preferences.getInt("Province", 0);
        barChart = new BarChart(this);
        total = 0; //double check we get this right at the start
//        noLoop(); // not really necessary
        size(sketchWidth(), sketchHeight());
        textSize(20);
        background(0);

        //online:
        table = loadTable("https://raw.githubusercontent.com/dsfsi/covid19za/master/data/covid19za_provincial_cumulative_timeline_confirmed.csv", "header, csv");
        for (TableRow row : table.rows()) {
            total++;
            float nextTotal = row.getInt(provinceNames[province]);
            //println(total + ": " + nextTotal);
            if(nextTotal > 0){
                risingTotal = append(risingTotal, nextTotal);
            }
        }
        //println(risingTotal);
        barChart.setData(risingTotal);
        barChart.setBarColour(color(255, 0, 0));
        barChart.setBarGap(2);
        barChart.showValueAxis(true);
        barChart.showCategoryAxis(false);

        barChart.draw(10,10,width-20,height-20);

        int d = day();    // Values from 1 - 31
        int m = month();  // Values from 1 - 12
        int y = year();   // 2003, 2004, 2005, etc.

        fill(120);
        if(province == 10){ //South Africa total
            text("Daily Increase in Cases for " + "South Africa" +   " Up until " + d + "/" + m + "/" + y, 120, 30);
        }else {
            text("Daily Increase in Cases for " + provinceNames[province] + " Up until " + d + "/" + m + "/" + y, 120, 30);
        }
    }
        public void draw () {
//if(mousePressed){
//    province++;
//    if(province > provinceNames.length -1){
//        province = 0;
//    }
//    SharedPreferences.Editor editor = preferences.edit();
//    editor.putInt("Province",province); //next province - now reload?
//    editor.apply();
//}
       }

    }
