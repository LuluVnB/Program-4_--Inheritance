/**  Squirrel class
*    inherits from abstract Racer class
*/

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Squirrel extends Racer
{
	private int speed;
	private Random rand;

   /** Default Constructor: calls Racer default constructor
   */
   public Squirrel( )
   {
     super( );
     setRandAndSpeed();
   }

   /** Constructor
   *    @param rID  racer Id, passed to Racer constructor
   *    @param rX    x position, passed to Racer constructor
   *    @param rY    y position, passed to Racer constructor
   */
   public Squirrel(String rID, int rX, int rY )
   {
     super( rID, rX, rY );
     setRandAndSpeed();
   }

   /** move:  calculates the new x position for the racer
   *   Squirrel move characteristics: "speedy and erratic"
   *      random direction movements (up, left, right)
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
            if(distance < 7){  //this is to limit how chaotic the squirrel moves
                setY(getY() - distance);
            }
            break;
        case 3: // move down
            if(distance < 7){  //this is also to limit how chaotic the squirrel moves
                setY(getY() + distance);
            }
            break;

       }
   }

   /** draw: draws the Squirrel at current (x, y) coordinate
   *       @param g   Graphics context
   */
   public void draw( Graphics g )
   {
     int startX = getX( );
     int startY = getY( );
     
     
     //tail
     g.setColor(new Color(140, 90, 0));
     g.fillArc(startX - 40, startY, 40, 40, 40, 30);


    
     g.setColor( new Color( 200, 64, 0 ) ); // brown


     //body
     g.fillOval( startX - 30, startY, 15,25);

     //head
     g.fillOval( startX - 29, startY - 7,  13, 13);

     //ears
     g.fillArc(startX - 30, startY - 10, 15, 15, 115, 40);
     g.fillArc(startX - 30, startY - 10, 15, 15, 20, 40);
     



     //flatten bottom
    //   g.clearRect( startX - 30, startY + 11, 35, 4 );

     //feet
    //  g.setColor( new Color( 34, 139, 34 ) );  // brown
    //  g.fillOval( startX - 27, startY + 10,  1, 1 );
    //  g.fillOval( startX - 13, startY + 10, 1, 1 );
   }
   
   private void setRandAndSpeed( ) {
      // percentage of time (between 90 - 99%) that this squirrel moves each turn
      rand = new Random( );
      speed = rand.nextInt( 10 ) + 90;
   }
}