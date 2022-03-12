class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        Integer dp[][] = new Integer[n][m];
        return recur(word1,word2,n-1,m-1,dp);
    }
    
    private int recur(String s1,String s2,int n,int m,Integer [][]dp){
        if(n<0) return m+1;
        if(m<0) return n+1;
        if(dp[n][m]!=null)
            return dp[n][m];
        if(s1.charAt(n) == s2.charAt(m)){
            return dp[n][m] = recur(s1,s2,n-1,m-1,dp);
        }else{
            return dp[n][m] = 1+Math.min(recur(s1,s2,n,m-1,dp),Math.min(recur(s1,s2,n-1,m,dp),recur(s1,s2,n-1,m-1,dp)));
        }
    }
}