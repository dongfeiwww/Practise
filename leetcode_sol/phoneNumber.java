// runing time error
/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
*/
// public class Solution {
//     public ArrayList<String> letterCombinations(String digits) {
//         // Start typing your Java solution below
//         // DO NOT write main() function
//         ArrayList<String> ret=new ArrayList<String>();
//         String[] map={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
//         solve(0,digits.length(),ret,map,digits,"");
//         return ret;
//     }

//     public void solve(int dep,int maxDep,ArrayList<String> ret,String[] map,String digits,String cur){
//         if(dep==maxDep){
//             ret.add(cur);
//             return;
//         }
//         for(int i=0;i<map[digits.charAt(dep)-'0'-2].length();i++)
//             solve(dep+1,maxDep,ret,map,digits,cur+map[digits.charAt(dep)-'0'-2].charAt(i));
//     }
// }

import java.util.ArrayList;
public class PhoneNumber {
        public static String[] c = new String[]{
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        public void phone_numbers(String digits, StringBuffer sb, int cur, ArrayList<String> letters) {
            int digit = digits.charAt(cur)-'0';
            int len = c[digit].length();
            for (int i=0; i< len; i++) {
                sb.append(c[digit].charAt(i));
                if (cur == digits.length() -1) {
                    letters.add(sb.toString());
                } else {
                    phone_numbers(digits, sb, cur+1, letters); 
                }
                sb.deleteCharAt(cur);
            }
        }

        public ArrayList<String> letterCombinations(String digits) {
            // Start typing your Java solution below
            // DO NOT write main() function
            ArrayList<String> letters = new ArrayList<String>();
            if (digits.length() < 1) {
                letters.add("");
                return letters;
            }
            StringBuffer res = new StringBuffer();
            phone_numbers(digits, res, 0, letters);
            return letters;
        }

        public static void main(String[] args) {
            String[] strs = new String[4];
            PhoneNumber p = new PhoneNumber();
            strs[0] = "";
            strs[1] = "abefg";
            strs[2] = "abeee";
            strs[3] = "abcd";
            ArrayList<String> r = new ArrayList<String>();
            r = p.letterCombinations("23");
            for (String s: r)
                System.out.println(s);
        }
}

