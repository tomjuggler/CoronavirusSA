package za.co.tombigtop.playingwithmenuandactivities;


import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class ColourWheel extends PApplet {

    /**
     * Subtractive Color Wheel
     * by Ira Greenberg.
     *
     * The primaries are red, yellow, and blue. The secondaries are green,
     * purple, and orange. The tertiaries are  yellow-orange, red-orange,
     * red-purple, blue-purple, blue-green, and yellow-green.
     *
     * Create a shade or tint of the subtractive color wheel using
     * SHADE or TINT parameters.
     *
     * Updated 26 February 2010.
     */

    int segs = 12;
    int steps = 6;
    float rotAdjust = TWO_PI / segs / 2;
    float radius;
    float segWidth;
    float interval = TWO_PI / segs;


    public void setup() {

        background(127);

        ellipseMode(RADIUS);
        noStroke();
        // make the diameter 90% of the sketch area
        radius = min(width, height) * 0.45f;
        segWidth = radius / steps;

        // swap which line is commented out to draw the other version
        //drawTintWheel();
        drawShadeWheel();
    }


    public void drawShadeWheel() {
        for (int j = 0; j < steps; j++) {
            int[] cols = {
                    color(255-(255/steps)*j, 255-(255/steps)*j, 0),
                    color(255-(255/steps)*j, (255/1.5f)-((255/1.5f)/steps)*j, 0),
                    color(255-(255/steps)*j, (255/2)-((255/2)/steps)*j, 0),
                    color(255-(255/steps)*j, (255/2.5f)-((255/2.5f)/steps)*j, 0),
                    color(255-(255/steps)*j, 0, 0),
                    color(255-(255/steps)*j, 0, (255/2)-((255/2)/steps)*j),
                    color(255-(255/steps)*j, 0, 255-(255/steps)*j),
                    color((255/2)-((255/2)/steps)*j, 0, 255-(255/steps)*j),
                    color(0, 0, 255-(255/steps)*j),
                    color(0, 255-(255/steps)*j, (255/2.5f)-((255/2.5f)/steps)*j),
                    color(0, 255-(255/steps)*j, 0),
                    color((255/2)-((255/2)/steps)*j, 255-(255/steps)*j, 0)
            };
            for (int i = 0; i < segs; i++) {
                fill(cols[i]);
                arc(width/2, height/2, radius, radius,
                        interval*i+rotAdjust, interval*(i+1)+rotAdjust);
            }
            radius -= segWidth;
        }
    }


    public void drawTintWheel() {
        for (int j = 0; j < steps; j++) {
            int[] cols = {
                    color((255/steps)*j, (255/steps)*j, 0),
                    color((255/steps)*j, ((255/1.5f)/steps)*j, 0),
                    color((255/steps)*j, ((255/2)/steps)*j, 0),
                    color((255/steps)*j, ((255/2.5f)/steps)*j, 0),
                    color((255/steps)*j, 0, 0),
                    color((255/steps)*j, 0, ((255/2)/steps)*j),
                    color((255/steps)*j, 0, (255/steps)*j),
                    color(((255/2)/steps)*j, 0, (255/steps)*j),
                    color(0, 0, (255/steps)*j),
                    color(0, (255/steps)*j, ((255/2.5f)/steps)*j),
                    color(0, (255/steps)*j, 0),
                    color(((255/2)/steps)*j, (255/steps)*j, 0)
            };
            for (int i = 0; i < segs; i++) {
                fill(cols[i]);
                arc(width/2, height/2, radius, radius,
                        interval*i+rotAdjust, interval*(i+1)+rotAdjust);
            }
            radius -= segWidth;
        }
    }
    public void settings() {  size(200, 200);  smooth(); }
}
