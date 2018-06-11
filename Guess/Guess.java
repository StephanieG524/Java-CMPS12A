// Guess.java
// Stephanie Gardner
// sggardne
// pa2
// program that plays an interactive guessing game with the user

import java.util.Scanner;

class Guess{
   public static void main(String[] args){

   int G;
   Scanner sc = new Scanner(System.in);

   //define the range of random numer
   int max = 10;
   int min = 1;
   int range = (max - min) + 1;

   //generate random number
   int R = (int)(Math.random() * range) + min;

   System.out.print("I'm thinking of an integer in the range 1 to 10. You have three guesses.\n\n");
   System.out.print("Enter your first guess: ");
   G = sc.nextInt();


   //first chance
   if (G > R){ //if first guess was too high
      System.out.println("Your guess is too high. \n");
      //second chance if first guess was too high
      System.out.print("Enter your second guess: ");
      G = sc.nextInt();
      if (G > R){ // if second guess too high
         System.out.println("Your guess is too high. \n");
         System.out.print("Enter your third guess: ");
         G = sc.nextInt();
         if (G > R){ //Third guess too high
            System.out.println("Your guess is too high. \n You lose. The number was " + R);
         }else if (G < R){ // Third guess too low
            System.out.println("Your guess is too low. \n You lose. the number was " + R);
         }else{ //Third guess correct
            System.out.println("You Win! ");
         }
      }else if (G < R){ //if second guess was too low
         System.out.println("Your guess is too low. \n");
            //third chance for too low twice in a row
         System.out.print("Enter your third guess: ");
            G = sc.nextInt();
         if (G > R){ //third guess too high
            System.out.println("Your guess is too high. \n You lose. The number was " + R);
         }else if ( G < R){ //Third guess is too low
            System.out.println("Your guess is too low. \n You lose. The number was " + R);
         }else{ // third guess correct 
            System.out.println("You Win! ");
         }
      }else{ //if second guess is correct
         System.out.println("You Win! ");
      }	
   }else if (G < R){ // if first guess was too low
      System.out.println("Your guess is too low. \n");
      //second chance if first guess was too low
      System.out.print("Enter your second guess: ");
      G = sc.nextInt();
      if (G > R){ // if second guess too high
         System.out.println("Your guess is too high. \n");
         System.out.print("Enter your third guess: ");
         G = sc.nextInt();
         if (G > R){ //Third guess too high
            System.out.println("Your guess is too high. \n You lose. The number was " + R);
         }else if (G < R){ // Third guess too low
            System.out.println("Your guess is too low. \n You lose. the number was " + R);
         }else{ //Third guess correct
            System.out.println("You Win! ");
         }
      }else if (G < R){ //if second guess was too low
         System.out.println("Your guess is too low. \n");
         //third chance for too low twice in a row
         System.out.print("Enter your third guess: ");
         G = sc.nextInt();
         if (G > R){ //third guess too high
            System.out.println("Your guess is too high. \n\nYou lose. The number was " + R);
         }else if ( G < R){ //Third guess is too low
            System.out.println("Your guess is too low. \n\nYou lose. The number was " + R);
         }else{ // third guess correct 
            System.out.println("You Win! ");
         }
      }else{ //if second guess is correct
      	System.out.println("You Win! ");
      }
   }else{ //if first guess is correct
      System.out.println("You Win! ");
   } 
   }
}
