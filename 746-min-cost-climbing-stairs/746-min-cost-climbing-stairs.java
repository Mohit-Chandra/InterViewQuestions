class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev = 0,pp=0;
        for(int i=2;i<cost.length+1;i+=1){
            int temp = prev;
            prev = Math.min(pp+cost[i-2],prev+cost[i-1]);
            pp = temp;
        }
        return prev;
    }
}