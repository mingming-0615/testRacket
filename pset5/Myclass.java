public class Myclass{

   private int Balloon_num;
   private int red,green,blue;
   private double yPosition;
   private double xPosition;
   private double yVelocity;
   private double xVelocity;
   private double yAcceleration;
   private char Balloon_order;
   private String Balloon_full_name;

   public String toString(){ //no local variable
   
        
      return "Order(" + Balloon_order+")Name(" + Balloon_full_name+ ")speed("+xVelocity+","+yVelocity+")"
         +"position("+ xPosition+","+ yPosition+")Acceleration("+yAcceleration+ ")Color("+red+","
         +green+","+blue+ ")";
   }

   public void move(){
      yPosition += yVelocity;
   }

   public void draw(){
      PennDraw.filledCircle(xPosition,yPosition,1);
      PennDraw.setPenColor(red, green, blue);
   }


   public static void main (String[] args)//arg is local variable.
   {
      Myclass firstBalloon = new Myclass();  
      Myclass secondBalloon = new Myclass();
      
      firstBalloon.Balloon_full_name ="mingming";
      secondBalloon.Balloon_full_name="Tian";
      
      String s1="First Balloon:"+ firstBalloon; //this is print out. return isn't.
      String s2="Second Balloon:"+ secondBalloon;//automatically call .tostring
      
      System.out.println(s1);
      System.out.println(s2);
   }
}