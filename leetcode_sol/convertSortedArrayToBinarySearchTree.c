//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
class Solution {
public:
    TreeNode *get_bst_(vector<int>::iterator left, vector<int>::iterator right) {
        int n = right - left;
        if (0 == n) {
            return NULL;
        }
        TreeNode *node = new TreeNode( *(left + n/2) );
        node->left = get_bst_(left, left + n/2);
        node->right = get_bst_(left + n/2 + 1, right);
        return node;
    }
 
    TreeNode *sortedArrayToBST(vector<int> &num) {
        return get_bst_(num.begin(), num.end());
    }
};
