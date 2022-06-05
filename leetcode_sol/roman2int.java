/*
Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.
*/
public class Solution {
    int map(char c)
    {
        switch (c)
        {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }   
    }
    
    public int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int res = 0,prev = 1001,curr = 0;
        int len = s.length();
        for(int i=0; i<len; i++) {
            curr = map(s.charAt(i));
            if (curr<=prev)
                res += curr;
            else {
                res += curr;
                res -= 2*prev;
            }
            prev = curr; //Re-initialize the previous
        }
        return res;
    }
}
