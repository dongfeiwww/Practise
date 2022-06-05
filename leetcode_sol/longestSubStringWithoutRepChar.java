/*
Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/
// not clear
public class Solution {
    public int lengthOfLongestSubstring(String s) {
          int n = s.length();
          int i = 0, j = 0;
          int maxLen = 0;
          int[] exist = new int[256];

          while (j < n) {
            if (exist[s.charAt(j)] == 1) {
              maxLen = Math.max(maxLen, j-i);

              while (s.charAt(i) != s.charAt(j)) {
                exist[s.charAt(i)] = 0;
                i++;
              }
              i++;
              j++;
            } else {
              exist[s.charAt(j)] = 1;
              j++;
            }
          }

          maxLen = Math.max(maxLen, n-i);
          return maxLen;
    }

}
