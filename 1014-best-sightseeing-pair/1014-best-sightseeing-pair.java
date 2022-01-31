class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int best = values[0];
        int ans = -1;
        for(int i=1;i<n;i+=1){
            ans = Math.max(ans,best+values[i]-i);
            best = Math.max(best,values[i]+i);
        }
        return ans;
    }
}