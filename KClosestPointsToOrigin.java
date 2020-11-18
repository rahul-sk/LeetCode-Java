 /**
 * We have a list of points on the plane. Find the K closest points to the origin (0, 0). (Here, the distance between two points on a plane is the
 * Euclidean distance.) You may return the answer in any order. 
 * @author Rahul S Koimattur
 * Hint : PriorityQueue Application.
 */
 
 class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Map<int[],Integer> hm=new HashMap<>();
        int[][] res=new int[k][2];
        for(int[] p:points){
          int d=(int)Math.pow(p[0],2)+(int)Math.pow(p[1],2);
           hm.put(p,d); 
        }
        PriorityQueue<Map.Entry<int[],Integer>> q=new PriorityQueue<>((a,b) ->
                         (int)a.getValue()-b.getValue());
        q.addAll(hm.entrySet());
        int i=0;
        while(k-->0){
          Map.Entry e=q.poll();
            res[i++]=(int[])e.getKey();
        }
        return res;
    }
}
