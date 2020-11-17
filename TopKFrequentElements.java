 /**
 * Given a non-empty array of integers, return the k most frequent elements.
 * @author Rahul S Koimattur
 * Intuition :  Use a HashMap to count frequency of each digit in the array, then use a MaxHeap to sort this HashMap based on decreasing order of frequency,
                Finally return the Keys of the top K elements of the PriorityQueue.
 */
 
 class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> hm=new HashMap<>();
        for(int i:nums){
    hm.put(i,hm.getOrDefault(i,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>((a,b) -> b.getValue()-a.getValue()); // sorting in decreasing order of frequency of elements
        pq.addAll(hm.entrySet());
        int[] res=new int[k];
        int i=0;
        while(k-->0){
          Map.Entry e=pq.poll();
           res[i++]=(int)e.getKey(); 
        }
        return res;
    }
}
