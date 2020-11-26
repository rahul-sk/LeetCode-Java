 /**
 * Invert a binary tree.
 * @author Rahul S Koimattur
 * Intuition : use a temp node a swap the left and right child of each non-leaf node int the tree.
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
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        helper(root);
        return root;
    }
    private void helper(TreeNode t){
        if(t==null) return;
        TreeNode temp=t.left;
        t.left=t.right;
        t.right=temp;
        helper(t.left);
        helper(t.right);
    }
}
