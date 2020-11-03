/**
 *We are given a binary tree (with root node root), a target node, and an integer value K.
 *Return a list of the values of all nodes that have a distance K from the target node.  
 *The answer can be returned in any order.
 * @author Rahul S Koimattur
 * Intuition : We first build a Graph from the given tree by using hashmap so that 
 * we can traverse in both upward and downward direction. now we process all the nodes 
 * until we reach the target K value using a queue.
 */

 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode,List<TreeNode>> hm=new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> lis=new ArrayList<>();
        build(root,null);
        if(!hm.containsKey(target)){
           return lis;
        }
        
        Queue<TreeNode> q=new LinkedList<>();
        Set<TreeNode> vis=new HashSet<>();
        q.add(target);
        vis.add(target);
        while(!q.isEmpty()){
           int sz=q.size();
            if(K==0){
             while(sz-->0){
                lis.add(q.poll().val);
             }
                return lis;
            }
            while(sz-->0){
            TreeNode tt=q.poll();
                
            for(TreeNode ttt:hm.get(tt)){
              if(!vis.contains(ttt)){
                  vis.add(ttt);
             q.add(ttt);
              }
            }
            }
            K--;
        }
        return lis;
    }
    private void build(TreeNode cur,TreeNode par){
        if(cur==null) return;
      if(par!=null){
       if(!hm.containsKey(cur)) hm.put(cur,new ArrayList<TreeNode>());
                 if(!hm.containsKey(par)) hm.put(par,new ArrayList<TreeNode>());
          hm.get(cur).add(par);
          hm.get(par).add(cur);

      }
        build(cur.left,cur);
        build(cur.right,cur);
    }
}