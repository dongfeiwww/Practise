/*
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/
public class Solution {
    public int climbStairs(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        int one=1;
        int two=0;
        int result=0;
        for(int i=1;i<=n;i++){
            result =one+two;
            two =one;
            one =result;
        }
        return result;
    }
}
