class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long prefix[] = new long[n+1];
        long suffix[] = new long[n+1];
        int minAvgDiff = (int)1e9;
        for(int i=0;i<n;i+=1){
            prefix[i+1] = prefix[i]+nums[i];
        }
        for(int i = n-1;i>=0;i-=1){
            suffix[i] = suffix[i+1]+nums[i];
        }
        int res = -1;
        for(int i=0;i<n;i+=1){
            long leftPartAvg = prefix[i+1];
            leftPartAvg/=(i+1);
            
            long rightPartAvg = suffix[i+1];
            if(i!=n-1){
                rightPartAvg/=(n-i-1);
            }
            int currDiffAvg = (int)Math.abs(rightPartAvg-leftPartAvg);
            if(currDiffAvg < minAvgDiff){
                minAvgDiff = currDiffAvg;
                res = i;
            }
        }
        return res;
    }
}