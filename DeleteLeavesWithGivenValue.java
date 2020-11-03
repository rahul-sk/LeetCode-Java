/**
*Given a binary tree root and an integer target, delete all the leaf nodes with value target.
*Note that once you delete a leaf node with value target, if it's parent node becomes a leaf node and has the value target, it should also be deleted
* @author Rahul S Koimattur
*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        helper(root,target);
        if(root.left==null && root.right==null && root.val==target){
            return null;
        }
        return root;
        
        
    }
    private TreeNode helper(TreeNode n,int t){
        if(n==null) return n;
        n.left=helper(n.left,t);
        n.right=helper(n.right,t);
        if(n.left==null && n.right==null){
           if(n.val==t){
               return null;
           }
            else{
             return n;
            }
        }
       return n;
    }
}