
# https://leetcode.com/problems/binary-tree-level-order-traversal/solution/
class Solution:
    def levelOrder(self, root):
        levels = []
        if not root:
            return levels
        
        def helper(node, level):
            # start the current level
            if len(levels) == level:
                levels.append([])

            # append the current node value
            levels[level].append(node.val)

            # process child nodes for the next level
            if node.left:
                helper(node.left, level + 1)
            if node.right:
                helper(node.right, level + 1)
            
        helper(root, 0)
        return levels

class Solution:
    # @param {TreeNode} root
    # @return {integer[][]}
    def levelOrder(self, root):
        queue, out, current_level = [], [], []
        cur, next = 0, 0
        if root is None:
            return []
        queue.append(root)
        cur += 1
        while queue:
            node = queue.pop(0)
            cur -= 1
            if node.left:
                queue.append(node.left)
                next += 1  
            if node.right:
                queue.append(node.right)
                next += 1 
                
            current_level.append(node.val)
            if cur == 0:
                out.append(current_level)
                current_level = []
                cur = next
                next = 0
        return out