// [3,1], 1
public class Solution {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int begin = 0;
        int end = A.length - 1;
        while (begin <= end) {
            int mid = begin + (end-begin) /2;
            if (A[mid] == target) return mid;
//因为取得 mid 是 lower middle. 这在只有两个元素的时候，而你要找的元素是 upper middle，就被错过了。
            if (A[begin] <= A[mid]) {
                if (A[begin] <= target && target < A[mid]) {
                    end = mid -1;
                } else
                    begin = mid + 1;
                
            } else {
                if (A[mid] < target && target <= A[end]) {
                    begin = mid + 1;
                } else 
                    end = mid -1;
            }
        }
        
        return -1;
    }
}
