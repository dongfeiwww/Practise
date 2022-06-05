/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)

2 pointers
*/
import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
            
        int j ;
        int k ;
        Set set = new HashSet();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num.length < 3)
            return res;

        for(int i=0; i < num.length - 2; i++) {
            int target = -num[i];
            j = i+1;
            k = num.length - 1;
            while (j<k) {
                if (num[j] + num[k] == target) {
                    ArrayList<Integer> sol = new ArrayList<Integer>();
                    sol.add(num[i]);
                    sol.add(num[j]);
                    sol.add(num[k]);
                    if (set.add(sol))
                        res.add(sol);
                    j++;
                    k--;
                } else if (num[j] + num[k] < target) {
                    j++;
                
                } else 
                    k--;
            }
        }
        return res;
    }
}
