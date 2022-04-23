import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
  //create image variables, and create X, Y, and other variables for animation
	PImage imgSPACE;
  PImage imgMETEOR;
  PImage imgSHIP;
  float fltSHIPx = 50;
  float fltSHIPy = 300;
  float fltSHIPSpeedx = 1;
  int METEORX = 25;
  int METEORY = 25;
  int METEORSpeedX = 3;

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  
  
  public void settings() {
	// put your size call here
    size(400, 400);
    
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */

  public void setup() {
    background(210, 255, 173);
    
    //loads the images from the files
    imgSPACE = loadImage("SPACE.jpeg");
    imgMETEOR = loadImage("METEOR.jpg");
    imgSHIP = loadImage("SHIP.jpg");

    //resize space background and meteor
    imgSPACE.resize(400, 400);
    imgMETEOR.resize(50, 50);
    imgSHIP.resize(100, 100);
    
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    //Loads the meteor and space background
	  image(imgSPACE, 0, 0);
    image(imgMETEOR, METEORX, METEORY);
    
    METEORX += METEORSpeedX;
    
    //set boundries for the meteor
    if (METEORX < 0 || METEORX > width - 100) {
      METEORX *= -1;
    }

    image(imgSHIP, fltSHIPx, fltSHIPy);
    
    float fltParabola = (float)Math.pow(1.5 * fltSHIPx - 200, 2);

    fltSHIPx = fltSHIPx + fltSHIPSpeedx;
    fltSHIPy = fltParabola / 225;

    if (fltSHIPx < 0 || fltSHIPx > width - 80) {
      fltSHIPSpeedx *= -1;
    }
    if (fltSHIPy < 0 + 15 || fltSHIPy > height - 15) {
      fltParabola *= -1;
    }
  }
  
  // define other methods down here.
  
}