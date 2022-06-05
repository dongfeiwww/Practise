/*
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
*/
public class Solution {
    public boolean isNumber(String s) {
        if(s==null||s.length()==0) return false;
        char[] c=s.toCharArray();
        int begin=0;
        int end=c.length-1;

        while(begin<=end&&c[begin]==' ') begin++;
        while(end>=0&&c[end]==' ') end--;
        if(begin>end) 
            return false;
        int index=begin;

        while(index<=end) {
            if(c[index]=='e'||c[index]=='E') return isDecimal(c,begin,index-1)&&isInteger(c,index+1,end);
            index++;
        }

        return isDecimal(c,begin,end);
    }

    public boolean isDecimal(char[] c,int begin,int end){
        if(begin<=end){
            int index=begin;
            boolean hasDigit=false;
            boolean hasDot=false;
            if(c[index]=='+'||c[index]=='-') index++;
            while(index<=end){
                if(c[index]>='0'&&c[index]<='9') hasDigit=true;
                else if(!hasDot&&c[index]=='.') hasDot=true;
                else return false;
                index++;
            }
            return hasDigit;
        }
        return false;
    }
    
    public boolean isInteger(char[] c,int begin,int end){
        if(begin<=end){
            int index=begin;
            boolean hasDigit=false;
            if(c[index]=='+'||c[index]=='-') index++;
            while(index<=end){
                if(c[index]>='0'&&c[index]<='9') hasDigit=true;
                else return false;
                index++;
            }
            return hasDigit;
 
        }
        return false;
    }
}

// class Solution:
//     def isNumber(self, s: str) -> bool:
//         seen_digit = seen_exponent = seen_dot =  False
//         for i, c in enumerate(s):
//             if c.isdigit():
//                 seen_digit = True
//             elif c in ["+", "-"]:
//                 if i > 0 and s[i - 1] != "e" and s[i - 1] != "E":
//                     return False
//             elif c in ["e", "E"]:
//                 if seen_exponent or not seen_digit:
//                     return False
//                 seen_exponent = True
//                 seen_digit = False
//             elif c == ".":
//                 if seen_dot or seen_exponent:
//                     return False
//                 seen_dot = True
//             else:
//                 return False
        
//         return seen_digit
