///////////////////////////////////////////////////////////////////////////////////////////////////
//	Name:			Mark Barros
//	Course:			CS1400 - Intro to Programming and Problem Solving
//	Description:	This program creates a Rational Number class. The numerator and denominator
//					are both of the int data type. The class contains constructors, mutators,
//					accessors, and other methods.
///////////////////////////////////////////////////////////////////////////////////////////////////

// This is a required import. ---------------------------------------------------------------------
import java.lang.StringBuilder;

// This is the Rational class. --------------------------------------------------------------------
public class Rational
{
	// fields -------------------------------------------------------------------------------------
	private int p; // numerator
	private int q; // denominator
	// constructors -------------------------------------------------------------------------------
	public Rational()
	{
		this(0,1);
	}
	// ------------------------------------------------------------------------------------
	public Rational(int p, int q)
	{
		set(p, q);
	}
	// ------------------------------------------------------------------------------------
	public Rational(int n)
	{
		set(n,1);
	}
	// accessors ----------------------------------------------------------------------------------
	public int getP()
	{
		return p;
	}
	// ------------------------------------------------------------------------------------
	public int getQ()
	{
		return q;
	}
	// ------------------------------------------------------------------------------------
	public Rational getRational()
	{
		return new Rational(p, q);
	}
	// mutators  ----------------------------------------------------------------------------------
	public void set(int p, int q)
	{
		if(q  == 0)
		{
			throw new RuntimeException("The denonimator cannot be zero!");
		}
		this.p = p;
		this.q = q;
	}
	// operations ---------------------------------------------------------------------------------
	public Rational add(Rational rhs)
	{
		int lcm, newP1, newP2;

		lcm = findLCM(q, rhs.getQ());
		newP1 = p * (lcm / q);
		newP2 = rhs.getP() * (lcm / rhs.getQ());

		return new Rational(newP1 + newP2, lcm);
	}
	// ------------------------------------------------------------------------------------
	public Rational subtract(Rational rhs)
	{
		int lcm, newP1, newP2;

		lcm = findLCM(q, rhs.getQ());
		newP1 = p * (lcm / q);
		newP2 = rhs.getP() * (lcm / rhs.getQ());

		return new Rational(newP1 - newP2, lcm);
	}
	// ------------------------------------------------------------------------------------
	public Rational multiply(Rational rhs)
	{
		return new Rational(p * rhs.p, q * rhs.q);
	}
	// ------------------------------------------------------------------------------------
	public Rational divide(Rational rhs)
	{
		return new Rational(p * rhs.q, q * rhs.p);
	}
	// other methods ------------------------------------------------------------------------------
	@Override
	public String toString()
	{
		return  p + "/" + q;
	}
	// ------------------------------------------------------------------------------------
	public double toDouble()
	{
		return (double)p / q;
	}
	// ------------------------------------------------------------------------------------
	public boolean equals(Rational rhs)
	{
		return p * rhs.q == q * rhs.p;
	}
	// ------------------------------------------------------------------------------------
	public void print(int n)
	{
		StringBuilder decimalOutput = new StringBuilder();
		int dividend = p;
		int divisor = q;

		if(dividend > divisor) // if the dividend is greater than the divisor
		{
			decimalOutput.append(dividend/divisor);
			decimalOutput.append(".");
		}
		else // if the divisor is greater than the dividend
		{
			decimalOutput.append("0.");
		}

		dividend = 10 * (dividend % divisor);

		for(int digits = 1; digits <= n; digits++)
		{
			decimalOutput.append(dividend/divisor);
			dividend = 10 * (dividend % divisor);
		}

		System.out.println(decimalOutput);
	}
	// ------------------------------------------------------------------------------------
	private int findLCM(int q1, int q2)
	{
		int lcm = (q1 > q2) ? q1 : q2;
		while(true)
		{
			if(lcm % q1 == 0 && lcm % q2 == 0) return lcm;
			++lcm;
		}
	}
} // End of Rational class. -----------------------------------------------------------------------
