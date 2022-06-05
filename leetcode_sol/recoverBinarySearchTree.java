/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
*/
public class Solution {
    TreeNode previous;
    public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> list=new ArrayList<TreeNode>();
        previous=null;
        inOrder(root, list);
        int temp=list.get(0).val;
        list.get(0).val=list.get(list.size()-1).val; 
        list.get(list.size()-1).val=temp;
    }

    void inOrder(TreeNode root, ArrayList<TreeNode> list){
        if(root==null) return;
        inOrder(root.left, list);
        if(previous!=null && previous.val>root.val)
        {
            if(!list.contains(previous)) list.add(previous);
            if(!list.contains(root)) list.add(root);
        }
        previous=root;
        inOrder(root.right, list);
    }
}
