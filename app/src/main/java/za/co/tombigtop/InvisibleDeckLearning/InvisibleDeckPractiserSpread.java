package za.co.tombigtop.InvisibleDeckLearning;


import processing.core.*;
import processing.data.*;

//import android.content.res.Resources;
//import android.view.MotionEvent;
//import ketai.ui.*;

import java.util.ArrayList;

public class InvisibleDeckPractiserSpread extends PApplet {


//    KetaiGesture gesture;


//note: now attempting to create mixed card array with new mixedCard, mixedColour and mixedSuit lists


    ArrayList<SingleCard> cards = new ArrayList<SingleCard>();
    ArrayList<SingleCard> cards2 = new ArrayList<SingleCard>();
    ArrayList<SingleCard> mixedCards = new ArrayList<SingleCard>();
    ArrayList<SingleCard> mixedCardsOdd = new ArrayList<SingleCard>();
    IntList colour;


    StringList card;
    StringList suit;
    //mixedCard:
    StringList mixedCard;
    IntList mixedColour;
    StringList mixedSuit;

    StringList mixedCardOdd;
    IntList mixedColourOdd;
    StringList mixedSuitOdd;
    boolean even = true;
//    String nam;
//    int col;
//    String suite;
//    int a;
//    int q;
//    int r;
//    int s;
//    boolean runOnce = false;
//    int cardNum = 0;
//    boolean ready = false;

    int showNumber = 1;

