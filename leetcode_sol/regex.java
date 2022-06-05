/*
 * "aa", "a"    true    false   
"aa", "aa"  true    true    
"aaa", "aa" true    false   
"aa", "a*"  true    true    
"aa", ".*"  true    true    
"ab", ".*"  true    true    
"aab", "c*a*b"  true    true    
"aaa", "aaa"    true    true    
"aaa", "aa" true    false   
"aaa", "aaaa"   true    false   
"aaa", "a.a"    true    true    
"aaa", ".a" true    false   
"aaa", "a*a"    true    true    
"aaa", "ab*a"   true    false   
"aaa", "ab*ac*a"    true    true    
"aaa", "ab*a*c*a"   true    true    
"aaca", "ab*a*c*a"  true    true    
"aaba", "ab*a*c*a"  true    false   
"aaa", ".*" true    true    
"aa", "."   true    false   
"a", "."    true    true    
"a", "ab*"  true    true    
"a", "ab*a" true    false   
"bbbba", ".*a*a"    true    true    
"ab", ".*"  true    true    
"a", ".*"   true    true    
"", ".*"    true    true    
"", "." true    false   
"a", "."    true    true    
"", "c*"    true    true    
"a", "a."   true    false   
"a", "" false   false   
"", ""  true    true    
"aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s" true    true    
"abbbcd", "ab*bbbcd"    true    true    
"abcdede", "ab.*de"
 */
/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/
// runtime error
public class Regex {
        public boolean isMatch(String s, String p) {
            // Start typing your Java solution below
            // DO NOT write main() function
            if (p.isEmpty()) {
                return s.isEmpty();
            }
            // next char is not '*': must match current character
            if (p.length() == 1 || (p.length() > 1 && p.charAt(1) != '*')) {
                return ((p.charAt(0) == s.charAt(0)) || 
                (p.charAt(0) == '.' && !s.isEmpty())) && 
                isMatch(s.substring(1), p.substring(1));
            }
            // next char is '*'
           while ((s.length() > 0 && p.charAt(0) == s.charAt(0)) || 
                (p.charAt(0) == '.' && !s.isEmpty())) {
                if (isMatch(s, p.substring(2))) {
                    return true;
                }
                s = s.substring(1);
            }
            return isMatch(s, p.substring(2));
        }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Regex p = new Regex();
        System.out.println(p.isMatch("aa", "a*"));
        System.out.println(p.isMatch("aa", ".*"));
        System.out.println(p.isMatch("ab", ".*"));
        System.out.println(p.isMatch("abb", "c*a*b"));
    }

}

class Solution {
public:
    bool isMatch(const char *s, const char *p) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function    
        if(*p=='\0') return *s=='\0';
        if(*(p+1)!='*')
            return ((*s==*p)||(*s!='\0'&&*p=='.'))&&isMatch(s+1,p+1);
        while((*s==*p)||(*s!='\0'&&*p=='.')){
            if(isMatch(s,p+2)) break;
            s++;
        }
        return isMatch(s,p+2);
    }
};
