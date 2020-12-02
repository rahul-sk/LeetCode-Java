 /**
 * Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets 
 * such that the sum of elements in both subsets is equal.
 * @author Rahul S Koimattur
 * Intuition : If the sum of the elements is odd, there is no way to get the equal sum subsets, otherwise, we can check if the sum/2 value can be
 *             found using the array which can be efficiently done using bottom-up dynamic programming approch.
 */
 
 class Solution {
    public boolean canPartition(int[] arr) {
        int sum=0;
        for(int i:arr) sum+=i;
        if(sum%2!=0) return false;
        sum/=2;
        int n=arr.length;
        boolean[][] dp=new boolean[n+1][sum+1];
        dp[0][0]=true; // If the sum is zero and the array is empty, we can get to a solution by doing nothing and hence we declare it as true
        for(int i=1;i<n+1;i++){
        dp[i][0]=true;  // If the sum is zero, we can get it by doing nothing irrespective of the array elements and hence is true;
        }
        for(int j=1;j<sum+1;j++){
         dp[0][j]=false; // If the array is empty, we cannot produce any sum value and hence is false.
        }
        for(int i=1;i<n+1;i++){
        for(int j=1;j<sum+1;j++){
           dp[i][j]=dp[i-1][j];
            if(arr[i-1]<=j){
            dp[i][j]=dp[i][j]||dp[i-1][j-arr[i-1]]; // If the current array element is less than or equal to the current target, we can either consider it or not consider it.
            }
        }
        }
        return dp[n][sum];
        
    }
}
