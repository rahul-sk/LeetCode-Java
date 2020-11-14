 /**
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1
 * and return them in any order.The graph is given as follows: graph[i] is a list of all nodes you can visit from node i 
 * (i.e., there is a directed edge from node i to node graph[i][j]).
 * @author Rahul S Koimattur
 * Intuition : Explore the nodes in the graph in a DFS manner. each time we find a path from source to destination, we add that path
 *             to the resulting list and backtrack to explore other possible paths.
 */
 
 class Solution {
    List<List<Integer>> res;
    List<Integer> lis;
    int[][] gr;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        res=new LinkedList<>();
        lis=new LinkedList<>();
        gr=graph;
        lis.add(0);
        helper(0);
        return res;
        
    }
    private void helper(int n){
        if(n==gr.length-1){
          res.add(new LinkedList(lis)); //We have found a new path, append it to the resulting list.
            return;
        }
        
        for(int i:gr[n]){
            lis.add(i);
            helper(i);
            lis.remove(lis.size()-1); //Backtracking to explore other possible paths
        }
    }
}
