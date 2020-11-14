 /**
 * Given a directed acyclic graph, with n vertices numbered from 0 to n-1, and an array edges where edges[i] = [fromi, toi] represents
 * a directed edge from node fromi to node toi. Find the smallest set of vertices from which all nodes in the graph are reachable. 
 * It's guaranteed that a unique solution exists. Notice that you can return the vertices in any order.
 * @author Rahul S Koimattur
 * Intuition :  This problem boils down to finding all node with zero in-degree, because there is no way to reach those nodes from any other 
 *              Nodes in the graph, All the other nodes will be covered by following the above process.
 */
 
 class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
     int[] in=new int[n];
     for(List<Integer> edg:edges){
       int fr=edg.get(0);
       int to=edg.get(1);
       in[to]++;     
     }
       List<Integer> res=new LinkedList<>();
       for(int i=0;i<n;i++){
         if(in[i]==0){  
            res.add(i); // Adding nodes with zero in-degree.
         }
       }
        return res;
        
    }
}
