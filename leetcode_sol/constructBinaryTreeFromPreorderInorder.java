/*
Given preorder and inorder traversal of a tree, construct the binary tree.
class Solution:
    def bstFromPreorder(self, preorder: List[int]) -> Optional[TreeNode]:
        if not preorder:
            return None
        root = TreeNode(preorder[0])
        i = 1
        while i<len(preorder) and  preorder[i] < root.val:
            i+=1
        root.left = self.bstFromPreorder(preorder[1:i])
        root.right = self.bstFromPreorder(preorder[i:])
        return root
*/
public class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, 0, preorder.length - 1);
    }

    // 定义：将 preorder[start..end] 区间内的元素生成 BST，并返回根节点
    private TreeNode build(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        // 根据前序遍历的特点，根节点在第一位，后面接着左子树和右子树
        int rootVal = preorder[start];
        TreeNode root = new TreeNode(rootVal);

        // 根据 BST 的特点，左子树都比根节点的值小，右子树都比根节点的值大
        // p 就是左右子树的分界点
        int p = start + 1;
        while (p <= end && preorder[p] < rootVal) {
            p++;
        }
        // [start+1, p-1] 区间内是左子树元素
        root.left = build(preorder, start + 1, p - 1);
        // [p, end] 区间内是右子树元素
        root.right = build(preorder, p, end);

        return root;
    }
}
