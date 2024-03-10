/**  Fish class
*    inherits from abstract Racer class
*/

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Fish extends Racer
{
	private int speed;
	private Random rand;
    private double move = 0;

   /** Default Constructor: calls Racer default constructor
   */
   public Fish( )
   {
     super( );
     setRandAndSpeed();
   }

   /** Constructor
   *    @param rID  racer Id, passed to Racer constructor
   *    @param rX    x position, passed to Racer constructor
   *    @param rY    y position, passed to Racer constructor
   */
   public Fish(String rID, int rX, int rY )
   {
     super( rID, rX, rY );
     setRandAndSpeed();
   }

   /** move:  calculates the new x position for the racer
   *   Fish move characteristics: "wavy"
   *      
   */
  
   public void move(){
    setX(getX() + 1); // move the fish forward
    setY((int) Math.round(Math.sin(move * 50)) + getY()); // create a wave-like motion
    move += 2; // increment the movement 
   }

   /** draw: draws the Fish at current (x, y) coordinate
   *       @param g   Graphics context
   */
   public void draw( Graphics g )
   {
     int startX = getX( );
     int startY = getY( );
     
     if(this.isWinner){
        morph(g);
      }
     

      //fins
      g.setColor(new Color(230, 84, 0));
      g.fillOval(startX - 23, startY, 7, 20);

      //body
      g.fillOval(startX - 35, startY + 5, 30, 10);

      //eye
      g.setColor(Color.black);
      g.fillOval(startX - 10, startY + 8, 3, 3);


      //stripes
      g.setColor(Color.white);
      g.fillArc(startX - 29, startY + 5, 6, 10, 90, 180);
      g.fillArc(startX - 22, startY + 5, 6, 10, 90, 180);
      g.fillArc(startX - 16, startY + 5, 6, 10, 90, 180);

   }
   
   private void setRandAndSpeed( ) {
      // percentage of time (between 90 - 99%) that this fish moves each turn
      rand = new Random( );
      speed = rand.nextInt( 10 ) + 90;
   }

   public void morph(Graphics g){
    g.fillOval(0, 0, 0, 0);
   }
}