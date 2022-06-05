public class Solution {
    public int minCut(String s) {
        int len = s.length();
        if(len==0) return 0; 
        int [] dp=new int [len+1];
        for(int i=len; i>=0; i--){
            dp[i]=len-i;
        }
        boolean [][]palindrome=new boolean [len][len];
        for(int i=len-1; i>=0 ; i--) {
            for(int j=i; j<len; j++) {
                if(s.charAt(i)==s.charAt(j) && (j-i<2|| palindrome[i+1][j-1]))
                {
                    palindrome[i][j]=true;
                    dp[i]=Math.min(dp[i], 1+dp[j+1]);
                }
            }
        }
        return dp[0]-1;
    }
}
