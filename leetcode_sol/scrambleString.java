/*
Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
*/
// c++
public class Solution {
    boolean isScramble(String s1, String s2) {
        
        int len = s1.length();
        if (len != s2.length()) return false;
        vector<vector<vector<bool> > > F(len + 1, vector<vector<bool> > (len, vector<bool>(len, false)));
        for (int i = 0; i < len; i++)
            for (int j = 0; j < len; j++)
                if (s1[i] == s2[j]) F[1][i][j] = true;
              
        for (int l = 2; l <= len; l++)
            for (int i = 0; i < len - l + 1; i++)
                for (int j = 0; j < len - l + 1; j++)
                    for (int k = 1; k < l; k++)
                    {
                        F[l][i][j] = F[k][i][j] && F[l - k][i + k][j + k] || F[k][i][j + l - k] && F[l - k][i + k][j];
                        if (F[l][i][j]) break;
                    }
        return F[len][0][0];
    }
};
