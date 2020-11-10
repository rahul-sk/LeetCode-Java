  /**
 * In an array A of 0s and 1s, how many non-empty subarrays have sum S?
 * @author Rahul S Koimattur
 * Intuition :  We use a typical 2 pointer method namely sliding window to solve this problem.
 *              Lets maintain two pointers l and r. we will increase the window size by incrementing
 *              r pointer to it's right until the sum criteria is satisified. then we increment the
 *              number of subarray counter(cnt) by moving the l pointer to it's right until the sum criteria
 *              becomes false, thereby counting all the sub arrays along the path.
 */
 

class Solution {
    public int numSubarraysWithSum(int[] arr, int S) {
        int l=0,r=0,sum=0,cnt=0;
        for(;r<arr.length;r++){
          sum+=arr[r];
          while(sum>S && l<r){
           sum-=arr[l++];
          }
          if(sum==S) cnt++;
          for(int i=l;sum==S && i<r && arr[i]==0 ;i++){
              cnt++;
          }  
        }
        return cnt;
    }
}