    public void setup() {
        size(sketchWidth(), sketchHeight());
        println("size is: " + sketchWidth() + " " + sketchHeight());
        frameRate(60);

        background(80, 130, 80);
        stroke(50);


        card = new StringList();
        card.append("A");
        card.append("2");
        card.append("3");
        card.append("4");                          //card face
        card.append("5");
        card.append("6");
        card.append("7");
        card.append("8");
        card.append("9");
        card.append("10");
        card.append("J");
        card.append("Q");
        card.append("K");
        //println(nam);


        colour = new IntList();
        colour.append(0);                        //red and black color
        colour.append(255);
        //println(colour);


        suit = new StringList();
        suit.append("♥");        //heart♥       //0
        suit.append("♦");        //diamond♦     //1  //with 3     // suit list
        suit.append("♠");        //spade♠       //2  //with 0
        suit.append("♣");        //club♣        //3


/////////////////////////////////////////mixedCards/////////////////////////////////////////
        mixedCard = new StringList(); //confusing, rename this... denomination?
        mixedCard.append("Q");
        mixedCard.append("8");
        mixedCard.append("8");
        mixedCard.append("10");
        mixedCard.append("8");
        mixedCard.append("Q");
        mixedCard.append("8");
        mixedCard.append("10");
        mixedCard.append("10");
        mixedCard.append("K");
        mixedCard.append("2");
        mixedCard.append("K");
        mixedCard.append("4");
        mixedCard.append("2");
        mixedCard.append("6");
        mixedCard.append("4");
        mixedCard.append("6");
        mixedCard.append("2");
        mixedCard.append("4");
        mixedCard.append("6");
        mixedCard.append("4");
        mixedCard.append("6");
        mixedCard.append("10");
        mixedCard.append("Q");
        mixedCard.append("Q");
        mixedCard.append("2");

        mixedColour = new IntList();
        mixedColour.append(0);
        mixedColour.append(255);
        mixedColour.append(0);
        mixedColour.append(0);
        mixedColour.append(255);
        mixedColour.append(255);
        mixedColour.append(0);
        mixedColour.append(255);
        mixedColour.append(255);
        mixedColour.append(255);
        mixedColour.append(0);
        mixedColour.append(255);
        mixedColour.append(255);
        mixedColour.append(0);
        mixedColour.append(255);
        mixedColour.append(255);
        mixedColour.append(0);
        mixedColour.append(255);
        mixedColour.append(0);
        mixedColour.append(0);
        mixedColour.append(0);
        mixedColour.append(255);
        mixedColour.append(0);
        mixedColour.append(0);
        mixedColour.append(255);
        mixedColour.append(255);

        mixedSuit = new StringList();
        mixedSuit.append("♠");        //spade♠       //2
        mixedSuit.append("♦");        //diamond♦     //1
        mixedSuit.append("♠");        //spade♠       //2
        mixedSuit.append("♠");        //spade♠       //2
        mixedSuit.append("♥");        //heart♥       //0
        mixedSuit.append("♦");        //diamond♦     //1
        mixedSuit.append("♣");        //club♣        //3
        mixedSuit.append("♦");        //diamond♦     //1
        mixedSuit.append("♥");        //heart♥       //0
        mixedSuit.append("♦");        //diamond♦     //1
        mixedSuit.append("♠");        //spade♠       //2
        mixedSuit.append("♥");        //heart♥       //0
        mixedSuit.append("♦");        //diamond♦     //1
        mixedSuit.append("♣");        //club♣        //3
        mixedSuit.append("♦");        //diamond♦     //1
        mixedSuit.append("♥");        //heart♥       //0
        mixedSuit.append("♠");        //spade♠       //2
        mixedSuit.append("♥");        //heart♥       //0
        mixedSuit.append("♠");        //spade♠       //2
        mixedSuit.append("♣");        //club♣        //3
        mixedSuit.append("♣");        //club♣        //3
        mixedSuit.append("♥");        //heart♥       //0
        mixedSuit.append("♣");        //club♣        //3
        mixedSuit.append("♣");        //club♣        //3
        mixedSuit.append("♥");        //heart♥       //0
        mixedSuit.append("♦");        //diamond♦     //1

        mixedCardOdd = new StringList(); //confusing, rename this... denomination?
        mixedCardOdd.append("Q");
        mixedCardOdd.append("Q");
        mixedCardOdd.append("Q");
        mixedCardOdd.append("Q");
        mixedCardOdd.append("Q");
        mixedCardOdd.append("Q");
        mixedCardOdd.append("Q");
        mixedCardOdd.append("J");
        mixedCardOdd.append("J");
        mixedCardOdd.append("J");
        mixedCardOdd.append("J");
        mixedCardOdd.append("J");
        mixedCardOdd.append("J");
        mixedCardOdd.append("J");
        mixedCardOdd.append("J");
        mixedCardOdd.append("J");
        mixedCardOdd.append("J");
        mixedCardOdd.append("J");
        mixedCardOdd.append("J");
        mixedCardOdd.append("J");
        mixedCardOdd.append("J");
        mixedCardOdd.append("J");
        mixedCardOdd.append("J");
        mixedCardOdd.append("J");
        mixedCardOdd.append("J");
        mixedCardOdd.append("Q");

        mixedColourOdd = new IntList();
        mixedColourOdd.append(255);
        mixedColourOdd.append(255);
        mixedColourOdd.append(255);
        mixedColourOdd.append(255);
        mixedColourOdd.append(255);
        mixedColourOdd.append(255);
        mixedColourOdd.append(255);
        mixedColourOdd.append(255);
        mixedColourOdd.append(255);
        mixedColourOdd.append(255);
        mixedColourOdd.append(255);
        mixedColourOdd.append(255);
        mixedColourOdd.append(255);
        mixedColourOdd.append(255);
        mixedColourOdd.append(255);
        mixedColourOdd.append(255);
        mixedColourOdd.append(255);
        mixedColourOdd.append(255);
        mixedColourOdd.append(255);
        mixedColourOdd.append(255);
        mixedColourOdd.append(255);
        mixedColourOdd.append(255);
        mixedColourOdd.append(255);
        mixedColourOdd.append(255);
        mixedColourOdd.append(255);
        mixedColourOdd.append(255);

        mixedSuitOdd = new StringList();
        mixedSuitOdd.append("♦");        //diamond♦     //1
        mixedSuitOdd.append("♥");        //heart♥       //0
        mixedSuitOdd.append("♦");        //diamond♦     //1
        mixedSuitOdd.append("♥");        //heart♥       //0
        mixedSuitOdd.append("♦");        //diamond♦     //1
        mixedSuitOdd.append("♥");        //heart♥       //0
        mixedSuitOdd.append("♦");        //diamond♦     //1
        mixedSuitOdd.append("♥");        //heart♥       //0
        mixedSuitOdd.append("♦");        //diamond♦     //1
        mixedSuitOdd.append("♥");        //heart♥       //0
        mixedSuitOdd.append("♦");        //diamond♦     //1
        mixedSuitOdd.append("♥");        //heart♥       //0
        mixedSuitOdd.append("♦");        //diamond♦     //1
        mixedSuitOdd.append("♥");        //heart♥       //0
        mixedSuitOdd.append("♦");        //diamond♦     //1
        mixedSuitOdd.append("♥");        //heart♥       //0
        mixedSuitOdd.append("♦");        //diamond♦     //1
        mixedSuitOdd.append("♥");        //heart♥       //0
        mixedSuitOdd.append("♦");        //diamond♦     //1
        mixedSuitOdd.append("♥");        //heart♥       //0
        mixedSuitOdd.append("♦");        //diamond♦     //1
        mixedSuitOdd.append("♥");        //heart♥       //0
        mixedSuitOdd.append("♦");        //diamond♦     //1
        mixedSuitOdd.append("♥");        //heart♥       //0
        mixedSuitOdd.append("♦");        //diamond♦     //1
        mixedSuitOdd.append("♥");        //heart♥       //0
        //////////////////////////////////////////////////////////////////////////////////////////
//        a = 100;


        //  for (int i = 0; i < 5; i+= 1)
        //  {

// getAudienceSelection();
//cards.add(new SingleCard(card.get(3), suit.get(1), 100, 100, PI/3.3, color(col, 0, 0), 3, 1));
//        for (int i = 0; i < 13; i++) {
//            cards.add(new SingleCard(card.get(i), suit.get(3), 0, height / 4 * 3, -PI / 44, color(col, 0, 0), i, 3));
//        }
//
//        for (int i = 0; i < 13; i++) {
//            for (int j = 0; j < 4; j++) {
//                if (j < 2) { //work out colour
//                    col = 255;
//                } else {
//                    col = 0;
//                }
//                cards2.add(new SingleCard(card.get(i), suit.get(j), i * 2, height / 4 * 2, -PI / 150, color(col, 0, 0), i, j));
//            }
//        }

/////////////////////////////////////mixedCards/////////////////////////////////////////////////////////////////////
        int numberOfMixedCards = mixedCard.size(); //or mixedColour, mixedSuit. They are all the same size arrays
        for (int i = 0; i < numberOfMixedCards; i++) {

            mixedCards.add(new SingleCard(mixedCard.get(i), mixedSuit.get(i), 0, height / 4 * 2, -PI / 38, mixedColour.get(i), i, i));
        }

        int numberOfMixedCardsOdd = mixedCardOdd.size(); //or mixedColour, mixedSuit. They are all the same size arrays
        for (int i = 0; i < numberOfMixedCardsOdd; i++) {

            mixedCardsOdd.add(new SingleCard(mixedCardOdd.get(i), mixedSuitOdd.get(i), 0, height / 4 * 2, -PI / 38, mixedColourOdd.get(i), i, i));
        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }

    public void draw() {
        //over() doesn't work with all the rotate() going on - need a better initial setting of card position and rotation.
//  for (int i = 0; i < cards2.size(); i+=1) {
//    if(cards2.get(i).over()){
//      println("over 2 " + i);
//    }
//    if(cards.get(i).over()){
//      println("over " + i);
//    }
//  }
//  translate(300, 100);
        //background(80, 130, 80);

// if(cards.size()>1){
//  for (int i = 0; i < cards2.size(); i+=1) {
//      cards2.get(i).display();
//   }

        rotate(PI / 44 * 15); //get straight again - need to fix this for things to work right
        translate(sketchWidth()/4, -(sketchHeight()/2));
        if (even) {
            for (int i = 0; i < mixedCards.size(); i += 1) {
                mixedCards.get(i).display();
//     cards.get(i).xpos++;
//      SingleCard temp = cards.get(i);
//      rotate(radians(-4));
//      temp.display();
//      println(i);
//      noLoop();
            }
        } else {
            for (int i = 0; i < mixedCardsOdd.size(); i += 1) {
                mixedCardsOdd.get(i).display();
            }
        }
//        rotate( PI / 44 * 15);


//        showNumber++;
//
//        if (showNumber > cards.size()) {
//            //noLoop();
//            showNumber = 1;
//        }
// }
// else{
//    for (int i = cards.size()-1; i < cards.size (); i+=1) {
//      SingleCard temp = cards.get(i);
//      temp.display();
//   }
// }

//        if (mousePressed) {
//            for (int i = 0; i < cards2.size(); i += 1) {
//                if (cards2.get(i).over()) {
//                    println(cards2.get(1).getY());
//                } else {
//                    println("no");
//                }
//            }
//        }
    }

    public void mousePressed() {
        if (even) {
            background(80, 130, 80);
            even = !even;
        } else {
            background(130, 80, 80);
            even = !even;
        }
    }
//    public boolean surfaceTouchEvent(MotionEvent event) {
//
//        //call to keep mouseX, mouseY, etc updated
//        super.surfaceTouchEvent(event);
//
//        //forward event to class for processing
//        return gesture.surfaceTouchEvent(event);
//    }

    class SingleCard {
        float xpos, ypos, rotation;
        String nam;
        int col;
        String suite;
        int namNum;
        int suiteNum;

        //need width, height, textsize here as well
        SingleCard(String name, String suit, float x, float y, float r, int c, int namNum_, int suiteNum_) {
            nam = name;
            xpos = x;
            ypos = y;
            rotation = r;
            col = c;
            suite = suit;
            namNum = namNum_;
            suiteNum = suiteNum_;
        }

        public float getX() {
            return xpos;
        }

        public float getY() {
            return ypos;
        }

        public String getName() {
            return nam;
        }

        public String getSuite() {
            return suite;
        }

        public int getNamNum() {
            return namNum;
        }

        public int getSuiteNum() {
            return suiteNum;
        }

        public void display() {

            rotate(rotation);
            //todo: text, rect size relative to screen size
//            text("words here", 20, 20);
            fill(255);
            rect(xpos, ypos, 100, 150, 5);
            textSize(20);

            fill(col, 0, 0);
//    text((nam)+(suite), xpos+12, ypos+38);
            text((nam) + (suite), xpos, ypos + 20); //fan cards better with suite displayed closer to side

        }

        public void updatePosition() {
            xpos = width + 300;
        }

        public boolean over() {
            int w = 100;
            int h = 150;
            return (mouseX > xpos && mouseX < xpos + w && mouseY > ypos && mouseY < ypos + h);
        } // func
    }


}
//  public int sketchWidth() { return 480; }
//  public int sketchHeight() { return 640; }

//    //@Override
//    void settings() {
////  size(getScreenWidth(), getScreenHeight());
//        size(sketchWidth(), sketchHeight());
//    }
//
//    public int sketchWidth() { return displayWidth; }
//    public int sketchHeight() { return displayHeight; }
//
//    //very useful functions here:
//    public static int getScreenWidth() {
//        return Resources.getSystem().getDisplayMetrics().widthPixels;
//    }
//
//    public static int getScreenHeight() {
//        return Resources.getSystem().getDisplayMetrics().heightPixels;
//    }
//
//}
//
