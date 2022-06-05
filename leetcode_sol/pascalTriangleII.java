/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

*/
public class Solution {
  public ArrayList<Integer> getRow(int rowIndex) {
    ArrayList<Integer> before=new ArrayList<Integer>(); 
    if(rowIndex<0) return before; 
    before.add(1); 
    if(rowIndex==0) return before;
    for(int i=0; i<rowIndex; i++)
    {
      ArrayList<Integer> now=new ArrayList<Integer>(); 
      now.add(1); 
      for(int j=1; j<rowIndex; j++)
      {
        now.add(before.get(j-1)+ before.get(j));
      }
      now.add(1); 
      before=now; 
    }
    return before; 
  }
}
