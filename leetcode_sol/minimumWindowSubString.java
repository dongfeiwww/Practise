/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
https://gist.github.com/luoxiaoxun/5828204
*/
public class Solution {
    public String minWindow(String S, String T) {
        int [] map = new int[128];
        for (char c : t.toCharArray()) {
          map[c]++;
        }
        
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        
        while (end < s.length()) {
          final char c1 = s.charAt(end);
          if (map[c1] > 0) 
            counter--;
          map[c1]--;
          end++;
          while (counter == 0) {
            if (minLen > end - start) {
              minLen = end - start;
              minStart = start;
            }
            final char c2 = s.charAt(start);
            map[c2]++;
            if (map[c2] > 0) counter++;
            start++;
          }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
