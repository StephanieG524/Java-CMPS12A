//GCD.java
//Stephanie Gardner
//sggardne
//pa3
//Takes 2 ints from user input, checks for validity and then calculates greatest common demoninator 

import java.util.Scanner;

class GCD{

   public static void main(String [] args){
      Scanner sc = new Scanner (System.in);
      int a=0,b=0,r=0,temp,i,x,GCD = 0,n1,n2; //initialize all variables
      
      //Check for user input
      for (i = 0; i <2; i++){
         System.out.print("Enter a positive integer: ");
         while(true){
            if(!sc.hasNextInt()){
               sc.next();
               System.out.print("Please enter an integer: ");
            }else{
            x = sc.nextInt();
            if(x>0){
               break;
            }
            System.out.print("Please enter a POSITIVE integer: ");
            }
         } //break lands here
         //first iteration is stored in a and second is stored in b
         if (i == 0) a = x;
         else if (i == 1) b = x;
      }
      //saves original two ints
      n1 = a;
      n2 = b;

      //Make sure a is larger than b
      if(a < b) {temp = a; a = b; b = temp;}
      
      //iterates through until b is 0 which means GCD is a
      while( b > 0){
         r = a%b;
         a = b;
         b = r;
      }
      GCD = a;
      System.out.println("The GCD of " + n1 + " and " + n2 + " is " + GCD);

   }

}