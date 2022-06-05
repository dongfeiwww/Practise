/*
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/
public class Solution {
    public String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String[] roman_digits = new String[]{"", "I", "II", "III", "IV", "V", 
        "VI", "VII", "VIII", "IX"};
        String[] roman_tens = new String[]{"", "X", "XX", "XXX", "XL", "L",     "LX", "LXX", "LXXX", "XC"};
        String[] roman_hundreds = new String[]{"", "C", "CC", "CCC", "CD", "D"    , "DC", "DCC", "DCCC", "CM"};
        String[] roman_thousands = new String[] {"", "M", "MM", "MMM"};
        if (num > 3999)
            return "";
        
        String res = new String();
        res = roman_thousands[num/1000];
        res += roman_hundreds[(num/100)%10];
        res += roman_tens[(num/10)%10];
        res += roman_digits[num%10];
        return res;
    }
}
