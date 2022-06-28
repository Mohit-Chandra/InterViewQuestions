class Solution {
    /**
       226                  recur(s,0,3) 3
                            /            \
              recur(s,1,3) 2            recur(s,2,3) 1
            /             \
     recur(s,2,3) 1      recur(s,3,3) 1
       /          \
recur(s,3,3)      recur(s,)
    **/
    public int numDecodings(String s) {
        int sLen = s.length();
        Integer dp[] = new Integer[sLen+1];
        return recur(s,0,sLen,dp);
    }
    
    public int recur(String s,int start,int end,Integer[] dp){
        
        if(start<end && s.charAt(start)=='0')
            return 0;
        
        if(start>=end)
            return 1;
        
        if(dp[start]!=null)
            return dp[start];
        
        int ways = recur(s,start+1,end,dp);
        
        if(start+1<end && ((s.charAt(start) == '1' && s.charAt(start+1)<='9') ||
                         (s.charAt(start) == '2' && s.charAt(start+1)<'7'))){
            ways+=recur(s,start+2,end,dp);
        }
        
        return dp[start] = ways;
        
    }
}