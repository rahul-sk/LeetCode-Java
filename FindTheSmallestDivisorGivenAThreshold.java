/**
 *Given an array of integers nums and an integer threshold, we will choose a positive integer divisor and divide
 *all the array by it and sum the result of the division. Find the smallest divisor such that the result mentioned
 *above is less than or equal to threshold.Each result of division is rounded to the nearest integer greater than
 *or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
 * @author Rahul S Koimattur
 * Hint: Binary Search.
 */
 
 class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int min=1;
        int max=(int)1e9;
        while(min<=max){
            int mid=(min+max)/2;
            if(isval(mid,threshold,nums)){
               max=mid-1;
            }
            else{
              min=mid+1;
            }
        }
        return min;
        
    }
    private boolean isval(int n,int t,int[] arr){
       int sum=0;
      for(int i=0;i<arr.length;i++){
       sum+=(int)Math.ceil((double)arr[i]/n);
          
      }
        return sum<=t;
    }
}
