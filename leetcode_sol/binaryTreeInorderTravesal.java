public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        if (root==null) 
            return result; 
        Stack<TreeNode> stack=new Stack<TreeNode>();
        while(!stack.isEmpty()|| root!=null) { 
            if (root!=null) {
                stack.push(root); root=root.left; 
            } else {
                root=stack.pop(); result.add(root.val); root=root.right; 
            }
        }
        return result; 
    }
}
