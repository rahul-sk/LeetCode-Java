 /**
 * Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting
 * some characters of the given string. If there are more than one possible results, return the longest word with 
 * the smallest lexicographical order. If there is no possible result, return the empty string.
 * @author Rahul S Koimattur
 * Intuition :  For each string in the dictonary, check if it is a sub sequence of the original string, if so then update
 *              the res variable if length is greater than the res string, in case of equal lengths, update the res string iff this string 
 *              is lexicographically less than the res string.
 */
 
 class Solution {
    public String findLongestWord(String s, List<String> d) {
        String res="";
        for(String str:d){
          if(issub(str,s)){

          if(str.length()>res.length()) res=str;
          if(str.length()==res.length() && str.compareTo(res)<0) res=str;
        }
        
    }
        return res;
}
    private boolean issub(String a,String b){
      char[] a1=a.toCharArray();
      char[] a2=b.toCharArray();
        int i=0,j=0;
      while(i<a1.length && j<a2.length){
         if(a1[i]==a2[j]) i++;
          j++;
      }
        if(i==a.length()) return true;
        return false;
    }
}
