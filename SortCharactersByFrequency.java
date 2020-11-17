 /**
 * Given a string, sort it in decreasing order based on the frequency of characters. 
 * @author Rahul S Koimattur
 * Intuition :  Use a HashMap to count the frequency of each character, then store the character and it's respective frequency in a 2D array and sort
 *              This array based on frequency, Finally iterate over the sorted array and append the respective characters to the result string in the
 *              sorted order.
 */
 
 class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> hm=new HashMap<>();
        for(char c:s.toCharArray()){
          hm.put(c,hm.getOrDefault(c,0)+1);
        }
        int sz=hm.keySet().size();
        Set<Character> vis=new HashSet<>();
        int i=0;
        int[][] arr=new int[sz][2];
        for(char c:s.toCharArray()){
           if(!vis.contains(c)){
             vis.add(c);
             arr[i][0]=c;
               arr[i][1]=hm.get(c);
               i++;
               
           }
        }
        Arrays.sort(arr,new Comparator<>(){
          public int compare(int[] a,int[] b){
            if(a[1]<=b[1]){
               return 1;
            }
              return -1;
          }
        });
        String res="";
        for(int ii=0;ii<arr.length;ii++){
           char cc=(char)arr[ii][0];
           while(arr[ii][1]-->0){
              res+=cc;
           } 
        }
        return res;
        
    }
}
