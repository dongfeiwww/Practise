/*
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
*/
class Solution {
public:
    bool search(int A[], int n, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int l=0, r=n-1;
        
        while(l<=r)
        {
            int m=l+(r-l)/2;
            if(A[m]==target) return true;
            if(A[l]<=A[m])
            {
                while(A[l]==A[m]&&l<m) m--;
                if(target>=A[l]&&target<=A[m])
                r=m;
                else
                l=m+1;
            }
            else if(A[l]>=A[m])
            {
                while(A[l]==A[m]&&m<r) m++;
                if(target<=A[r]&&target>=A[m])
                l=m;
                else
                r=m-1;
            }
        }
        
        return false;
    }
};
