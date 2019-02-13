//  File: NoOverriding.java

//  Shows what is returned by the toString method inherited from superclass
//  Object when called for a subclass object

//  Also shows that the inherited "equals" method works exactly like
//  the "==" operator. I.e., it  compares the object references themselves and
//  NOT the actual objects "pointed to."  So, it returns true when the object
//  variables contain the same reference (i.e., point to the same object), and
//  false otherwise.

//  Shows why you should always override toString() and equals()

/**
 * A class to represent a car of a specific make and color.
 */
class Ride
{
	// instance variables
	private String make ;		// the make of the car
	private String color ;		// the color

	/**
	 * Creates a Ride object
	 * @param theMake the make of the ride
	 * @param theColor the color of the ride
	 */
	public Ride(String theMake, String theColor)
	{
		make = theMake ;
		color = theColor ;
	}

	/**
	 * Paints a Ride object a new color
	 * @param newColor the new color
	 */
	public void paint(String newColor)
	{
		color = newColor ;
	}

	/**
	 * Returns the make of a Ride object (e.g., Ferrari)
	 * @return the make
	 */
	public String getMake()
	{
		return make ;
	}

	/**
	 * Returns the color of a Ride object
	 * @return the color
	 */
	public String getColor()
	{
		return color ;
	}
} //========================================================================

public class NoOverriding
{
	public static void main(String args[])
	{
		Ride myCar = new Ride("Tesla", "tangerine") ;
		Ride yourCar = new Ride("Ferrari", "fuschia") ;

		System.out.println("Initially, myCar is a " + myCar.getColor() + " " +
		                    myCar.getMake() + "...\n") ;
		System.out.println("...and yourCar is a " + yourCar.getColor() +
		                   " " + yourCar.getMake() ) ;

		System.out.print("\nOutput from " +
		                   "System.out.println( myCar ) : ") ;

		System.out.println( myCar ) ;		// calls toString implicitly

		System.out.print("\nOutput from " +
		                 "System.out.println( yourCar ) : ") ;

		System.out.println( yourCar ) ;

		if (myCar == yourCar)
		  System.out.println("\n\"myCar == yourCar\" is true") ;
		else
		  System.out.println("\n\"myCar == yourCar\" is false") ;

		if (myCar.equals(yourCar))
		  System.out.println("\n\"myCar.equals(yourCar)\" is true") ;
		else
		  System.out.println("\n\"myCar.equals(yourCar)\" is false") ;

		yourCar = myCar ;

		System.out.println("\nafter assigning \"yourCar = myCar\" ...") ;

		if (myCar == yourCar)
		  System.out.println("\n\"myCar == yourCar\" is true") ;
		else
		  System.out.println("\n\"myCar == yourCar\" is false") ;

		if (myCar.equals(yourCar))
		  System.out.println("\n\"myCar.equals(yourCar)\" is true") ;
		else
		  System.out.println("\n\"myCar.equals(yourCar)\" is false") ;

		yourCar = new Ride("Tesla", "tangerine") ;

		System.out.println("\nafter assigning " +
		                  "\"yourCar = new Ride(\"Tesla\", \"tangerine\")\" ...") ;

		if (myCar == yourCar)
		  System.out.println("\n\"myCar == yourCar\" is true") ;
		else
		  System.out.println("\n\"myCar == yourCar\" is false") ;

		if (myCar.equals(yourCar))
		  System.out.println("\n\"myCar.equals(yourCar)\" is true") ;
		else
		  System.out.println("\n\"myCar.equals(yourCar)\" is false") ;
	}
}

/* Program output:

Initially, myCar is a tangerine Tesla...

...and yourCar is a fuschia Ferrari

Output from System.out.println( myCar ) : Ride@18d107f

Output from System.out.println( yourCar ) : Ride@360be0

"myCar == yourCar" is false

"myCar.equals(yourCar)" is false

after assigning "yourCar = myCar" ...

"myCar == yourCar" is true

"myCar.equals(yourCar)" is true

after assigning "yourCar = new Ride("Tesla", "tangerine")" ...

"myCar == yourCar" is false

"myCar.equals(yourCar)" is false

*/	
