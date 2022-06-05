/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].
*/

public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int size = A.length;
        if (size <= 1)
            return size;
        int fast = 1;
        int slow = 0;
        int dup = 0;
        while ( fast < size) {
            if (A[slow] != A[fast]) {
                A[slow+1] = A[fast];
                slow++;
                dup = 0;
            } else{
                dup++;
                if (dup < 2) {
                    A[slow+1] = A[fast];
                    slow++;
                }
            }
            fast++;
        }
        return slow+1;
    }
}

public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n=A.length;
        if(n==0||n==1) return n;
        int min=A[0]-1;
        int cur=A[0];
        int count=0;
        for(int i=0;i<n;i++){
            if(A[i]==cur){
                count++;
                if(count>2) A[i]=min;
            }else{
                count=1;
                cur=A[i];
            }
        }
        int index=0;
        for(int i=0;i<n;i++)
            if(A[i]!=min)
                A[index++]=A[i];
        return index;
    }
}
