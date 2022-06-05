/*
   Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


   Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


   The largest rectangle is shown in the shaded area, which has area = 10 unit.

   For example,
   Given height = [2,1,5,6,2,3],
   return 10.
   */
public class Solution {
  class Bar{
    int height, startIdx;
    Bar(int h, int i){ this.height = h; this.startIdx = i; }
  }

  public int largestRectangleArea(int[] height) {
    int maxArea = 0;
    Stack<Bar> stack = new Stack<Bar>();
    stack.push(new Bar(-1, 0));

    for (int i=0; i<=height.length; i++){
      int h = i < height.length ? height[i] : 0;
      int startIdx = i;
      
      while (!stack.isEmpty() && stack.peek().height >= h){
        Bar bar = stack.pop();
        startIdx = bar.startIdx;
        maxArea = Math.max(maxArea, (i - startIdx) * bar.height);
      }
      stack.push(new Bar(h, startIdx));
    }
    return maxArea;
  }
}
