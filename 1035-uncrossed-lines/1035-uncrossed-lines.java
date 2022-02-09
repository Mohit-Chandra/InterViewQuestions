class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        Integer dp[][] = new Integer[n1][n2];
        return recur(nums1,nums2,n1-1,n2-1,dp);
    }
    
    private int recur(int[] nums1,int[] nums2,int i,int j,Integer dp[][]){
        if(i<0 || j<0)
            return 0;
        if(dp[i][j] != null)
            return dp[i][j];
        if(nums1[i] == nums2[j]){
            return dp[i][j] = 1+recur(nums1,nums2,i-1,j-1,dp);
        }
        return dp[i][j] = Math.max(recur(nums1,nums2,i-1,j,dp),recur(nums1,nums2,i,j-1,dp));
    }
}