class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n];
        for(int g=0;g<n;g+=1){
            for(int i=0,j=g;j<n;i+=1,j+=1){
                int maxCost = Integer.MIN_VALUE;
                for(int k=i;k<=j;k+=1){
                    int lc = k==i?0:dp[i][k-1];
                    int rc = k==j?0:dp[k+1][j];
                    int val = (i==0?1:nums[i-1])*nums[k]*(j==n-1?1:nums[j+1]);
                    maxCost = Math.max(lc+rc+val,maxCost);
                }
                dp[i][j] = maxCost;
            }
        }
        return dp[0][n-1];
    }
}