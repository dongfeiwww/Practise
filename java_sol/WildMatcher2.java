
public class WildMatcher2 {

  static boolean charMatch(char c1, char c2) {
    if (c1 == '.' || c2 == '.' || (c1 == c2)) return true;
    return false;
  }

  static boolean isMatch(String pattern, String str) {
    int patLen = pattern.length();
    int strLen = str.length();
    if (patLen == 0) return strLen == 0;

    char patFirst = pattern.charAt(0);

    if (strLen > 0 && charMatch(patFirst, str.charAt(0))) {
      if (patLen == 1)
        return strLen == 1;

      char next = pattern.charAt(1);
      if (next == '*') {
        return isMatch(pattern, str.substring(1)) || isMatch(pattern.substring(2), str);
      } else if (next == '+') {
        return isMatch(patFirst +'*' + pattern.substring(2), str.substring(1));
      } else { // other char
        return isMatch(pattern.substring(1), str.substring(1));
      }
    } else {
      return false;
    }
  }

  private static void test(String pattern, String str) {
    System.out.println("String '" + str+ "' matches pattern '" + pattern +"': " + isMatch(pattern, str));
  }

  public static void main(String[] args) {
    test("a.*abc", "aabc");
    test(".+b", "acaca");
  }
}
