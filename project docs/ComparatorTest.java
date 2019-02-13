// File: ComparatorTest.java

// Inner class RectangleComparator implements the Comparator strategy interface,
// to provide an ordering for objects of Java's Rectangle class.  In this
// example, method compare() is implemented so as to order Rectangle objects
// by their areas.  However, if the areas are equal the rectangles are equal
// only if all 4 instance var's are equal, since the test for equality must
// be the same as in the overridden equals() method. Otherwise, if areas are
// equal but other instance var's are not, the ordering is based on the distance
// of the upper-lefthand corner from 0,0.

// Shows how to call the compare() method, and overloaded methods sort()
// and binarySearch() of the Arrays class. The overloaded versions of these
// methods take one additional parameter, which is a Comparator object.
import java.util.Arrays;
import java.util.Random;
import java.util.Comparator;
import java.awt.Rectangle;

public class ComparatorTest
{
   // static method to print an array of Rectangles

   public static void print(Rectangle[] list)
   {
      for (int i = 0; i < list.length; i++)
      {
         System.out.println(" [" + i + "] " + list[i] + "    area = "
               + list[i].getWidth() * list[i].getHeight());
      }
   }

   // static method to call binarySearch and print results
   public static void search(Rectangle[] list, Rectangle target,
         Comparator comp)
   {
      // 3rd arg to binarySearch is Comparator object variable
      int position = Arrays.binarySearch(list, target, comp);

      if (position >= 0)
      {
         System.out.println("\n" + target + " found in element #" + position);
      }
      else
      {
         System.out.println("\n" + target + " is not in the array");
      }
   }

   public static void main(String[] args)
   {
      // inner class implements Comparator for Rectangle class
      class RectangleComparator implements Comparator
      {

         public int compare(Object firstObject, Object secondObject)
         {
            // order based on area, ascending
            Rectangle r1 = (Rectangle) firstObject;
            double area1 = r1.getWidth() * r1.getHeight();
            Rectangle r2 = (Rectangle) secondObject;
            double area2 = r2.getWidth() * r2.getHeight();

            if (area1 < area2)
            {
               return -1;
            }
            if (area1 > area2)
            {
               return 1;
            }
            else  // areas are equal
            // test for equality must be the same as in overridden
            // equals() method - all 4 instance var's are equal
            {
               double x1 = r1.getX();
               double y1 = r1.getY();
               double x2 = r2.getX();
               double y2 = r2.getY();
               if (x1 == x2 && y1 == y2 && r1.getWidth() == r2.getWidth()
                  && r1.getHeight() == r2.getHeight())
               {
                  return 0;
               }
               else  // equal areas but not X, Y, width, and height
               // order on distance of upper-left corner from 0,0
               {
                  if (Math.sqrt(x1 * x1 + y1 * y1) <
                     Math.sqrt(x2 * x2 + y2 * y2))
                  {
                     return -1;
                  }
                  else
                  {
                     return 1;
                  }
               }
            }
         }
      }

      Random r = new Random();

      RectangleComparator comp = new RectangleComparator();

      Rectangle[] list = new Rectangle[8];

      // fill array with randomly-generated Rectangle objects where x, y,
      // width, and height are random ints in the range 1..9, inclusive

      for (int i = 0; i < list.length; i++)
      {
         int x = r.nextInt(9) + 1;
         int y = r.nextInt(9) + 1;
         int width = r.nextInt(9) + 1;
         int height = r.nextInt(9) + 1;
         list[i] = new Rectangle(x, y, width, height);
      }

      System.out.println("The array before sorting:");
      print(list);

      // 2nd arg to overloaded sort is Comparator object variable
      Arrays.sort(list, comp);

      System.out.println("\nThe array after sorting:");
      print(list);

      // search for whatever Rectangle is in a "middle" element!
      Rectangle r1 = list[list.length / 2];
      search(list, r1, comp);

      // search for a randomly-generated Rectangle
      Rectangle r2 = new Rectangle(r.nextInt(9) + 1, r.nextInt(9) + 1,
            r.nextInt(9) + 1, r.nextInt(9) + 1);
      search(list, r2, comp);

      // show how compare() works
      if (comp.compare(r1, r2) < 0)
      {
         System.out.println("\n" + r1 + " is less than " + r2);
      }
      else if (comp.compare(r1, r2) > 0)
      {
         System.out.println("\n" + r1 + " is greater than " + r2);
      }
      else
      {
         System.out.println("\n" + r1 + " and " + r2 + " are equal");
      }
   }
}

/* sample output:

The array before sorting:
 [0] java.awt.Rectangle[x=2,y=3,width=9,height=9]    area = 81.0
 [1] java.awt.Rectangle[x=1,y=7,width=5,height=3]    area = 15.0
 [2] java.awt.Rectangle[x=3,y=6,width=6,height=8]    area = 48.0
 [3] java.awt.Rectangle[x=9,y=1,width=4,height=3]    area = 12.0
 [4] java.awt.Rectangle[x=6,y=7,width=2,height=6]    area = 12.0
 [5] java.awt.Rectangle[x=6,y=9,width=2,height=1]    area = 2.0
 [6] java.awt.Rectangle[x=2,y=7,width=2,height=7]    area = 14.0
 [7] java.awt.Rectangle[x=9,y=9,width=2,height=8]    area = 16.0

The array after sorting:
 [0] java.awt.Rectangle[x=6,y=9,width=2,height=1]    area = 2.0
 [1] java.awt.Rectangle[x=9,y=1,width=4,height=3]    area = 12.0
 [2] java.awt.Rectangle[x=6,y=7,width=2,height=6]    area = 12.0
 [3] java.awt.Rectangle[x=2,y=7,width=2,height=7]    area = 14.0
 [4] java.awt.Rectangle[x=1,y=7,width=5,height=3]    area = 15.0
 [5] java.awt.Rectangle[x=9,y=9,width=2,height=8]    area = 16.0
 [6] java.awt.Rectangle[x=3,y=6,width=6,height=8]    area = 48.0
 [7] java.awt.Rectangle[x=2,y=3,width=9,height=9]    area = 81.0

java.awt.Rectangle[x=1,y=7,width=5,height=3] found in element #4

java.awt.Rectangle[x=6,y=5,width=2,height=6] is not in the array

java.awt.Rectangle[x=1,y=7,width=5,height=3] is greater than
java.awt.Rectangle[x=6,y=5,width=2,height=6]

 */
