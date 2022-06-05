/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/
public class Solution {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int begin = 0;
        int end = A.length - 1;
        while (begin <= end) {
            int mid = begin + (end-begin)/2;
            if (A[mid] == target) return mid;
            if (A[mid] > target)
                end = mid -1;
            else
                begin = mid +1;
        }
        if (end == -1)
            return 0;

        if (A[end] < target)
            return end + 1;
        else
            return end;
    }
}
