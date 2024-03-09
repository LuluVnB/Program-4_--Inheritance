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
   public void move( )
   {
     int move =  rand.nextInt( 100 )  + 1;
     int directionChange = rand.nextInt(4);
     int distance = rand.nextInt(10) + 1;
     if ( move < speed )
       switch(directionChange){
        case 0: //move right
            setX(getX() + distance);
            break;
        case 1: // for moving left, but it doesn't make sense so we don't want that
            break;
        case 2: // move up
            if(distance < 7){  //this is to limit how chaotic the fish moves
                setY(getY() - distance);
            }
            break;
        case 3: // move down
            if(distance < 7){  //this is also to limit how chaotic the fish moves
                setY(getY() + distance);
            }
            break;

       }
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
     
     //tail
     g.setColor(new Color(140, 90, 0)); //darker brown
     g.fillArc(startX - 40, startY, 40, 40, 40, 30);



     //body
     g.setColor( new Color( 180, 64, 0 ) ); // brown
     g.fillOval( startX - 30, startY, 15,25);
     g.setColor( new Color( 180, 130, 0 ) ); // lighter brown for stomache 
     g.fillOval( startX - 28, startY + 6, 10,16);
     
    //arms
    g.setColor(new Color(100, 100, 50)); //darker brown
    g.fillOval(startX - 21, startY + 6, 5, 10);
    g.fillOval(startX - 29, startY + 6, 5, 10);




     //head
     g.setColor( new Color( 180, 64, 0 ) ); // brown
     g.fillOval( startX - 29, startY - 7,  13, 13);

     //eyes
     g.setColor(new Color(0, 0, 0)); //black
     g.fillOval(startX - 26, startY - 3, 3, 3);
     g.fillOval(startX - 20, startY - 3, 3, 3);


     //ears
     g.setColor( new Color( 180, 64, 0 ) ); // brown
     g.fillArc(startX - 30, startY - 10, 15, 15, 115, 40);
     g.fillArc(startX - 30, startY - 10, 15, 15, 20, 40);

     
    //feet
    g.setColor( new Color( 110, 64, 0 ) ); // brown
    g.fillOval( startX - 29, startY + 20,  7, 6 );
    g.fillOval( startX - 20, startY + 20, 7, 6 );

     




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