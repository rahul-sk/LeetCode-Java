/**
 *Given an array of strings strs, group the anagrams together. You can return the 
 *answer in any order. An Anagram is a word or phrase formed by rearranging the 
 *letters of a different word or phrase, typically using all the original letters exactly once.
 * @author Rahul S Koimattur
 * Intuition : Sort each string and use it as a key in a hashmap to group all the related anagrams
 */

 class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> hm=new HashMap<>();
        for(int i=0;i<strs.length;i++){
          String s=strs[i];
          char[] arr=s.toCharArray(); 
            
            Arrays.sort(arr);          //use the sorted string as a key to the hashmap
            String so=String.valueOf(arr);
            if(!hm.containsKey(so)){
             hm.put(so,new ArrayList<String>()); 
            }
            hm.get(so).add(s);
        }
        List<List<String>> res=new ArrayList<>();
        for(List<String> ll:hm.values()){
          res.add(ll);
        }
        return res;
        
    }
}