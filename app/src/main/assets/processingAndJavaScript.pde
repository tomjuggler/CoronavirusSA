String processingString = "Hello from Processing!";
//function hi {

//alert("hello");
//};

int rad = 60;        // Width of the shape
float xpos, ypos;    // Starting position of shape    

float xspeed = 2.8;  // Speed of the shape
float yspeed = 2.2;  // Speed of the shape

int xdirection = 1;  // Left or Right
int ydirection = 1;  // Top to Bottom

void setup() {
colorMode(HSB,360,100,100);
  size(400,400);
  smooth(); 
  printMessage(jsString + " " + processingString);
createGreen();

createRed();




//alert(jsString);
}

boolean followMouse = false;

void draw(){
background(0,0,0);
  stroke(random(100,360),80,100);//set the color
  
  for(int x=0; x<=width; x=x+5) {
    //float y = (sin(radians(x+frameCount))*170)+(height/2);
    float y = (sin(radians(x+frameCount))*170)+(height/2);
    
    //line(x,y,mouseX,mouseY);
    //line(x,y,10,10);
    //line(x,y,mouseX,(height/2));
    if(followMouse){
     line(x,y,mouseX,mouseY);
    }else{
     line(x,y,(width/2),(height/2));
    }
  }

}

void mousePressed(){
 followMouse = !followMouse;
 
}

void createGreen(){

var btnGreen = document.createElement("BUTTON");        // Create a <button> element
btnGreen.style.backgroundColor = "green";
btnGreen.style.height = "100";
btnGreen.style.with = "100";
btnGreen.setAttribute("onClick", "window.open('green.htm','_self')");
//btnGreen.setAttribute("onClick", "alert('OnClick')");

var g = document.createTextNode("Green");       // Create a text node
btnGreen.appendChild(g);                                // Append the text to <button>
document.body.appendChild(btnGreen);                    // Append <button> to <body>
}

void createRed(){
var btnRed = document.createElement("BUTTON");        // Create a <button> element
btnRed.style.backgroundColor = "red";
btnRed.style.height = "100";
btnRed.style.with = "100";
btnRed.setAttribute("onClick", "window.open('red.htm','_self')");
//btnRed.setAttribute("onClick", "alert('OnClick')");

var r = document.createTextNode("Red");       // Create a text node
btnRed.appendChild(r);                                // Append the text to <button>
document.body.appendChild(btnRed);                    // Append <button> to <body>
}


