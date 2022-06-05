public class Solution {
    // newton style
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x < 1)
            return 0;
        if (x == 1)
            return 1;
            
        int root = 1;
        int mid = x/2;
        
        while (mid * mid > x || mid > 46340) {
            mid = (mid + x/mid)/2;
        }
        return mid;
    }
}

public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(x<0) return -1;
        long x1=(long)x;
        long left=0;
        long right=x1;
        long mid=0;
        while(left<=right){
            mid=left+(right-left)/2;
            if(mid*mid==x1||(mid*mid<x1&&(mid+1)*(mid+1)>x1)) return (int)mid;
            else if(mid*mid<x1) left=mid+1;
            else right=mid-1;
        }
        return (int)mid;
    }
}
