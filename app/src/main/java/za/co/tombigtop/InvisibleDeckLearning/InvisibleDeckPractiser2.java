package za.co.tombigtop.InvisibleDeckLearning;


import android.util.Log;
import android.view.MotionEvent;

import java.util.ArrayList;

import ketai.ui.KetaiGesture;
import processing.core.PApplet;
import processing.core.PImage;
import processing.data.IntList;
import processing.data.StringList;

public class InvisibleDeckPractiser2 extends PApplet {


    KetaiGesture gesture;


    ArrayList<DeckofCards> cards = new ArrayList<DeckofCards>();
    ArrayList<DeckofCards> underCard = new ArrayList<DeckofCards>(); //corresponding card
    IntList colour;
    StringList card;
    StringList suit;
    String nam;
    int col;
    String suite;
    int a;
    int q;
    int r;
    int s;
    boolean runOnce = false;
    int cardNum = 0;
    boolean ready = false;

    PImage front;
    PImage back;
    boolean deckup = true;

    boolean newReady = false; //mousePressed once only

    public void setup() {
        size(sketchWidth(), sketchHeight());
        frameRate(60);
        if (displayWidth > 500) {

        } else {
//    size(displayWidth, displayHeight);
        }
        gesture = new KetaiGesture(this);
        background(80, 0, 80);
        stroke(50);

        line(0, 266.67f, 800, 266.67f);
        line(0, 533.33f, 800, 533.33f);

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
        suit.append("\u2665");        //heart\u2665       //0
        suit.append("\u2666");        //diamond\u2666     //1  //with 3     // suit list
        suit.append("\u2660");        //spade\u2660       //2  //with 0
        suit.append("\u2663");        //club\u2663        //3
        a = 100;
//        getAudienceSelection();
        int width = 50;
        int height = 70;
        int textSize = 22;

        for(int i = 0; i < 13; i++) {

            cards.add(new DeckofCards(card.get(i), suit.get(0), i*55, 50, 0, color(255, 0, 0), i, 0, width, height, textSize));
        }

        for(int i = 0; i < 13; i++) {

            cards.add(new DeckofCards(card.get(i), suit.get(1), i*55, 150, 0, color(255, 0, 20), i, 1, width, height, textSize));
        }
        for(int i = 0; i < 13; i++) {

            cards.add(new DeckofCards(card.get(i), suit.get(2), i*55, 250, 0, color(0, 0, 40), i, 2, width, height, textSize));
        }
        for(int i = 0; i < 13; i++) {

            cards.add(new DeckofCards(card.get(i), suit.get(3), i*55, 350, 0, color(0, 0, 60), i, 3, width, height, textSize));
        }

        front = loadImage("front.png");
        back = loadImage("back.png");

        for(int i = 0; i < 52; i++) {
            DeckofCards temp = cards.get(i);
            temp.display();
        }
//        for(int i = 13; i < 26; i++) {
//            DeckofCards temp = cards.get(i);
//            temp.display();
//        }
//        for(int i = 26; i < 39; i++) {
//            DeckofCards temp = cards.get(i);
//            temp.display();
//        }
//        for(int i = 39; i < 52; i++) {
//            DeckofCards temp = cards.get(i);
//            temp.display();
//        }

    }

    public void draw() {
//        background(80, 130, 80);


//        if (underCard.size() > 1) {
//            for (int i = underCard.size() - 2; i < underCard.size(); i += 1) {
//                DeckofCards temp = underCard.get(i);
//                temp.display();
//            }
//        } else {
//            for (int i = underCard.size() - 1; i < underCard.size(); i += 1) {
//                DeckofCards temp = underCard.get(i);
//                temp.display();
//            }
//        }
    }

    /*
    public void getAudienceSelection() {
        background(80, 0, 80);
        stroke(50);
        line(0, 266.67f, 800, 266.67f);
        line(0, 533.33f, 800, 533.33f);
        //generate random audience selection:
        //1. get random number 1-13 (card A-10, J, Q or K)
        int randomNam = PApplet.parseInt(random(0, 13));
        nam = card.get(randomNam);
        //2. get random number 1-4 (Hearts, Clubs, Diamonds, Spades)
        int randomSuite = PApplet.parseInt(random(4));
        int matchedSuite = 0;
        println("randomSuite is: " + randomSuite);
        switch (randomSuite) {
            case 0: {
                suite = suit.get(randomSuite);
                matchedSuite = randomSuite;
                col = 255;
            }
            break;
            case 1: {
                suite = suit.get(randomSuite);
                matchedSuite = randomSuite;
                col = 255;
            }
            break;
            case 2: {
                suite = suit.get(randomSuite);
                matchedSuite = randomSuite;
                col = 0;
            }
            break;
            case 3: {
                suite = suit.get(randomSuite);
                matchedSuite = randomSuite;
                col = 0;
            }
            break;
        }

        println(suite);
        if (cards.size() > 0) {
            cards.remove(0);
        }
        cards.add(new DeckofCards(nam, suite, a, 50, 0, color(col, 0, 0), randomNam, matchedSuite));
        runOnce = false;
    }
*/
//    public void keyReleased() {
//        if (key == ENTER) {
//            if (ready) {
//                runOnce = true;
//                getAudienceSelection();
//                cardNum += 2;
//                ready = false;
//            } else {
//            } //no mouse pressed yet - avoid errors
//        }
//    }

//    public void keyPressed() {
//
//        //  if ( mouseY < 266.67 ) {
//        //    q = 1;
//        //  }
//        //
//        //  if ( mouseY > 266.67 ) {
//        //    if (mouseY < 533.33) {
//        //      r = 1;
//        //      println(r);
//        //    }
//        //  }
//        //
//        //  if ( mouseY > 533.33 ) {
//        //    s = 1;
//        //  }
//    }

