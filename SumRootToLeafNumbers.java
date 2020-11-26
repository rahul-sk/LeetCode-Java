/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number. An example is the root-to-leaf
 * path 1->2->3 which represents the number 123. Find the total sum of all root-to-leaf numbers. Note: A leaf is a node with no children.
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
    List<Integer> lis=new ArrayList<>();
    int sum=0;
    
    public int sumNumbers(TreeNode root) {
        help(root,"");   
        return sum;
    }
    private void help(TreeNode n,String s){
      if(n==null) return;
        s+=n.val;
        if(n.left==null && n.right==null){
      
          int nn=Integer.parseInt(s);
          sum+=nn;
        }
        help(n.left,s);
        help(n.right,s);
        s=s.substring(0,s.length());
    }
}
