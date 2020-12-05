  
/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1. Some courses may have prerequisites, 
 * for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1] Given the total number of 
 * courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * @author Rahul S Koimattur
 * Intuition : If there is a cycle in the graph, we cannot Schedule the course and hence we return false, This condition can be checked by use Topological 
 *             sorting algorithm.
 */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inn=new int[numCourses];
        Map<Integer,List<Integer>> hm=new HashMap<>();
        for(int[] e:prerequisites){
            int fr=e[1],to=e[0];
            if(!hm.containsKey(fr)){
         hm.put(fr,new ArrayList<>());
             }
            hm.get(fr).add(to);
            inn[e[0]]++;
        }
        int cnt=0;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
        if(inn[i]==0){
           q.add(i);
        }
        }
        while(!q.isEmpty()){
            int nn=q.poll();
            cnt++;
            if(hm.get(nn)!=null)
            for(int i:hm.get(nn)){
                if(--inn[i]==0){
                q.add(i);
                }
            }
        }
        return cnt==numCourses;
        
    }
}
