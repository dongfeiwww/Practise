/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

*/

public class Solution {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if ( n == 1)
            return "1";
        String s = "1";
        for (int k = 2; k <= n; k++) {
            String temp  = "";
            
            int count = 1;
            char num = s.charAt(0);
            int size = s.length();
            for (int i = 0; i<size - 1; i++) {
                if (s.charAt(i) == s.charAt(i+1)) {
                  count++;  
                } else{
                    temp += count + "" + num;
                    count = 1;
                    num = s.charAt(i+1);
                }
                
            }
            temp += count + "" + num;
            s = temp;
        }
        return s;
    }
}
