/*
Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/
import java.util.HashMap;
import java.util.Map;
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int size = numbers.length;
        int[] res = new int[2];
        if (size < 1) {
            res[0] = 0;
            res[1] = 0;
            return res;
        }
        
        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        for (int i =0; i< size; i++) {
            if(numMap.containsKey(target - numbers[i])) {
                res[0] = numMap.get(target - numbers[i]);
                res[1] = i+1;
                return res;
            } else {
                numMap.put(numbers[i], i+1);
            }
        }
        return res;
    }
}
