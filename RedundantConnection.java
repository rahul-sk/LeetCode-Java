 /**
 * In this problem, a tree is an undirected graph that is connected and has no cycles. The given input is a graph that started as a tree
 * with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. The added edge has two different vertices chosen from 
 * 1 to N, and was not an edge that already existed. The resulting graph is given as a 2D-array of edges. Each element of edges is a 
 * pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v. Return an edge that can be removed so that the
 * resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. 
 * The answer edge [u, v] should be in the same format, with u < v.
 * @author Rahul S Koimattur
 * Intuition : We use union-find algorithm to solve this problem. while processing the edges, we make a union operation if the two nodes
 *             belong to different components. In case if it belongs to same components, we add the respective nodes to the result array
 *              there by finding the redundant connection.
 */
 
 class Solution {
    private void union(int a,int b,int[] par){
       int ap=find(a,par);
        int bp=find(b,par);
        if(ap==bp) return;
        par[ap]=bp;
    }
    private int find(int a,int[] par){
        while(par[a]!=a){
           a=par[a];
        }
        return a;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int[] par=new int[n+1];
        for(int i=1;i<=n;i++){
             par[i]=i;
         }
        int[] res=new int[2];
        for(int[] e:edges){
          int fr=e[0],to=e[1];
          if(find(fr,par)==find(to,par)){
               res[0]=fr;
              res[1]=to;
          }
           else{
             union(fr,to,par);
           } 
        }
        return res;
    }
}
 
 
