/////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	Name:			Mark Barros
//	Course:			CS1400 - Intro to Programming and Problem Solving
//	Description:	This program demonstrates the Rational class.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////

// This is the RationalApp class. ---------------------------------------------------------------------------
public class RationalApp
{
	public static void main(String [] args)
	{
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Rational Numbers - by Mark Barros");
		System.out.println("------------------------------------------------------------------------------");
		System.out.println();

		// constructor examples -----------------------------------------------------------------------------
		// The default Rational is zero over one
		Rational defaultRational = new Rational();
		// Rational that takes two parameters (numerator and denominator)
		Rational twoParameterRational = new Rational(3,4);
		// Rational that accepts one parameter, the numerator (the denominator is 1)
		Rational numberRational = new Rational(9);

		// toString(), getP(), and getQ() examples ----------------------------------------------------------

		System.out.println("Accessing the default rational number using toString(): "
				+ defaultRational.toString());
		System.out.println("Accessing the two parameter rational number using toString(): "
				+ twoParameterRational.toString());
		System.out.println("Accessing the number rational using toString(): "
				+ numberRational.toString());
		System.out.println("Accessing the numerator of the two parameter rational number using getP(): "
				+ twoParameterRational.getP());
		System.out.println("Accessing the denominator of the two parameter rational number using getQ(): "
				+ twoParameterRational.getQ());

		// getRational() example ----------------------------------------------------------------------------
		
		Rational aRational = new Rational(13,19);
		Rational returnedRational = aRational.getRational();
		System.out.print("Returning a Rational object using getRational(): ");
		System.out.println(returnedRational.toString());		
		
		// set() example ------------------------------------------------------------------------------------

		twoParameterRational.set(15,17);
		System.out.println("Using set(), the two parameter rational number has been reset to: "
				+ twoParameterRational.toString());

		// equals() example ---------------------------------------------------------------------------------

		Rational firstRational = new Rational(4,5);
		Rational secondRational = new Rational(6,9);
		Rational thirdRational = new Rational(4,5);

		System.out.println("Using equals(), is the first rational number equal to the second? "
				+ firstRational.equals(secondRational));
		System.out.println("Using equals(), is the first rational number equal to the third? "
				+ firstRational.equals(thirdRational));

		// add(), subtract(), multiply(), and divide() examples ---------------------------------------------

		System.out.print("Adding two rational numbers using add(): 4/5 + 6/9 =  ");
		System.out.println(firstRational.add(secondRational));
		System.out.print("Subtracting two rational numbers using subtract(): 4/5 - 6/9 = ");
		System.out.println(firstRational.subtract(secondRational));
		System.out.print("Multiplying two rational numbers using multiply(): 4/5 * 6/9 = ");
		System.out.println(firstRational.multiply(secondRational));
		System.out.print("Dividing two rational numbers using divide(): 4/5 / 6/9 = ");
		System.out.println(firstRational.divide(secondRational));

		// print(n) examples --------------------------------------------------------------------------------

		Rational underOneRational = new Rational(16,19);
		System.out.println("\nUsing print(n) to print the rational 16/19 with 30 fractional digits:");
		underOneRational.print(30);
		System.out.println();

		Rational piRational = new Rational(22,7);
		System.out.print("aPi: " + piRational.toString() + " ~ ");
		piRational.print(40);

		// harmonic series example --------------------------------------------------------------------------

		Rational oldHarmonicSeries = new Rational();
		Rational newHarmonicSeries = new Rational();
		Rational newRatio = new Rational();

		System.out.println("\nHarmonic Series:");

		for(int i = 1 ; i <= 10 ; i++)
		{	newRatio.set(1,i);
			newHarmonicSeries = oldHarmonicSeries.add(newRatio);
			System.out.println(newHarmonicSeries.toString() + " ~ " + newHarmonicSeries.toDouble());
			oldHarmonicSeries.set(newHarmonicSeries.getP(), newHarmonicSeries.getQ());
		}
		System.out.println("------------------------------------------------------------------------------");
	}
} // End of RationalApp class. ------------------------------------------------------------------------------
