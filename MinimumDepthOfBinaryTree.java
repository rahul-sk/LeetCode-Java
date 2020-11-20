/**
 * Given a binary tree, find its minimum depth. The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * @author Rahul S Koimattur
 * Intuition : use preorder traversal and upon hitting a leaf node, check if its height is less than the current known value and update accordingly.
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
    int ans=Integer.MAX_VALUE;
    
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        dfs(root,0);
        return ans;
        
    }
    private void dfs(TreeNode t,int h){
      if(t==null) return;
        h+=1;
        if(t.left==null && t.right==null){
           if(h<ans){
               ans=h;
           }
        }
        dfs(t.left,h);
        dfs(t.right,h);
    }
}
