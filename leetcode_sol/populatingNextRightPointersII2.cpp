/********************************************************************************************
* Follow up for problem "Populating Next Right Pointers in Each Node".
* 
* What if the given tree could be any binary tree? Would your previous solution still work?
* 
* Note:
* 
* You may only use constant extra space.
* For example,
* Given the following binary tree,
*         1
*       /  \
*      2    3
*     / \    \
*    4   5    7
* After calling your function, the tree should look like:
*         1 -> NULL
*       /  \
*      2 -> 3 -> NULL
*     / \    \
*    4-> 5 -> 7 -> NULL
*********************************************************************************************/
/**
 * Definition for binary tree with next pointer.
 * struct TreeLinkNode {
 *  int val;
 *  TreeLinkNode *left, *right, *next;
 *  TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
 * };
 */
class Solution {
public:
void connect(TreeLinkNode *root) {
     if(root == NULL)
      return;
    while(root!= NULL){ //when finally all nodes on this level is NULL, stop iteration.
      TreeLinkNode *firstOfNextLevel = NULL;  //the first node of next level
      TreeLinkNode *preNode = NULL; //the previous node of the next level
 
      for(;root!= NULL;root = root->next){ //traverse the current level
        if(firstOfNextLevel == NULL) //we have to find the first non-null node of next level 
          firstOfNextLevel = root->left != NULL ? root->left : root->right;
            if(root->left != NULL){
              if(preNode != NULL){
                preNode->next = root->left; 
              }
              preNode = root->left;
            }
            if(root->right != NULL){
              if(preNode != NULL){
                preNode->next = root->right;
              }
              preNode = root->right;
            }         
        
      }
      
      root = firstOfNextLevel; //turn to the next level
    
    }
}
};
