// Fail test cases
// "()(()" 4 2
// )()())()()( 8 4
//可以用stack 和 dp。不过我也是在有提示的情况下做出来的。我本来是hbase的思路。
/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
*/
public class Solution {
    public int longestValidParentheses(String s) {
        int len=s.length();
        int maxLen=0;
        Stack<Integer> inValid=new Stack<Integer>();

        for(int i=0;i<len;i++){
            if (s.charAt(i)=='(') 
                inValid.push(i);
            else {
                if(!inValid.empty()&&s.charAt(inValid.peek())=='(') {
                    inValid.pop();
                    if(inValid.empty()) 
                        maxLen=Math.max(maxLen,i+1);
                    else 
                        maxLen=Math.max(maxLen,i-inValid.peek());
                } else 
                    inValid.push(i);
            }
        }
        return maxLen;
    }
}
/*
public class Solution {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Character> st = new Stack<Character>();
        int no = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                st.push(c);
            
            if (c == ')' ) {
                if (!st.empty() && st.peek() == '(') {
                    no +=2 ;
                    st.pop();
                }
            }
        }
        return no;
    }
}
*/