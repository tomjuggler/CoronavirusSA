package za.co.tomjuggler.CoronaVirusSA;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import processing.core.*;
import processing.data.*;


public class Map extends PApplet {
//    JSONArray values; //for thevirustracker api
//    JSONObject corona; //for thevirustracker api
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
/////////////////////thevirustracker api total - not using/////////////////////////////////////////
//        GetRequest get3 = new GetRequest("http://thevirustracker.com/free-api?countryTotal=ZA");
//        get3.send(); // program will wait until the request is completed
//        corona = parseJSONObject(get3.getContent());
//        values = corona.getJSONArray("countrydata");
//        JSONObject valueObj = values.getJSONObject(0);
//        int newTotal = valueObj.getInt("total_cases");
//////////////////////////////////////////////////////////////////////////////////////////////////
//  colorMode(HSB, 255);
        textSize(28);
        fill(255);
        map1 = loadImage("map.gif");
        background(0);
        image(map1, 0, 0, width, height);

//      offline for testing:
//      table = loadTable("data.csv", "header, csv");

//        new dsfsi data source
        table = loadTable("https://raw.githubusercontent.com/dsfsi/covid19za/master/data/covid19za_provincial_cumulative_timeline_confirmed.csv", "header, csv");
        for (TableRow row : table.rows()) {
            total++;
        }
        println(total);

        TableRow row = table.getRow(total-1);
//      println(row);

        for(int i = 0; i < provinces.length; i++){
            int provinceData = row.getInt(provinceNames[i]); //number of cases in eg EC loaded
            provinces[i] = provinceData;
            println(provinces[i]);
        }


        for (int i = 0; i < provinces.length; i++) {
            fill(255);
            float latAdj = map(lat[i], 0, 450, 0, width);
            float lonAdj = map(lon[i], 0, 383, 0, height);
            text(provinces[i], latAdj, lonAdj);
            println("total " + provinceNames[i] + ": " + provinces[i]);

        }

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
                        //close old activity?
                        getActivity().finish();

                        //open province curve now!
                        Intent intent = new Intent(getActivity().getApplicationContext(), curveStarter.class);
                        startActivity(intent);
                    }
                }
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
