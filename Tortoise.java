/**  Tortoise class
*    inherits from abstract Racer class
*/

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Color;
import java.util.Random;

public class Tortoise extends Racer
{
	private int speed;
	private Random rand;

   /** Default Constructor: calls Racer default constructor
   */

   public String getInfo(){
    return "Program 4, Gian Paraguya";
  }

   public Tortoise( )
   {
     super( );
     setRandAndSpeed();
   }

   /** Constructor
   *    @param rID  racer Id, passed to Racer constructor
   *    @param rX    x position, passed to Racer constructor
   *    @param rY    y position, passed to Racer constructor
   */
   public Tortoise( String rID, int rX, int rY )
   {
     super( rID, rX, rY );
     setRandAndSpeed();
   }

   /** move:  calculates the new x position for the racer
   *   Tortoise move characteristics: "slow & steady wins the race"
   *      increment x by 1 most of the time
   */
   public void move( )
   {
     int move =  rand.nextInt( 100 )  + 1;
     if ( move < speed )
       setX( getX( ) + 1 );
   }

   /** draw: draws the Tortoise at current (x, y) coordinate
   *       @param g   Graphics context
   */
   public void draw( Graphics g )
   {
     int startX = getX( );
     int startY = getY( );
     
     	g.setColor( new Color( 34, 139, 34 ) ); // dark green

      if(this.isWinner){
        morph(g);
      }

     //body
     g.fillOval( startX - 30, startY, 25, 15 );

     //head
     g.fillOval( startX - 10, startY + 5,  15, 10 );



     //flatten bottom
      g.clearRect( startX - 30, startY + 11, 35, 4 );

     //feet
     g.setColor( new Color( 34, 139, 34 ) );  // brown
     g.fillOval( startX - 27, startY + 10,  5, 5 );
     g.fillOval( startX - 13, startY + 10, 5, 5 );
   }
   
   private void setRandAndSpeed( ) {
      // percentage of time (between 90 - 99%) that this tortoise moves each turn
      rand = new Random( );
      speed = rand.nextInt( 10 ) + 90;
   }

   public void morph(Graphics g){
    int startX = getX( );
    int startY = getY( );
    
      g.setColor( new Color( 34, 139, 34 ) ); // dark green

    //body
    g.fillOval( startX - 30, startY, 25, 15 );

    //head
    g.fillOval( startX - 10, startY + 5,  15, 10 );
    g.setColor(Color.pink);


    //party hat
    g.setColor(Color.pink);

    // g.fillPolygon(new Polygon(new int[] {startX - 33, startX + 37, startX + 43}, new int[] {57, 37, 57}, 3));
    g.fillPolygon(new Polygon(new int[] {getX() - 4, getX(), getX() + 4 }, new int[] {57, 37, 57}, 3));
    g.setColor(new Color(0, 100, 0));
    g.fillOval(getX() - 3, 36, 7, 7);

    //flatten bottom
     g.clearRect( startX - 30, startY + 11, 35, 4 );

    //feet
    g.setColor( new Color( 34, 139, 34 ) );  // brown
    g.fillOval( startX - 27, startY + 10,  5, 5 );
    g.fillOval( startX - 13, startY + 10, 5, 5 );
   }
}