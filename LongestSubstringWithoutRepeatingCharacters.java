
 /**
 * Given a string s, find the length of the longest substring without repeating characters. 
 * @author Rahul S Koimattur
 * Hint : Sliding Window 
 */
 
 class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0,r=0,max=0;
        Set<Character> hs=new HashSet<>();
        int prev=0;
        char[] arr=s.toCharArray();
        for(;r<arr.length;){
            if(!hs.contains(arr[r])){
           hs.add(arr[r++]);
           max=Math.max(max,hs.size());     
             }
            else{
           hs.remove(arr[l++]);
            }
   
        }
        return max;
    }
}
