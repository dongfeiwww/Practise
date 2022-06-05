/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
*/
public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int res = 0;
        int sign = 1;
        if (x<0) {
            x = -x;
            sign = -1;
        }
            
        while(x!=0) {
            res = res*10 + x%10;
            x /=10;
        }
        return res*sign;
    }
}
