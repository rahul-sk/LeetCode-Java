/**
 *Given the root of a binary tree, return an array of the largest 
 *value in each row of the tree (0-indexed).
 * @author Rahul S Koimattur
 * Intuition : Scan each row of the tree by using level order tree traversal and after scanning
 * each row, append the respective max value to an ArrayList.
 */

 /**
 * Definition for a binary tree node..
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        if(root==null) return res;
        while(!q.isEmpty()){
          int sz=q.size();
          int max=Integer.MIN_VALUE;
            while(sz-->0){
              TreeNode tt=q.poll();
              if(tt.val>max){
                 max=tt.val;
              }
                if(tt.left!=null) q.add(tt.left);
                if(tt.right!=null) q.add(tt.right);
            }
            res.add(max);
        }
        return res;
        
    }
