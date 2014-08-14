/**
 '?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:

Some examples:
isMatch("aa","a") ? false
isMatch("aa","aa") ? true
isMatch("aaa","aa") ? false
isMatch("aa", "*") ? true
isMatch("aa", "a*") ? true
isMatch("ab", ".*") ? true
isMatch("aab", "c*a*b") ? false

match('abba', 'abba') == true
match('cda', 'adb') == false
match('.*abc', 'abc') == true
match('.*abc', 'ababc') == true
match('.b*a+', 'caaa') == true
match('bb+a*', 'baa') == false

 */
public class WildMatcher {
  // this is for
  //  '?' Matches any single character.
  // '*' Matches any sequence of characters (including the empty sequence).
  public boolean isMatch(String s, String p) {
    s += 'x';
    p += 'x';
    return isMatchHelper(s, 0, p, 0);
  }

  public boolean isMatchHelper(String s, int index1, String p, int index2) {
    if(index1 == s.length() && index2 == p.length())
      return true;
    if(index1 == s.length() || index2 == p.length())
      return false;

    char c1 = s.charAt(index1);
    char c2 = p.charAt(index2);

    if(c2 == '*')
      return isMatchHelper(s, index1, p, index2+1) ||
             isMatchHelper(s, index1+1, p, index2) ||
             isMatchHelper(s, index1+1, p, index2+1);
    else
      return (c1 == c2 || c2 == '.') &&
             isMatchHelper(s, index1+1, p, index2+1);
  }

//  public static void main(String[] args) {
//    WildMatcher match = new WildMatcher();
//    System.out.println(match.isMatch("aba", "a.*"));
//    System.out.println(match.isMatch("aab", "c*a*b"));
//    System.out.println(match.isMatch("aab", "a.*b"));
//    System.out.println(match.isMatch("", "a.*"));
//  }

  public static boolean matches(String pat, String str){
    int patlen = pat.length();
    int strlen = str.length();
    if(patlen == 0) return strlen == 0;

    char patFirst = pat.charAt(0);
    if(patlen == 1 ){
      return strlen == 1 && charsMatch(patFirst, str.charAt(0));
    }

    char patSecond = pat.charAt(1);
    if( patSecond != '+' && patSecond  != '*'){ // just a character
      return strlen > 0 && charsMatch(patFirst, str.charAt(0))
             && matches(pat.substring(1), str.substring(1));
    } else {
      if(patSecond == '*') {
        return (strlen > 0 && charsMatch(str.charAt(0), patFirst) && matches(pat, str.substring(1))
               || matches(pat.substring(2), str));
      } else { // +
        return strlen > 0 && charsMatch(str.charAt(0), patFirst)
               && matches(patFirst +'*' + pat.substring(2), str.substring(1));
      }
    }
  }

  private static boolean charsMatch(char ch1, char ch2) {
    if(ch1 == '.' || ch2 == '.') return true;
    return ch1 == ch2;
  }

  private static void test(String pattern, String str) {
    System.out.println("String " + str+ " matches pattern " + pattern +": " + matches(pattern, str));
  }

  public static void main(String[] args) {
    test("ac*a*ca", "aca");
    test("ac+a*ca", "aca");
    test("ac*a*ca", "acaca");
    test("ac+a*ca", "acaca");
    test("ac+a+ca", "acaca");
    test("ac*a*cab", "acaca");
    test(".+a", "acaca");
    test(".+b", "acaca");
    test(".*world!+", "hello world!!!");
    test(".*woald!+", "hello world!!!");
  }
}
