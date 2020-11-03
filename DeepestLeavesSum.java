/**
 *Given a binary tree, return the sum of values of its deepest leaves.
 * @author Rahul S Koimattur
 */


class Solution {
     int md=-1;   //maximum depth seen so far
     int sum=0;  //To store final result
    public int deepestLeavesSum(TreeNode root) {
        int[] d=new int[1]; // Current depth
        d[0]=0;
        dfs(root,d);
        return sum;
    }
    private void dfs(TreeNode cur,int[] d){
          if(cur==null) return;
          d[0]+=1;
          if(cur.left==null && cur.right==null){
                if(d[0]>md){  // if current depth is greater than max depth seen so far, update the sum and max depth
                    md=d[0];
                    sum=0;
                    sum+=cur.val; 
                }
               else if(d[0]==md){    // if current depth is equal to max depth add this value to sum. 
                    sum+=cur.val;
               }
        }
        dfs(cur.left,d);
        dfs(cur.right,d);
        d[0]-=1; //Back Tracking
    }
}