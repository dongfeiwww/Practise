/*
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
*/
(1)递归：大数据超时
C++:
class Solution {
public:
    bool isMatch(const char *s, const char *p) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(s==NULL&&p==NULL) return true;
        if(s==NULL||p==NULL) return false;
        if(*p=='?'){
            if(*s=='\0') return false;
            else return isMatch(s+1,p+1);
        }else if(*p=='*'){
            while(*s!='\0'){
                if(isMatch(s,p+1)) break;
                s++;
            }
            if(*s!='\0') return true;
            else return isMatch(s,p+1);
        }else{
            if(*s==*p){
                if(*s=='\0') return true;
                else return isMatch(s+1,p+1);
            }else return false;
        }
    }
};
(2)非递归
C++:
class Solution {
public:
    bool isMatch(const char *s, const char *p) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        const char *ss=s;
        const char *pp=p;
        bool flag=false;
        for(;*ss!='\0';ss++,pp++){
            switch(*pp){
                case '?':
                    break;
                case '*':
                    flag=true;
                    s=ss;
                    p=pp;
                    while(*p=='*') p++;
                    ss=ss-1;
                    pp=p-1;
                    break;
                default:
                    if(*ss!=*pp){
                        if(!flag) return false;
                        s++;
                        ss=s-1;
                        pp=p-1;
                    }
                    break;
            }
        }
        while(*pp=='*') pp++;
        return (!*pp);
    }
};
