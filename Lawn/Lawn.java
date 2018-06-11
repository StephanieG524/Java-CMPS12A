//Lawn.java
//Stephanie Gardner
//sggardne
//Pa1 - Lawn
//calculates mowing time at user-given rate (sqare ft/sec)
//   user inputs total lot size and house size


import java.util.Scanner;

class Lawn{
   public static void main(String[] args){
  
      double LotLength, LotWidth, LotArea, HouseLength, HouseWidth, HouseArea, MowArea, MowRate, MowTotalSeconds, MowHour, MowMinutes, MowSeconds;
      Scanner sc = new Scanner(System.in);
    
      // Below collects user input to use later for calculations
      System.out.print("Enter the length and width of the lot, in feet: ");
      LotLength = sc.nextDouble();
      LotWidth = sc.nextDouble();
      System.out.print("Enter the length and width of the house, in feet: ");
      HouseLength = sc.nextDouble();
      HouseWidth = sc.nextDouble();
      
      //Below calculates the lawn area in square feet from user input
      LotArea = LotLength * LotWidth;
      HouseArea = HouseLength * HouseWidth;
      MowArea = LotArea - HouseArea;
      System.out.println("The lawn area is " + MowArea + " square feet.");

      //Below takes user input for mowing rate
      System.out.print("Enter the mowing rate, in square feet per second: ");
      MowRate = sc.nextDouble();
      
      //Below calculates mowing time to total seconds
      MowTotalSeconds = MowArea / MowRate;  

      //Below converts total seconds to hours, minutes and seconds
      MowMinutes = (int) Math.round((MowTotalSeconds / 60) % 60);
      MowSeconds = (int) Math.round(MowTotalSeconds %  60);
      MowHour = (int) Math.round(MowMinutes / 60);
      
      //Below corrects and lists the quantity to singular if necessary 
      System.out.println("The mowing time is " + MowHour + " hour" + (MowHour == 1? " " : "s ") + MowMinutes + " minute" + (MowMinutes == 1? " " : "s ") + MowSeconds + " second" + (MowSeconds == 1? " " : "s."));  
      
   }


}

