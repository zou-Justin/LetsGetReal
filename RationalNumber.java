public class RationalNumber extends RealNumber
{
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *  If the denominator is negative, negate both numerator and denominator
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    super(0.0);//this value is ignored!
    if (deno == 0){
      numerator = 0;
      denominator = 1;
    }
    else if (deno < 0){
      numerator = nume * -1;
      denominator = deno * -1;
      reduce();
    }
    else{
    numerator = nume;
    denominator = deno;
    reduce();
    }
  }

  public double getValue(){
    return (double)numerator/denominator;
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
   RationalNumber a = new RationalNumber(denominator,numerator);
   return a;
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    return numerator == other.getNumerator() && denominator == other.getDenominator();
  }


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    return (numerator + "/" + denominator);
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    int largest = 1;
    for (int i = 1; i <= Math.min(a,b);i++){
        if (a % i == 0 && b % i == 0){
          largest = i;
        }
      }
    return largest;
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    int GCD1 = gcd(numerator,denominator);
    numerator = numerator / GCD1;
    denominator = denominator / GCD1;
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    RationalNumber e = new RationalNumber(other.getNumerator() * numerator,other.getDenominator() * denominator) ;
    reduce();
    return e;
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    reduce();
    RationalNumber a = new RationalNumber(other.getDenominator() * numerator,other.getNumerator() * denominator);
    return a;
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    RationalNumber b = new RationalNumber(other.getNumerator() * denominator + numerator * other.getDenominator(),other.getDenominator() * denominator) ;
    reduce();
    return b;
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    RationalNumber c = new RationalNumber(numerator * other.getDenominator() - other.getNumerator() * denominator,other.getDenominator() * denominator) ;
    reduce();
    return c;
  }
}
