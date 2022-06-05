/*
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
*/
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m=s1.length(); 
        int n=s2.length(); 
        int k=s3.length();
        if(k!=(n+m)) return false; 
        boolean S[][]=new boolean[m+1][n+1];
        S[0][0]=true; 
        for(int i=0; i<m; i++)
        {
            if(s1.charAt(i)==s3.charAt(i)) S[i+1][0]=true; else break; 
        }
        for(int j=0; j<n; j++)
        {
            if(s2.charAt(j)==s3.charAt(j)) S[0][j+1]=true; else break; 
        }
        for(int i=1;i<=m;++i)
        {
            for(int j=1;j<=n;++j)
                S[i][j]=(S[i][j-1]&&s3.charAt(i+j-1)==s2.charAt(j-1))
                      ||(S[i-1][j]&&s3.charAt(i+j-1)==s1.charAt(i-1));
         }
        return S[m][n];
    }
}
