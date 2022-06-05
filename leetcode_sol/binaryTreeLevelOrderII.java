/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:

[
  [15,7]
  [9,20],
  [3],
]
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>(); 
        if(root==null) return result; 
        Stack<ArrayList<Integer>> stack=new Stack<ArrayList<Integer>>();
        ArrayList<TreeNode> list=new ArrayList<TreeNode>();
        list.add(root);
        while (!list.isEmpty()) {
            ArrayList<TreeNode> Tplist=new ArrayList<TreeNode>();
            ArrayList<Integer> level=new ArrayList<Integer>();
            while (!list.isEmpty()) {
                TreeNode node=list.remove(0);
                level.add(node.val);
                if(node.left!=null) Tplist.add(node.left);
                if(node.right!=null) Tplist.add(node.right);
            }
            stack.push(level);
            list=Tplist; 
        }
        
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result; 
    }
}
