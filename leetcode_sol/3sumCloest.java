/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.
    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/
import java.util.*;
public class Solution {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
            
        int i = 0;
        int j ;
        int k ;
        
        if (num.length < 3)
            return 0;
        int min = Math.abs(num[0] + num[1] + num[2] - target);
        int res = num[0] + num[1] + num[2] ;
        while (i < num.length) {
            int left = target -num[i];
            j = i+1;
            k = num.length - 1;
            while (j<k) {
                if (num[j] + num[k] == left) {
                    return target;
                } else if (num[j] + num[k] < left) {
                    if (left - (num[j] + num[k]) < min) {
                        min = left - (num[j] + num[k]);
                        res = num[i] + num[j] + num[k];
                    }
                    j++;
                } else {
                    if ((num[j] + num[k]) - left < min) {
                        min = (num[j] + num[k]) - left ;
                        res = num[i] + num[j] + num[k];
                    }
                    k--;
                }
            }
            
            i++;
        }
        return res;
    }
}
