// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    public int editDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        Integer dp[][] = new Integer[m][n];
        return recur(s,t,m,n,dp);
    }
    
    public int recur(String s,String t,int m,int n,Integer dp[][]){
        if(m==0)
        return n;
        if(n==0)
        return m;
        if(dp[m-1][n-1]!=null)
        {
            return dp[m-1][n-1];
        }
        if(s.charAt(m-1) == t.charAt(n-1))
            return dp[m-1][n-1] = recur(s,t,m-1,n-1,dp);
        else{
            return dp[m-1][n-1] = 1+Math.min(recur(s,t,m,n-1,dp),Math.min(recur(s,t,m-1,n,dp),
            recur(s,t,m-1,n-1,dp)));
        }
    }
}