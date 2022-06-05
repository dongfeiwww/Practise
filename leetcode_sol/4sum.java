/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
*/
import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);

        int i = 0;
        int z = 1;
        int j ;
        int k ;
        Set set = new HashSet();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num.length < 4)
            return res;

        for (i=0; i < num.length - 3; i++) {
            for (z=i+1; z < num.length - 2; z++) {
                int left = target -(num[i] + num[z]);
                j = z+1;
                k = num.length - 1;
                while (j<k) {
                    if (num[j] + num[k] == left) {
                        ArrayList<Integer> sol = new ArrayList<Integer>();                    
                        sol.add(num[i]);
                        sol.add(num[z]);
                        sol.add(num[j]);
                        sol.add(num[k]);
                        if (set.add(sol))
                            res.add(sol);
                        j++;
                        k--;
                    } else if (num[j] + num[k] < left) {
                        j++;

                    } else
                        k--;
                }
            }
        }
        return res;
    }
}
