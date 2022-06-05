/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]
import collections
def bfs(root):
    if not root: return []
    Q = collections.deque([root])
    res = []
    level = 1
    while Q:
        rec = [] # record all node in the same level
        l = len(Q)
        for i in range(l):
            node = Q.popleft()
            rec.append(node.val)
            if node.left: Q.append(node.left)
            if node.right: Q.append(node.right)
        # 循环结束rec正好储存了该层的所有节点
        if level % 2 != 0: res.append(rec)
        else: res.append(rec[::-1])
        level += 1
    return res
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> rets = new ArrayList<ArrayList<Integer>>();
        if (null == root) return rets;
        TreeNode forwardFlag = new TreeNode(Integer.MAX_VALUE);
        TreeNode backwardFlag = new TreeNode(Integer.MIN_VALUE);
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        queue.addLast(forwardFlag);
        ArrayList<TreeNode> currLevel = new ArrayList<TreeNode>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            if (node.val == Integer.MAX_VALUE || node.val == Integer.MIN_VALUE) {
                if (currLevel.isEmpty()) break;
                ArrayList<Integer> copy = new ArrayList<Integer>();
                for(TreeNode n : currLevel) {
                    copy.add(n.val);
                }
                if (node.val == Integer.MIN_VALUE) {
                    Collections.reverse(copy);
                    queue.addLast(forwardFlag);
                } else {
                    queue.addLast(backwardFlag);
                }
                rets.add(copy);
                currLevel = new ArrayList<TreeNode>();
                continue;
            }
            currLevel.add(node);
            if (null != node.left) 
                queue.addLast(node.left);
            if (null != node.right) 
                queue.addLast(node.right);
        }
        return rets;
    }
}
