//  File: YesOverriding.java

//  In this example, the Ride class overrides the "toString" method to return
//  the color and make of a Car object
//  The Ride class also overrides the "equals" method so that it returns true
//  when 2 Car objects have the same make and color, and false otherwise. I.e.,
//  so it compares the objects "pointed to" instead of the object references
class Ride
{

   private String make;
   private String color;

   public Ride(String make, String color)
   {
      this.make = make;
      this.color = color;
   }

   public String toString()
   {
      return color + " " + make;
   }

   public boolean equals(Object other)
   {
      // prevent possible NullPointerException
      if (other == null)
      {
         return false ;       // this Ride can't be equal to null
      }

      // prevent possible ClassCastException
      if ( ! this.getClass().equals(other.getClass()) )
      {
         return false;
      }

      // now safe to downcast Object obj to Ride obj
      Ride that = (Ride) other;

      // note: Java String class already overrides equals method
      return this.color.equals(that.color)
              && this.make.equals(that.make);
   }
}

public class YesOverriding
{
   public static void main(String args[])
   {
      Ride myCar = new Ride("Tesla", "tangerine");
      Ride yourCar = new Ride("Ferrari", "fuschia");

      System.out.print("\nOutput from "
              + "System.out.println( myCar ) : ");

      System.out.println(myCar);		// calls toString implicitly

      System.out.print("\nOutput from "
              + "System.out.println( yourCar ) : ");

      System.out.println(yourCar);

      if (myCar == yourCar)
      {
         System.out.println("\n\"myCar == yourCar\" is true");
      } else
      {
         System.out.println("\n\"myCar == yourCar\" is false");
      }

      if (myCar.equals(yourCar))
      {
         System.out.println("\n\"myCar.equals(yourCar)\" is true");
      } else
      {
         System.out.println("\n\"myCar.equals(yourCar)\" is false");
      }

      yourCar = myCar;

      System.out.println("\nafter assigning \"yourCar = myCar\" ...");

      if (myCar == yourCar)
      {
         System.out.println("\n\"myCar == yourCar\" is true");
      } else
      {
         System.out.println("\n\"myCar == yourCar\" is false");
      }

      if (myCar.equals(yourCar))
      {
         System.out.println("\n\"myCar.equals(yourCar)\" is true");
      } else
      {
         System.out.println("\n\"myCar.equals(yourCar)\" is false");
      }

      yourCar = new Ride("Tesla", "tangerine");

      System.out.println("\nafter assigning "
              + "\"yourCar = new Ride(\"Tesla\", \"tangerine\")\" ...");

      if (myCar == yourCar)
      {
         System.out.println("\n\"myCar == yourCar\" is true");
      } else
      {
         System.out.println("\n\"myCar == yourCar\" is false");
      }

      if (myCar.equals(yourCar))
      {
         System.out.println("\n\"myCar.equals(yourCar)\" is true");
      } else
      {
         System.out.println("\n\"myCar.equals(yourCar)\" is false");
      }
   }
}

/* Program output:

 Output from System.out.println( myCar ) : tangerine Tesla

 Output from System.out.println( yourCar ) : fuschia Ferrari

 "myCar == yourCar" is false

 "myCar.equals(yourCar)" is false

 after assigning "yourCar = myCar" ...

 "myCar == yourCar" is true

 "myCar.equals(yourCar)" is true

 after assigning "yourCar = new Ride("Tesla", "tangerine")" ...

 "myCar == yourCar" is false

 "myCar.equals(yourCar)" is true

 */
