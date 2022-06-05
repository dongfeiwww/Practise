/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/
import java.util.ArrayList;
public class Solution {
    void fun (String str , int open , int closed , int n, ArrayList<String> res) {
        if (closed > open ) return ;
        if (closed > n || open>n ) return ;
        if (str.length() == 2*n) res.add(str);
        fun (str + '(' , open+1 , closed , n, res ) ; p
        fun ( str + ')' , open , closed+1 , n, res ) ; 
    }

    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res = new ArrayList<String>();
        String s = "(";
        fun(s, 1, 0, n, res);
        return res;
    }
}
