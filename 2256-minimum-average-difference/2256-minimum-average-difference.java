class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long totalSum = 0, leftSum = 0;
        for(int i=0;i<n;i+=1){
            totalSum+=nums[i];
        }
        int minAvgDiff = (int)1e9, res = -1;
        for(int i=0;i<n;i+=1){
            leftSum+=nums[i];
            long leftPartAvg = leftSum;
            leftPartAvg/=(i+1);
            
            long rightPartAvg = totalSum - leftSum;
            if(i!=n-1)
                rightPartAvg/=(n-i-1);
            
            int currAvgDiff = (int)Math.abs(rightPartAvg - leftPartAvg);
            if(currAvgDiff < minAvgDiff)
            {
                minAvgDiff = currAvgDiff;
                res = i;
            }
        }
        return res;
    }
}