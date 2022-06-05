/*
Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/
public class Solution {
  public ArrayList<ArrayList<Integer>> generate(int numRows) {
    ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
    if(numRows<=0) return result; 
    ArrayList<Integer> first=new ArrayList<Integer>(); 
    first.add(1); 
    result.add(first);
    for(int i=1; i<numRows; i++) {
      ArrayList<Integer> before=result.get(i-1);
      ArrayList<Integer> now=new ArrayList<Integer>();
      now.add(1); 
      for(int j=1; j<i; j++) {
        now.add(before.get(j-1)+ before.get(j));
      }
      now.add(1); 
      result.add(now);
    }
    return result; 
  }
}
