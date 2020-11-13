  
 /**
 *Given an array of integers arr, replace each element with its rank. The rank represents how large the element is. The rank has the following rules:
 *Rank is an integer starting from 1. 
 *The larger the element, the larger the rank. 
 *If two elements are equal, their rank must be the same.
 *Rank should be as small as possible.
 * @author Rahul S Koimattur
 * Intuition : We can use a HashMap to store the elements and its respective rank,To get the rank, we can first check the number of unique elements
 *             which will be the highest rank of an element, we then use a Max Heap to get the maximum element at each iteration and start assigning
 *             the ranks respectively.
 */
 
 class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer,Integer> hm=new HashMap<>();
        PriorityQueue<Integer> q=new PriorityQueue<>((a,b) ->Integer.compare(b,a));
        for(int i:arr){
         if(!hm.containsKey(i)){
           hm.put(i,0);
         }
            q.add(i);
        }
        int max=hm.keySet().size();
          while(!q.isEmpty()){
          int t=q.poll();
          if(hm.get(t)==0){
            hm.put(t,max--);
          }  
        }
        for(int i=0;i<arr.length;i++){
           arr[i]=hm.get(arr[i]);
        }    
        return arr;
    }
}
