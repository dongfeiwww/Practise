/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/
public class Solution {
    public String convert(String s, int nRows) {
        int size = s.length();
        int delta = 2*(nRows - 1);
        int k = nRows -1 ;

        StringBuffer res = new StringBuffer("");
        for (int i=0; i<nRows; i++) {
            if (i == 0 || i == nRows - 1) {
                for (int j =i; j<size; j += delta) {
                    res.append(s.charAt(j));
                }
            } else {
                k--;
                for (int j =i; j<size; j += delta) {
                    res.append(s.charAt(j));
                    if (j+k*2 < size)
                        res.append(s.charAt(j + k*2));       
                }
            }  
        }
        
        return res.toString();
    }
}
