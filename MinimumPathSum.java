
/**
 *Given a m x n grid filled with non-negative numbers, 
 *find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * @author Rahul S Koimattur
 * Intuition : If we are in the first row, we can only traverse in right direction, 
 *             If we are in first column then we can traverse only in downward direction.
 *             If we are not on the left and top boundries of the grid, then we can reach a cell 
 *             from either top or left and we choose the one with smaller distance value.
 */

class Solution {
    public int minPathSum(int[][] arr) {
        int n=arr.length;
        int m=arr[0].length;
        
        for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
             if(i==0 && j>0){
               arr[i][j]+=arr[i][j-1];
             }
               else if(j==0 && i>0){
                arr[i][j]+=arr[i-1][j];
               }
               else if(i>0 && j>0){
                 arr[i][j]+=Math.min(arr[i-1][j],arr[i][j-1]); 
               }
           }
        }
        return arr[n-1][m-1];
    }
}