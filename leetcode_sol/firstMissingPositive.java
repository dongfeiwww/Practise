/*
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/
public class Solution {
    public int firstMissingPositive(int[] A) {
        for (int i = 0; i < A.length; i++) {
            while (A[i] > 0 && A[i] <= A.length && A[i] != (i+1)) {
                // swap two pointers
                int tmp = A[A[i]-1];
                if (tmp == A[i]) {
                    break;
                }
                A[A[i]-1] = A[i];
                A[i] = tmp;
            }
        }

        for (int i = 0; i < A.length; i ++) {
                if (A[i] != i + 1) {
                    return i + 1;
                }
        }

        return A.length + 1;
    }
}

// class Solution:
//     def firstMissingPositive(self, nums: List[int]) -> int:
//         i = 0
//         n = len(nums)
//         while i < n:
//             j = nums[i] - 1
//             # put num[i] to the correct place if nums[i] in the range [1, n]
//             if 0 <= j < n and nums[i] != nums[j]:
//                 nums[i], nums[j] = nums[j], nums[i]
//             else:
//                 i += 1
//         # so far, all the integers that could find their own correct place 
//         # have been put to the correct place, next thing is to find out the
//         # place that occupied wrongly
//         for i in range(n):
//             if nums[i] != i + 1:
//                 return i + 1
//         return n + 1