/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 
For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
 
Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.
 
For the purpose of this problem, we define empty string as valid palindrome.
*/
public class ValidPalindrome {
  public boolean isPalindrome(String s) {
    // Start typing your Java solution below
    // DO NOT write main() function
    if (s.length() < 1)
      return false;
    s = s.toLowerCase();
    int i = 0;
    int j = s.length()-1;
    while (i <= j) {
      if (!Character.isLetterOrDigit(s.charAt(i))) {
        i++;
        continue;
      }
      if (!Character.isLetterOrDigit(s.charAt(j))) {
        j--;
        continue;
      }
      if (s.charAt(i) != s.charAt(j))
        return false;
      else {
        i++;
        j--;
      }
    }
    return true;
  }
  //test
  public static void main(String[] args) {
    System.out.println(new ValidPalindrome().isPalindrome("1a2"));
  }
 
}
