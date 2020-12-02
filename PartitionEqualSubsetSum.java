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
        dp[0][0]=true;
        for(int i=1;i<n+1;i++){
        dp[i][0]=true;
        }
        for(int j=1;j<sum+1;j++){
         dp[0][j]=false;
        }
        for(int i=1;i<n+1;i++){
        for(int j=1;j<sum+1;j++){
           dp[i][j]=dp[i-1][j];
            if(arr[i-1]<=j){
            dp[i][j]=dp[i][j]||dp[i-1][j-arr[i-1]];
            }
        }
        }
        return dp[n][sum];
        
    }
}
