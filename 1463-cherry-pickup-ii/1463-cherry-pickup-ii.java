class Solution {
    public int cherryPickup(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int rowLen = grid.length;
        int colLen = grid[0].length;
        int dp[][][] = new int[rowLen][colLen][colLen];
         for(int i=0;i<rowLen;i++)
        {
            for(int j=0;j<colLen;j++)
            {
                Arrays.fill(dp[i][j],-1);
            }
        }
        recur(0,0,colLen-1,grid,dp);
        return dp[0][0][colLen-1];
    }
    
    public int recur(int r,int c1,int c2,int[][] grid,int dp[][][]){
        if(r >= grid.length || r<0 || c1>=grid[0].length || c2 >= grid[0].length || c1<0 || c2<0)
            return 0;
        
        if(dp[r][c1][c2]!=-1)
            return dp[r][c1][c2];
        
        int sum = 0;
        sum+=grid[r][c1];
        int maxCherries = 0;
        if(c1!=c2){
            sum+=grid[r][c2];
        }
        for(int i = c1-1;i<=c1+1;i+=1){
            for(int j = c2-1;j<=c2+1;j+=1){
                maxCherries = Math.max(maxCherries,recur(r+1,i,j,grid,dp));
            }
        }
        sum+=maxCherries;
        dp[r][c1][c2] = sum;
        return sum;
    }
}