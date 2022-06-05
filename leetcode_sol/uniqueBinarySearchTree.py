# Unique Binary Search Trees
# Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 
# For example,
# Given n = 3, there are a total of 5 unique BST's.
 
#    1         3     3      2      1
#     \       /     /      / \      \
#      3     2     1      1   3      2
#     /     /       \                 \
#    2     1         2                 3
# */
 
def numTrees( n):
    dp = [0] * (n+1)
    dp[0] = 1
    dp[1] = 1
    for i in range(2, n):
        for j in range(1, i):
            dp[i] += dp[j-1] * dp[i-j]

    return dp[n]


def find_unique_trees(n):
  if n <= 0:
    return []
  return findUnique_trees_recursive(1, n)


def findUnique_trees_recursive(start, end):
  result = []
  # base condition, return 'None' for an empty sub-tree
  # consider n = 1, in this case we will have start = end = 1, this means we should have only one tree
  # we will have two recursive calls, findUniqueTreesRecursive(1, 0) & (2, 1)
  # both of these should return 'None' for the left and the right child
  if start > end:
    result.append(None)
    return result

  for i in range(start, end+1):
    # making 'i' the root of the tree
    leftSubtrees = findUnique_trees_recursive(start, i - 1)
    rightSubtrees = findUnique_trees_recursive(i + 1, end)
    for leftTree in leftSubtrees:
      for rightTree in rightSubtrees:
        root = TreeNode(i)
        root.left = leftTree
        root.right = rightTree
        result.append(root)

  return result