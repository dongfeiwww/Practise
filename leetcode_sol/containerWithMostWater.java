// runtime error
/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
*/
public class Solution {
    public int maxArea(int[] height) {
        int low=0;
        int high=height.length-1;
        int ret=0;

        while (low < high){
            int area=(high-low)*Math.min(height[low],height[high]);
            ret = Math.max(ret, area);
            if (height[low]<=height[high]) 
              low++;
            else 
              high--;
        }
        return ret;
    }
}

public class Solution1 {
  class StackItem
  {
    int value;
    int index;
  };

  public int maxArea(int[] height) {
    int i;
    int m = -1;
    int top = -1;
    int left = -1;
    int n = height.length;
    StackItem[] st = new StackItem[n];

    for(i=0; i<n; i++) {
      while(top >= 0 && (i==n || height[i] < st[top].value)) {
        if (top > 0)
          left = st[top-1].index;
        else
          left = -1;
        m = Math.max(m, (i - 1 - left)*(st[top].value));
        --top;
      }
      if (i < n) {
        ++top;
        st[top].value = height[i];
        st[top].index = i;
      }
    }
    return m;
  }
}