  
/**
 * There are a total of n courses you have to take labelled from 0 to n - 1. Some courses may have prerequisites, for example, 
 * if prerequisites[i] = [ai, bi] this means you must take the course bi before the course ai. Given the total number of courses 
 * numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses. If there 
 * are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 * @author Rahul S Koimattur
 * Intuition : If there is a cycle in the graph, we cannot Schedule the course and hence we return empty array, if cycle is not detected the we return the
 *             topological ordering of the graph.
 */
 
 class Solution {
    public int[] findOrder(int n, int[][] arr) {
       int[] res=new int[n];
       Map<Integer,List<Integer>> hm=new HashMap<>();
        int[] inn=new int[n];
       for(int[] e:arr){
        int fr=e[1],to=e[0];
          
        if(!hm.containsKey(fr)) hm.put(fr,new ArrayList<>());
         hm.get(fr).add(to);  
         inn[to]++;
           
        } 
        int j=0;
        int cnt=0;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
          if(inn[i]==0){
             q.add(i);
          }
        }
        while(!q.isEmpty()){
         int nn=q.poll();
            res[j++]=nn;
          cnt++;
            if(hm.get(nn)!=null)
           for(int ii:hm.get(nn)){
             if(--inn[ii]==0) q.add(ii);
           } 
            
        }
        return cnt==n?res:new int[]{};
    }
}