    public void mousePressed() {

        int namNumOfCard = 0;
        int suiteNumOfCard= 0;
        for(int i = 0; i < 52; i++) {
//            DeckofCards temp = cards.get(i);
//            temp.display();
            if (cards.get(i).over()) {
                Log.d("card selected: ", cards.get(i).nam + " of " + cards.get(i).suite);
                nam = cards.get(i).nam;
                suite = cards.get(i).suite;
                col = cards.get(i).col;
                namNumOfCard = cards.get(i).namNum;
                suiteNumOfCard = cards.get(i).suiteNum;
                newReady = true;
            }
        }
        //old code:

        if (newReady) {
            String nameOfCard = nam;
            String suiteOfCard = suite;
//            int namNumOfCard = cards.get(0).getNamNum();
//            int suiteNumOfCard = cards.get(0).getSuiteNum();
            println(nameOfCard + " " + suiteOfCard + " " + namNumOfCard + " " + suiteNumOfCard);


            int newNam = 11 - namNumOfCard;
            println("newNam = " + newNam);
            println("suiteNumOfCard is: " + suiteNumOfCard);
            int newSuite;
            if (suiteNumOfCard > 1) {
                newSuite = suiteNumOfCard - 2;
                col = 255;
                if (newNam < 0) { //red kings on bottom:
                    deckup = false;
                }
            } else {
                newSuite = suiteNumOfCard + 2;
                col = 0;
                if (newNam < 0) { //black kings on top:
                    deckup = true;
                }
            }
//            underCard.remove(0);
int textSize = 50;
            if (newNam >= 0) {
                //get even/odd:
                if (isOdd(newNam)) {
                    deckup = false; //A is at 0
                } else {
                    deckup = true;
                }
                DeckofCards temp = new DeckofCards(card.get(newNam), suit.get(newSuite), width / 2 - 80, height / 2 + 50, 0, color(col, 0, 0), newNam, newSuite, 140, 200, textSize);
                temp.display();
//                cards.add(new DeckofCards(card.get(newNam), suit.get(newSuite), mouseX - 50, mouseY - 75, 0, color(col, 0, 0), newNam, newSuite));
            } else {
                println("king");
                DeckofCards temp = new DeckofCards(card.get(12), suit.get(newSuite), width / 2 - 80, height / 2 + 50, 0, color(col, 0, 0), 12, newSuite, 140, 200, textSize);
                temp.display();
//                cards.add(new DeckofCards(card.get(12), suit.get(newSuite), mouseX - 50, mouseY - 75, 0, color(col, 0, 0), 12, newSuite));
            }
            ready = true;

//            underCard.get(0).display();

            if (!deckup) {
//                image(back, width / 2 - 70, height / 2 + 50, 140, 200);
            } else {
//                image(front, width / 2 - 70, height / 2 + 50, 140, 200);
            }
            //Android only: (not working!)
            //  if(mouseY > displayHeight/2){
            //    delay(1000);
            //      getAudienceSelection();
            //      cardNum+=2;
            //  }
            newReady = false;

        }

    }


    class DeckofCards {
        float xpos, ypos, rotation;
        String nam;
        int col;
        String suite;
        int namNum;
        int suiteNum;
        int w;
        int h;
        int txtS;

        DeckofCards(String name, String suit, float x, float y, float r, int c, int namNum_, int suiteNum_, int w_, int h_, int txtS_) {
            nam = name;
            xpos = x;
            ypos = y;
            rotation = r;
            col = c;
            suite = suit;
            namNum = namNum_;
            suiteNum = suiteNum_;
            w = w_;
            h = h_;
            txtS = txtS_;
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

            fill(255);
            rect(xpos, ypos, w, h, 10);
            textSize(txtS);

            fill(col);
            text((nam) + (suite), xpos + w/6, ypos + w/3);
//            rotate(PApplet.parseInt(rotation)); //does absolutely nothing..
        }

        public boolean over() {
            return (mouseX>xpos && mouseX<xpos+w&& mouseY>ypos&&mouseY<ypos+h);
        } // func



        public void updatePosition() {
            xpos = width + 300;
        }
    }

    public boolean isEven(int n) {
        return n % 2 == 0;
    }

    public boolean isOdd(int n) {
        return n % 2 != 0;
    }

    public boolean surfaceTouchEvent(MotionEvent event) {

        //call to keep mouseX, mouseY, etc updated
        super.surfaceTouchEvent(event);

        //forward event to class for processing
        return gesture.surfaceTouchEvent(event);
    }

    //Ketai gesture code:
    public void onFlick(float x, float y, float px, float py, float v) {
        if (x - px > 300) { //left to right
//    deckup = true;
            if (ready) {
                runOnce = true;
                background(0);
//                getAudienceSelection();
                cardNum += 2;
                ready = false;
                newReady = true;
            } else {
            }
        }
        if (px - x > 300) { //right to left
            if (ready) {
                runOnce = true;
                background(0);
//                getAudienceSelection();
                cardNum += 2;
                ready = false;
                newReady = true;
            } else {
            }
        }
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
