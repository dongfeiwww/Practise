// Time limit exceeded on large data sets
// http://dl.dropbox.com/u/19732851/LeetCode/DivideTwoIntegers.html
public class Divide {
  public int divide(int dividend, int divisor) {
    if (divisor == 1)
      return dividend;
    if (divisor == dividend)
      return 1;
    int sign = -1; 
    if (dividend > 0 && divisor > 0 
        || (dividend < 0 && divisor < 0 ))
      sign = 1;

    long div = dividend > 0 ? dividend: -dividend;
    if (dividend == Integer.MIN_VALUE){
      div = (long)Integer.MAX_VALUE + 1;
    }

    if (divisor < 0)
      divisor = -divisor;
    int times = 0;

    while (div >= divisor ) { 
      long x, y;
      for (x = divisor, y = 1; div - x >= x; x += x, y += y); 
      times += y;
      div -= x;
    }   

    return times*sign;
  }

  public static void main(String[] args) {
    Divide p = new Divide();
    System.out.println(p.divide(-2147483648, 2));
  }
}