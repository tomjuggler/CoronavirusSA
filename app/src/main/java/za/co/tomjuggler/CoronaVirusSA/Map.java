package za.co.tomjuggler.CoronaVirusSA;


import processing.core.*;
import processing.data.*;


public class Map extends PApplet {
    Table table;
    String[] provinceNames = {"WC", "KZN", "GP", "MP", "LP", "NW", "FS", "EC", "NC"};
    int[] provinces = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    int[] lat = {110, 370, 305, 360, 325, 235, 250, 250, 130};
    int[] lon = {355, 210, 140, 125, 65, 145, 225, 315, 240};

    PImage map1;
    int total = 0;
    public void setup() {
        size(sketchWidth(), sketchHeight());
        frameRate(60);

//  colorMode(HSB, 255);
        textSize(25);
        map1 = loadImage("map.gif");
        background(0);
//        image(map1, 0, 0);
        image(map1, 0, 0, width, height);
        //background(map1);
        //offline for testing:
//  table = loadTable("data.csv", "header, csv");
        //online:
        table = loadTable("https://raw.githubusercontent.com/dsfsi/covid19za/master/data/covid19za_timeline_confirmed.csv", "header, csv");

        for (TableRow row : table.rows()) {
            total++;
            String num = row.getString("case_id");
            String province = row.getString("province");

            for (int i = 0; i < provinces.length; i++) {
                if (province.equals(provinceNames[i])) {
                    provinces[i]++;
                }
            }
            //test print all data:
            println(num);
            println("province: " + province);
            println("");
        }

//  println(table.getRowCount() + " total rows in table");
        for (int i = 0; i < provinces.length; i++) {
            fill(0);
//  text("total " + provinceNames[i] + ": " + provinces[i], 20, 30*i+30);
            float latAdj = map(lat[i], 0, 450, 0, width);
            float lonAdj = map(lon[i], 0, 383, 0, height);
            text(provinces[i], latAdj, lonAdj);
//            text(provinces[i], lat[i], lon[i]);
            println("total " + provinceNames[i] + ": " + provinces[i]);
//fill(random(100));
//ellipse(150*i, 100, 2*provinces[i], 2*provinces[i]);


        }
        float latAdj = map(340, 0, 450, 0, width);
        float lonAdj = map(350, 0, 383, 0, height);
        text("TOTAL: " + total, latAdj, lonAdj);
    }
        public void draw () {

        }

    }
