public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length();
        if (len < 1)
            return 0;
        if (s.charAt(0) == '0')
            return 0;
        if (len == 1)
            return 1;
        char c1 = s.charAt(0);
        char c2 = s.charAt(1);
        
        if (c1 > '2' && c1 <= '9')
            return numDecodings(s.substring(1, s.length() -1));
        else if (c1 == '0')
            return 0;
        else if (c1 == '1' ) {
            if (c2 == '0') 
                return numDecodings(s.substring(2, s.length() -1));
            else
                return numDecodings(s.substring(2, s.length() -1)) + 1;
                      
        } else {
            if (c2 == '0' || c2 > '6')
                return numDecodings(s.substring(2, s.length() -1));
            else
                return numDecodings(s.substring(2, s.length() -1)) + 1;
        }
    }
}
