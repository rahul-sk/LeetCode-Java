 /**
 * Given a non-empty list of words, return the k most frequent elements. Your answer should be sorted by frequency from highest to lowest. 
 * If two words have the same frequency, then the word with the lower alphabetical order comes first.
 * @author Rahul S Koimattur
 * Intuition :  Use Bucket Sort Algorithm, count the frequency of words useing a HashMap, then sort the contents of each bucket to handel multiple words
                with same frequency. Finally iterate from the last bucket down to the first and append the respective words into a result List.
 */
 
 class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> hm=new HashMap<>();
        for(String s:words){
           hm.put(s,hm.getOrDefault(s,0)+1);
        }
        List<String>[] buc=new List[words.length+1];
        for(String ss:hm.keySet()){
          int val=hm.get(ss);
          if(buc[val]==null) buc[val]=new ArrayList<>();
          buc[val].add(ss);  
        }
        for(int i=0;i<buc.length;i++){
            if(buc[i]!=null)
          Collections.sort(buc[i]);
        }
        List<String> res=new LinkedList<>();
        for(int i=words.length;i>=0;--i){
          if(buc[i]!=null){
              
            for(String s:buc[i]){
                if(k>0){
                res.add(s);
                k--;
                }
            }
              
          }
        }
        return res;
        
    }
}
