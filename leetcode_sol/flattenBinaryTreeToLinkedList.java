
public class Solution {
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root==null) return ; 
        TreeNode left=root.left; 
        TreeNode right=root.right; 
        if(left!=null)
        {
            root.right=left; 
            root.left=null; 
            TreeNode rightMost=root.right; 
            while(rightMost!=null && rightMost.right!=null)
            {
                rightMost=rightMost.right; 
            }
            if(rightMost!=null) rightMost.right=right; 
        }
        flatten(root.right);
    }
}
