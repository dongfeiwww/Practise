/*
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
*/
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees (int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return dfs(1, n);
    }
  ArrayList<TreeNode> dfs(int start, int end)
  {
        ArrayList<TreeNode> result=new ArrayList<TreeNode> (); 
  if(start>end)  result.add(null);
        for(int i=start; i<=end; i++)
      {
      ArrayList<TreeNode> left=dfs(start, i-1);
  ArrayList<TreeNode> right=dfs(i+1, end);
        for(int x=0; x<left.size(); x++)
      {
       for(int y=0; y<right.size(); y++)
          {
         TreeNode parent=new TreeNode(i);
         parent.left=left.get(x);
         parent.right=right.get(y);
         result.add(parent);
         }
   }
  }
        return result;
    }
}
