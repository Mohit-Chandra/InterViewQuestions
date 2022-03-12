class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        //if one string is empty return n+m
        if(n*m == 0)
            return n+m;
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<n+1;i+=1){
            dp[i][0] = i;
        }
        for(int j=0;j<m+1;j+=1){
            dp[0][j] = j;
        }
        for(int i=1;i<n+1;i+=1){
            for(int j=1;j<m+1;j+=1){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1+Math.min(dp[i][j-1],Math.min(dp[i-1][j-1],dp[i-1][j]));
                }
            }
        }
        return dp[n][m];
    }
}