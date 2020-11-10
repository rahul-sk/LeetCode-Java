 /**
 * Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
 * Return the number of nice sub-arrays. 
 * @author Rahul S Koimattur
 * Intuition :  We use a typical 2 pointer method namely sliding window to solve this problem.
 *              Lets maintain two pointers l and r. we will increase the window size by incrementing
 *              r pointer to it's right until the odd count criteria is satisified. then we increment the
 *              number of subarray counter(cnt) by moving the l pointer to it's right until the odd count criteria
 *              becomes false, thereby counting all the sub arrays along the path. we repeat this process until
 *              the r pointer hits end of the array.
 */

class Solution {
    public int numberOfSubarrays(int[] arr, int k) {
        int l=0,r=0,cnt=0,ans=0;
        for(;r<arr.length;r++){
          if(arr[r]%2!=0){
             cnt++;
            }
           while(l<r && cnt>k){
             cnt-=arr[l++]&1;   // moving the l pointer until the next odd number is found.
           }
           if(cnt==k){
              ans++;
           }
           for(int i=l; cnt==k && i<r && arr[i]%2==0;i++){
              ans++;
           } 
        }
        return ans;
        
    }
}
