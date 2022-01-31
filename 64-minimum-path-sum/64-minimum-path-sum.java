class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null)
            return 0;
        int r = grid.length;
        int c = grid[0].length;
        if(r == 0 || c==0)
            return 0;
        Integer dp[][] = new Integer[r][c];
        return recur(grid,r-1,c-1,dp);
    }
    
    public int recur(int [][] grid,int i,int j,Integer[][] dp){
        if(i<0 || j<0 || j>=grid[0].length){
           return Integer.MAX_VALUE; 
        }
        if(i==0 && j==0){
            return grid[0][0];
        }
        if(dp[i][j]!=null)
            return dp[i][j];
        
        int up = recur(grid,i-1,j,dp);
        int left = recur(grid,i,j-1,dp);
        return dp[i][j] = grid[i][j]+Math.min(up,left);
    }
}