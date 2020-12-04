 /**
 * You are given coins of different denominations and a total amount of money. Write a function to compute the number of 
 * combinations that make up that amount. You may assume that you have infinite number of each kind of coin.
 * @author Rahul S Koimattur
 */
 
 class Solution {
    public int change(int n, int[] S) {
        int m=S.length;
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<=n;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(S[i-1]<=j){
                    dp[i][j]=dp[i-1][j]+dp[i][j-S[i-1]]; // number of ways with present coin + number of ways without present coin.
                }
                else{
                    dp[i][j]=dp[i-1][j]; // If the current coin value is greater than the change we are making, then we cannot consider it.
                }
            }
        }
        return dp[m][n];
        
    }
}
