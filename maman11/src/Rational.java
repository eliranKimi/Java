

public class Rational {
	
	private int deno; // Denominator
	private int num; // Numerator 
	
	
	public Rational(int num, int den) {
		super();
		if( den > 0 || num >= 0  )
		{
			this.deno = den;
			this.num = num;
		}
		else
		{
			this.deno=0;
			this.num=0;
			
		
		}
		
		
	}
	

	public int getDenominator() {
		return deno;
	}

	public void setDenominatoro(int deno) {
		this.deno = deno;
	}

	public int getNumerator() {
		return num;
	}

	public void setNumerator(int num) {
		this.num = num;
	}
	
	public Boolean greaterThan( Rational number )
	{
		if( this.getNumerator() * number.getDenominator() > this.getDenominator() * number.getNumerator() )
		{
			return true;
		}
		
		return false;
		
	}
	
	// Check how to override
	public Boolean equals(Rational number)
	{
		
		if( this.getNumerator() * number.getDenominator() ==  this.getDenominator() * number.getNumerator() )
		{
			return true;
		}
		
		return false;
		
		
	}
	
	public Rational plus(Rational number)
	{
		Rational sum;
		int den;
		int num;
		
		den=this.getDenominator()+number.getDenominator();
		num=this.getNumerator() * number.getDenominator() + this.getDenominator() * number.getNumerator();
		
		sum=new Rational(den,num);
		
		return sum;
	}

	public Rational minus(Rational number)
	{
		Rational sum;
		int den;
		int num;
		
		den=this.getDenominator()+number.getDenominator();
		num=this.getNumerator() * number.getDenominator() - this.getDenominator() * number.getNumerator();
		
		sum=new Rational(den,num);
		
		return sum;
	}

	public Rational multiply(Rational number)
	{
		Rational result;
		int num=this.getNumerator()*number.getNumerator();
		int den=this.getDenominator()* number.getDenominator();
		result=new Rational(den,num);
		return result;
	}
	
	public String toString()
	{
		return this.getNumerator()+"/"+this.getDenominator();
		
	}
	
	private int gcd(int x, int y)
	{
		if ( y !=0 )
		{
			return this.gcd(y, x%y);
		}
		else
		{
			return x;
		}

	}
	
	public Rational reduce()
	{ 
		Rational number;
		int divider=this.gcd(this.getDenominator(), this.getNumerator());
		number = new Rational(this.getDenominator()/divider,this.getNumerator()/divider);
		
		return number;
		
	}

	public Boolean isZeroed()
	{
		if ( this.getNumerator() == 0 && this.getDenominator() == 0 )
		{
			return true;
		}
		else
		{
			return false;
		}

	}
}
