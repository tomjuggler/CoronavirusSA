package za.co.tomjuggler.CoronaVirusSA;




import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import processing.core.*;
import processing.data.*;

//import http.requests.*; //this thing doesn't work well with Android
//try remember how to use volley, I used that before for http get requests in another app

public class Map extends PApplet {
    JSONArray values;
    JSONObject corona;
    Table table;
    String[] provinceNames = {"WC", "KZN", "GP", "MP", "LP", "NW", "FS", "EC", "NC", "UNKNOWN", "total"};
    int[] provinces = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int[] lat = {110, 370, 305, 360, 325, 235, 250, 250, 130, 290, 340};
    int[] lon = {355, 210, 135, 125, 65, 145, 225, 315, 240, 370, 350};

    PImage map1;
    int total = 0;
    SharedPreferences preferences;
    int province;
    public void setup() {
        size(sketchWidth(), sketchHeight());
        frameRate(60);
//load saved province
        preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        province = preferences.getInt("Province", 0);
/////////////////////new total://////////////////////////////
//        GetRequest get3 = new GetRequest("http://thevirustracker.com/free-api?countryTotal=ZA");
//        get3.send(); // program will wait until the request is completed
//        corona = parseJSONObject(get3.getContent());
//        values = corona.getJSONArray("countrydata");
//        JSONObject valueObj = values.getJSONObject(0);
//        int newTotal = valueObj.getInt("total_cases");
///////////////////////////now we have total////////////////////
//  colorMode(HSB, 255);
        textSize(28);
        fill(255);
        map1 = loadImage("map.gif");
        background(0);
//        image(map1, 0, 0);
        image(map1, 0, 0, width, height);
        //background(map1);
        //offline for testing:
//  table = loadTable("data.csv", "header, csv");
        //new dsfsi data source
        table = loadTable("https://raw.githubusercontent.com/dsfsi/covid19za/master/data/covid19za_provincial_cumulative_timeline_confirmed.csv", "header, csv");
        for (TableRow row : table.rows()) {
            total++;
        }
        println(total);

        TableRow row = table.getRow(total-1);
//println(row);

//while(!ready){
        for(int i = 0; i < provinces.length; i++){
            int provinceData = row.getInt(provinceNames[i]); //number of cases in eg EC loaded
            provinces[i] = provinceData;
            println(provinces[i]);
        }
        //online:
//        table = loadTable("https://raw.githubusercontent.com/dsfsi/covid19za/master/data/covid19za_timeline_confirmed.csv", "header, csv");
//
//        for (TableRow row : table.rows()) {
//            total++;
//            String num = row.getString("case_id");
//            String province = row.getString("province");
//
//            for (int i = 0; i < provinces.length; i++) {
//                if (province.equals(provinceNames[i])) {
//                    provinces[i]++;
//                }
//            }
//            //test print all data:
//            println(num);
//            println("province: " + province);
//            println("");
//        }

//  println(table.getRowCount() + " total rows in table");
        for (int i = 0; i < provinces.length; i++) {
            fill(255);
//  text("total " + provinceNames[i] + ": " + provinces[i], 20, 30*i+30);
            float latAdj = map(lat[i], 0, 450, 0, width);
            float lonAdj = map(lon[i], 0, 383, 0, height);
            text(provinces[i], latAdj, lonAdj);
//            text(provinces[i], lat[i], lon[i]);
            println("total " + provinceNames[i] + ": " + provinces[i]);
//fill(random(100));
//ellipse(150*i, 100, 2*provinces[i], 2*provinces[i]);


        }
//        float latAdj = map(340, 0, 450, 0, width);
//        float lonAdj = map(350, 0, 383, 0, height);
//        text("TOTAL: " + total, latAdj, lonAdj);
//        text("TOTAL: " + newTotal, latAdj, lonAdj);

        //unknown
        fill(0);
        float latAdj2 = map(290, 0, 450, 0, width);
        float lonAdj2 = map(370, 0, 383, 0, height);
        text("unknown province:", latAdj2-240, lonAdj2);
    }
        public void draw () {
            preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
            if(mousePressed){
                for (int i = 0; i < provinces.length; i++) {
                    float latAdj = map(lat[i], 0, 450, 0, width);
                    float lonAdj = map(lon[i], 0, 383, 0, height);
                    if(over(latAdj-50, lonAdj-50, 150, 100)){ //over text area
                        println("over " + i);
                        province = i;
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putInt("Province",i); //next province - now reload?
                        editor.apply();
                        //open province curve now!
                        Intent intent = new Intent(getActivity().getApplicationContext(), curveStarter.class);
                        startActivity(intent);
                    }
                }
//                province++;
//                if(province > provinceNames.length -1){
//                    province = 0;
//                }
//                SharedPreferences.Editor editor = preferences.edit();
//                editor.putInt("Province",province); //next province - now reload?
//                editor.apply();
            }
            for (int i = 0; i < provinces.length; i++) {
                if (i == province) { //selected province is blue!
                    float latAdj = map(lat[i], 0, 450, 0, width);
                    float lonAdj = map(lon[i], 0, 383, 0, height);
                    fill(255, 0, 0);
                    text(provinces[i], latAdj, lonAdj);
                } else{
                    fill(0); //all other provinces black
                    float latAdj = map(lat[i], 0, 450, 0, width);
                    float lonAdj = map(lon[i], 0, 383, 0, height);
                    text(provinces[i], latAdj, lonAdj);
                }
            }
        }

    public boolean over(float x, float y, int w, int h) {
        return (mouseX > x && mouseX < x + w && mouseY > y && mouseY < y + h);
    } // func

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }
    }
