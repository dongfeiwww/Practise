import java.util.*; 
public class Solution {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Character> st = new Stack<Character>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{' ) {
                st.push(c);
            }
            
            if (c == ')') {
                if (st.empty() || !st.empty() && st.pop() != '(') return false;
            }
            
            if (c == ']') {
                if (st.empty() || !st.empty() && st.pop() != '[') return false;
            }
            
            if (c == '}') {
                if (st.empty() || !st.empty() && st.pop() != '{') return false;
            }
        }
        if (st.empty())
            return true;
        return false;
    }
}
