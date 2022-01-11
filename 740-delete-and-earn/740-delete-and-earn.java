class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] numsArray = new int[10001];
        for(int n : nums){
            numsArray[n]++;
        }
        int include = 0,exclude = 0;
        for(int i=0;i<10001;i+=1){
            int newInclude = exclude+numsArray[i]*i;
            int newExclude = Math.max(include,exclude);
            include = newInclude;
            exclude = newExclude;
        }
        return Math.max(include,exclude);
    }
}