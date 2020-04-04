package za.co.tomjuggler.CoronaVirusSA;

import processing.core.*;
import processing.data.*;
//import processing.core.PApplet;
//import processing.core.PImage;
//import processing.data.Table;
//import processing.data.TableRow;
import org.gicentre.utils.stat.*;

//import http.requests.*; //this thing doesn't work well with Android
//try remember how to use volley, I used that before for http get requests in another app

public class curve extends PApplet {
    Table table;
    String[] provinceNames = {"WC", "KZN", "GP", "MP", "LP", "NW", "FS", "EC", "NC", "UNKNOWN", "total"};
    int total = 0;

    float[] risingTotal= {0};

    PImage map1;

    BarChart barChart;

    public void setup() {
        barChart = new BarChart(this);

        total = 0; //double check we get this right at the start
        noLoop(); //new try this
//size(640, 480);
        size(sketchWidth(), sketchHeight());
        textSize(20);
        background(0);

        //online:
        table = loadTable("https://raw.githubusercontent.com/dsfsi/covid19za/master/data/covid19za_provincial_cumulative_timeline_confirmed.csv", "header, csv");
        for (TableRow row : table.rows()) {
            total++;
            float nextTotal = row.getInt(provinceNames[provinceNames.length-1]);
            //println(total + ": " + nextTotal);
            if(nextTotal > 0){
                risingTotal = append(risingTotal, nextTotal);
            }
        }
        //println(risingTotal);
        barChart.setData(risingTotal);
        barChart.setBarColour(color(200,80,80,100));
        barChart.setBarGap(2);
        barChart.showValueAxis(true);
        barChart.showCategoryAxis(false);

        barChart.draw(10,10,width-20,height-20);

        int d = day();    // Values from 1 - 31
        int m = month();  // Values from 1 - 12
        int y = year();   // 2003, 2004, 2005, etc.

        fill(120);
        text("Daily Increase in Cases Up until " + d + "/" + m + "/" + y, 120, 30);
    }
        public void draw () {

        }

    }
