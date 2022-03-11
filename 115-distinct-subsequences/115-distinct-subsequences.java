class Solution {
    public int numDistinct(String s, String t) {
        int  ls = s.length(),lt = t.length();
        int prev[] = new int[lt+1];
        prev[0] = 1;
        for(int i=1;i<=ls;i+=1){
            int curr[] = new int[lt+1];
            curr[0] = 1;
            for(int j=1;j<=lt;j+=1){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    curr[j] = prev[j-1]+prev[j];
                }else{
                    curr[j] = prev[j];
                }
            }
            prev = curr;
        }
        return prev[lt];
    }
}