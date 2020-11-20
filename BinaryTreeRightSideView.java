/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * @author Rahul S Koimattur
 * Intuition : A regular level order traversal will do the job, at each level of the tree, grab the last node and add it to the resulting list.
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
    List<Integer> res=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return res;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
           int sz=q.size();
        for(int i=0;i<sz;i++){
           TreeNode tt=q.poll();
            if(i==sz-1){
                res.add(tt.val);
             }
            if(tt.left!=null) q.add(tt.left);
            if(tt.right!=null) q.add(tt.right);

            
        }
        }
        return res;
    }
}
