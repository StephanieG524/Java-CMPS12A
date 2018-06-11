// Queens.java
// Stephanie Gardner
// sggardne
// pa5
// finds all the solution to the nQueens problem and prints it to the command line
//    -v is an arguemnt option for viewing the usage of the program that can be entered at the command line

import java.util.Scanner;
class Queens{
   public static void main(String[] args){

      
      int count = 0;
      int nQueens = 0;
      //Print Usage for user in terminal
      String usage = "Usage: Queens [-v] number\nOption: -v verbose output, print all solutions";
      //try catch to see if what is entered is a number or -v 
      try{
         //if -v is entered then read next int and continue, if not then print usage agin
         if(args[0].equals("-v")){
            try{
               nQueens = Integer.parseInt(args[1]);
            }catch(NumberFormatException e){
               System.out.println(usage);
            }

            //creates array with lenth of nQueens
            int[] set = new int[nQueens];
            for(int i = 0; i < set.length; i++){
               set[i] = i + 1;
            }

            //nth factorial
            int factorial = nQueens;
            for(int i = nQueens; i > 1; i--){
               factorial *= (i-1);
            }


            //prints array (# of solutions to nQueens)
            for (int i = 0; i<factorial; i++){
               if(isSolution(set)){
                  System.out.print("(");
                  count++;
                  for(int j = 0; j < set.length; j++){
                     if(j == set.length -1){
                        System.out.print(set[j]);
                     }else{
                        System.out.print(set[j]+ ", ");
                     }
                  }
                  System.out.print(") \n");     //beep beep

               }
               nextPermutation(set);
            }
            //resets array
            nextPermutation(set);
            //prints out the solutions to terminal
            System.out.println(nQueens+"-Queens has "+count+" solutions");

         }else{ 
         //reads first given argument (int) if -v wasnt entered
            try{
               nQueens = Integer.parseInt(args[0]); 
            }catch(NumberFormatException e2){ 
               //if not int or -v was given
               System.out.print(usage);
            } 
            int [] set = new int[nQueens];
            for(int i = 0; i < set.length; i++){
               set[i] = i +1;
            }
            int factorial = nQueens;
            for(int i = nQueens; i > 1;i--){
               factorial *= (i-1);
               for (i = 0; i<factorial;i++){
                  if(isSolution(set)){ //check to see if the queens has a solution
                     count++;
                  }
                  nextPermutation(set);
               }
               //resets array
               nextPermutation(set);
            }
            //prints out the solutions to terminal
            System.out.println(nQueens + "-Queens has " + count + " solutions");
         }
      }catch(ArrayIndexOutOfBoundsException e1){  
         //if neither a number or -v was entered, print usage
         System.out.println(usage);
      }
}


   //finds the nextPermutation for the array that was given from main function
   static void nextPermutation(int [] A){
      int pivot = -1;
      int nextPos = -1;
      int i;
      for(i= A.length-2; i >= 0; i--){
         if(A[i] < A[i+1]){
            pivot = i;
            break;
         }
      }
      if(pivot == -1){
         for (i = 0; i<A.length/2; i++){
            int temp = A[i];
            A[i] = A[A.length - 1 -i];
            A[A.length - 1 - i] = temp;
         }
      }
      if (pivot != -1){
         for(i=A.length-1; i >= 0; i--){
            if(A[i] > A [pivot]){
               nextPos = i;
               break;
            }
         }
      }
      if (pivot != -1){
         swap(A,pivot,nextPos);
      }
      if (pivot < A.length -1){
         int l = pivot +1;
         int r = A.length -1;
         while (l <r){
            swap(A,l,r);
            l++;
            r--;
         }
      }

   }

   // reverse part of the array to the right of the pivot point found
   static void swap(int [] A, int l, int r){
      int temp;
      temp = A[l];
      A[l] = A[r];
      A[r] = temp;

   }

   //checks if the array is a solution
   static boolean isSolution(int [] A){
      int n = 0;
      while (n < A.length){
         for (int i = 0; i < n; i++){
            if(A[i] == A[n]) return false;
            if((A[i] - A[n]) == (n-i)) return false;
            if((A[n] - A[i]) == (n-i)) return false;
         } n++;
      } return true;

   }



}