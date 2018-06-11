//Roots.java
//Stephanie Gardner
//sggardne
//pa4
//Finds the odd and even roots of a polynomial within user given parameters

import java.lang.Math;
import java.util.Scanner;

class Roots {
   public static void main( String [] args ){

      Scanner sc = new Scanner (System.in);
      double L,R;
      int i,coef;

      System.out.println("Enter the degree:");
      while(!sc.hasNextInt()){
         sc.next();
      }
      int degree = sc.nextInt();
      coef = degree+1;
      double [] coefArray = new double[coef];
      System.out.println("Enter " + coef + " coefficients:");
      while(!sc.hasNextDouble()){
         sc.next();
      }
      //Make polynomial 

      for(i = 0;i<= degree; i++){
         coefArray[i] = sc.nextInt();
      }

      double tolerance = 10e-11, threshold = 10e-3, resolution = 10e-2;

      while(true){
         System.out.println("Enter endpoints, or q to quit:");

         if(!sc.hasNextDouble()){
            sc.next();
            System.out.println("bye!");
            break;
         }

         L = sc.nextDouble();
         R = sc.nextDouble();

         double[] derivCoef = new double[degree];
         derivCoef = diff(coefArray); //array of deriv coeff

         //Subintervals
         double a = L;
         double b = a + resolution;

         double m = (a+b)/2;
         double valueA = poly(coefArray,a);
         double valueB = poly(coefArray,b);
         double derivA = poly(derivCoef,a);
         double derivB = poly(derivCoef,b);

         double value;
         boolean hasRoot = false;

         while(b < R){
            if((valueA < 0 && valueB > 0) || (valueA > 0 && valueB < 0)){
            value = findRoot(coefArray,a,b,tolerance);
               if(value!=0){
                  System.out.print("Odd root found in [" + L + "," + R + "] at: ");
                  System.out.printf("%.10f",value);
                  System.out.print("\n");
               }

               hasRoot = true;

            }
            else if((derivA < 0 && derivB > 0) || (derivA > 0 && derivB < 0)){
               value = findRoot(derivCoef,a,b,tolerance);
               double root = poly(coefArray,value);
               if(Math.abs(root) < threshold){
                  System.out.print("Even root found in [" + L + "," + R + "] at: " );
                  System.out.printf("%.10f",value);
                  System.out.print("\n");
               }
               hasRoot = true;
            }
            a = b;
            b = a + resolution;
            valueA = poly(coefArray,a);
            valueB = poly(coefArray,b);
            derivA = poly(derivCoef,a);
            derivB = poly(derivCoef,b);
         }

         if(!hasRoot)
            System.out.println("No root found in " + "[" + L + "," + R + "]");

      }
}


   //Retuns the value of the polynomial with coefficient C array, evaluated at x
   static double poly(double[] C, double x){
      //loop that multiples each coeficient by an approprate power of x
      //accumulates the sum of all such terms
      //when loop terminates, return the sum
      double value = C[0];
      int i;
      for (i = 1; i < C.length; i++){
         value = value+Math.pow(x,i)*C[i];
      }
      return value;
      

   }

   //the call diff(C) will return a reference to a newly allocated array D
   //containing the coefficients of the polynomial that is the derivative 
   //of the polynomial with coefficient array C
   static double[] diff(double[] C){
      // function poly(D,x) will be the derivative function of poly (C,x)
      int i;
      double[] D = new double[C.length-1];
      for (i=1;i<C.length-1;i++){
         D[i] = C[i]*i;
      }

      return D;

   }

   //This function has a precondition that says the polynomial takes opposite signs at the
   //endpoints of the interval. Therefore it should only be called when that precondition is satisfied
   static double findRoot (double[] C, double a, double b, double tolerance){
      double m = (a+b)/2;
      boolean hasRoot = false;
      double coorA = a;
      double coorB = b;
      double valueA = poly(C,coorA);
      double valueB = poly(C,coorB);
      double valueM = poly(C,m);
      double width = coorB - coorA;
      while(width > tolerance){
         if((valueA < 0 && valueM > 0) || (valueA > 0 && valueM < 0)){
            coorB = m;
            m = (coorA + coorB)/2;
            valueM = poly(C,m);
            valueB = poly(C,coorB);
            width = coorB-coorA;
            hasRoot = true;
         }
         if((valueB < 0 && valueM > 0) || (valueB > 0 && valueM < 0)){
            coorA = m;
            m = (coorA + coorB)/2;
            valueM = poly(C,m);
            valueA = poly(C,coorA);
            width = coorB-coorA;
            hasRoot = true;
         }
      }

         if(hasRoot)
            return m;
         else
            return 0;

   }

}



