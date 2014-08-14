
public class Test {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    BigNumber b1 = new BigNumber();
    b1.digits = "1234";
    BigNumber b2 = new BigNumber();
    b2.digits = "999.773444";

    System.out.println(sum(b1, b2).digits);
  }

  public static BigNumber sum(BigNumber b1, BigNumber b2) {
    if (b1 == null || b2 == null) return null;
    BigNumber result = new BigNumber();

    int posIndex1,  posIndex2, decIndex1=0, decIndex2=0;
    int sep1 = b1.digits.indexOf('.');
    if (sep1 != -1) {
      posIndex1 = sep1-1;
      decIndex1 = sep1+1;
    }
    else {
      posIndex1 = b1.digits.length() -1;
    }

    int sep2 = b2.digits.indexOf('.');
    if (sep2 != -1) {
      posIndex2 = sep2-1;
      decIndex2 = sep2+1;
    } else {
      posIndex2 = b2.digits.length() -1;
    }
    boolean decimals = false;
    String decResult = "";
    int carry = 0;

    // for decimal computing
   // System.out.println("decIndex1:" + decIndex1 + " decIndex2:" + decIndex2);
    if (decIndex1 >0 || decIndex2 >0) {
      decimals = true;

      String decString1 = decIndex1>0?b1.digits.substring(decIndex1): "0";
      String decString2 = decIndex2>0?b2.digits.substring(decIndex2): "0";

      if (decString1.length() > decString2.length()) {
        while (decString1.length() > decString2.length())
          decString2 += "0";
      } else if (decString1.length() < decString2.length()) {
        while (decString1.length() < decString2.length())
          decString1 += "0";
      }

      decResult = computeAddWithoutDecimal(decString1, decString2, 0);
      System.out.println("decString1:" + decString1 + " decString2:" + decString2 + " decResult:" + decResult);
      if (decResult.length() > decString1.length()) {
        decResult = decResult.substring(1);
        carry = 1;
      }
    }

    // for positive computing
    String posResult = computeAddWithoutDecimal(b1.digits.substring(0, posIndex1+1),
                                                b2.digits.substring(0, posIndex2+1),
                                                carry);

    result.digits = decimals? posResult + "." + decResult: posResult;
    return result;
  }

  private static String computeAddWithoutDecimal(String s1, String s2, int carry) {
    StringBuffer sb= new StringBuffer();
    int posIndex1,  posIndex2;
    posIndex1 = s1.length() -1;
    posIndex2 = s2.length() -1;
    while (posIndex1>=0 || posIndex2>=0) {
      int current =0;
      if (posIndex1>=0) current += (s1.charAt(posIndex1--) - '0');
      if (posIndex2>=0) current += (s2.charAt(posIndex2--) - '0');

      current = current + carry;
      carry = current/10;
      current = current%10;

     // System.out.println("current:" + current + " carry:" + carry);
      sb.append(current);
    }

    if (carry > 0)
      sb.append(carry);

    return sb.reverse().toString();
  }

}

class BigNumber {
  String digits;
}

// 1234.567
//  999.123
// 2233.5

