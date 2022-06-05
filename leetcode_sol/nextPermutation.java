/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

// class Solution:
//     def nextPermutation(self, nums: List[int]) -> None:
//         n = len(nums)
//         i = n - 2
//         while i >= 0:
//             if nums[i] >= nums[i + 1]:
//                 i -= 1
//             else:
//                 for j in range(n - 1, i, -1):
//                     if nums[j] > nums[i]:
//                         nums[i], nums[j] = nums[j], nums[i]
//                         nums[i + 1:] = nums[i + 1:][::-1]
//                         return
//         nums.reverse()

public class Solution {
    public void swap(int[] num, int i, int j) {
        int t = num[i];
        num[i] = num[j];
        num[j] = t;
    }
    
    public void reverse(int[] num, int start) {
        int n = num.length;
        for (int i = 0; i<(n-start)/2; i++) 
            swap(num, i+start, n-i-1);
    }
    
    public void nextPermutation(int[] num) {
        int n = num.length;
        int x1 = n - 2;
        while (x1 >= 0 && num[x1] >= num[x1+1]) --x1;
        if (x1 == -1) {
            reverse(num, 0);
            return ;
        }
        
        int x2 = n-1;
        while (num[x2] <= num[x1]) --x2;
        swap(num, x1, x2);
        reverse(num, x1+1);
    }
}