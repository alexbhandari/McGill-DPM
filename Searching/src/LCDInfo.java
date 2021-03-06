/* Lab 4, Group 51 -- Alex Bhandari-Young and Neil Edelman */

import lejos.nxt.LCD;
import lejos.util.Timer;
import lejos.util.TimerListener;

public class LCDInfo implements TimerListener {
	public static final int LCD_REFRESH = 500;
	private Timer lcdTimer;
	private Robot robot;
   private String drawText = "Nothing";

	// arrays for displaying data
	private float [] pos;

	public LCDInfo(Robot r) {
		this.lcdTimer = new Timer(LCD_REFRESH, this);
		
		// initialise the arrays for displaying data
		pos = new float[3]; /* confusing, why? */
		
		robot = r;
		
		// start the timer
		lcdTimer.start();
	}
	
	public void timedOut() {
		Position p = robot.getPosition();
		LCD.clear();
		LCD.drawString("X value: ", 0, 0);
		LCD.drawString("Y value: ", 0, 1);
		LCD.drawString("Theta value: ", 0, 2);
		LCD.drawString("Distance: ", 0, 3);
		/*LCD.drawString("Colour: "+robot.getColour(), 0, 4);*/
		LCD.drawString("Status: "+robot.getStatus(), 0, 5);
      LCD.drawString("T x,y: ", 0, 6);
      LCD.drawString(drawText, 0, 7);
		LCD.drawInt((int)p.x, 13, 0);
		LCD.drawInt((int)p.y, 13, 1);
		LCD.drawInt((int)p.theta, 13, 2);
		LCD.drawInt(robot.getLastDistance(), 12, 3);
      LCD.drawInt((int)robot.getTarget().x, 8, 6);
      LCD.drawInt((int)robot.getTarget().y, 14, 6);
	}

   public void setText(String text) {
      this.drawText = text; 
   }
}
