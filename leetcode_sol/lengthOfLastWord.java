/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
*/
public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s==null||s.length()==0) return 0;
        boolean flag=true;
        int len=0;
        for(int i=0;i<s.length();i++){
            if(flag==true&&s.charAt(i)!=' ') len++;
            if(s.charAt(i)==' ') flag=false;
            if(flag==false&&s.charAt(i)!=' '){
                len=1;
                flag=true;
            }
        }
        return len;
    }
}
public class Solution {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = s.length();
        int i = len-1;
        while (i >=0) {
            if (s.charAt(i) == ' ')
                i--;
            else
                break;
        }
        
        if (i<0)
            return 0;
        
        int index = i;
        while (index >= 0) {
            if (s.charAt(index) != ' ')
                index--;
            else
                break;
            
        }
        return i - index;
    }
}
