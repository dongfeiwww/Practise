/*
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.
*/
public class Solution {
    public int numDistinct(String S, String T) {
        int n=S.length(); 
        int m=T.length(); 
        if(n==0) return 0; 
        int d[][]=new int [n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                d[i][j]=0; 
                if (S.charAt(i)==T.charAt(j)) {
                    if (j == 0) {
                        d[i][j] += 1; 
                    } else if (i!=0) {
                        d[i][j] += d[i-1][j-1];
                    }
                }

                if (i != 0) 
                    d[i][j]+=d[i-1][j];
            }
        }
        return d[n-1][m-1];
    }
}
