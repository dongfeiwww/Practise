/*
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,

         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
*/
public class Solution1 {
public void connect(TreeLinkNode root) {
  // Start typing your Java solution below
  // DO NOT write main() function
  if(root==null) return;
  TreeLinkNode top=root; 

  while(top!=null){
    TreeLinkNode cur= null;
    TreeLinkNode first = null;
    while(top!=null){
      if(top.left != null){
        if(cur != null)
          cur.next = top.left;
        cur = top.left;
      }
      if(top.right!=null){
        if(cur!=null)
          cur.next = top.right;
        cur = top.right;
      }
      if(first==null)
        first=top.left==null? top.right: top.left;  
      top = top.next;

    }
    top = first;
  }
}
}
public class Solution {
  public void connect(TreeLinkNode root) {
    if(root==null) return; 
    if(root.left!=null) root.left.next=(root.right!=null?root.right:first(root) );
    if(root.right!=null) root.right.next=first(root); 
    connect(root.left); 
    connect(root.right);
  }

  TreeLinkNode first(TreeLinkNode root)
  {
    TreeLinkNode next=root.next; 
    while(next!=null)
    {
      if(next.left!=null) return next.left; 
      if(next.right!=null) return next.right; 
      next=next.next; 
    }
    return null; 
  }
}
