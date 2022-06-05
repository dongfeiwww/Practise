/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return

[
   [5,4,11,2],
   [5,8,4,5]
]
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>(); 
        ArrayList<Integer> subResult=new ArrayList<Integer>();
        path(result, root, sum, subResult);
        return result; 
    }

    void path(ArrayList<ArrayList<Integer>> result, TreeNode root, int sum, ArrayList<Integer> subResult)
    {
        if(root==null) 
          return;

        int expect=sum-root.val;
        subResult.add(root.val);

        if(expect==0 && root.left==null && root.right==null) {
            result.add(subResult);
        }

        path(result, root.left, expect, (ArrayList<Integer>) subResult.clone());
        path(result, root.right, expect, (ArrayList<Integer>) subResult.clone());
    }
}

// def dfs(root, target): # return type = List[List[int]]
//     # 3. 根据函数定义确定终止条件
//     # 找所有路径，都没路的话，自然找不到，注意返回的是空的二维list
//     if not root: return []

//     # 1.当前为叶子结点且值为target，返回结果，注意是二维List
//     if not root.left and not root.right and root.val == target:
//         return [[target]]

//     # 2.对子树中找到的路径，在每个路径前面加上当前的val值
//     res = []
//     for path in dfs(root.left, target-root.val) + dfs(root.right, target-root.val):
//         res.append([root.val] + path)
//     return res