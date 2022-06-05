public class Solution {
    public int minDepth(TreeNode root) {
        if(root==null) 
            return 0; 
        if(root.left==null && root.right==null) 
            return 1; 
        if(root.left==null || root.right==null) 
            return 1 + Math.max(minDepth(root.left), minDepth(root.right));
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}

// http://www.programcreek.com/2013/02/leetcode-minimum-depth-of-binary-tree-java/
// def find_minimum_depth(root):
//   if root is None:
//     return 0

//   queue = deque()
//   queue.append(root)
//   minimumTreeDepth = 0
//   while queue:
//     minimumTreeDepth += 1
//     levelSize = len(queue)
//     for _ in range(levelSize):
//       currentNode = queue.popleft()

//       # check if this is a leaf node
//       if not currentNode.left and not currentNode.right:
//         return minimumTreeDepth

//       # insert the children of current node in the queue
//       if currentNode.left:
//         queue.append(currentNode.left)
//       if currentNode.right:
//         queue.append(currentNode.right)
