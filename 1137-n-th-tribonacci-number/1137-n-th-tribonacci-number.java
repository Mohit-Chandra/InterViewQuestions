class TriBo{
    private int n = 38;
    public int[] nums = new int[n];
    TriBo(){
        nums[1] = 1;
        nums[2] = 1;
        for(int i=3;i<n;i+=1)
            nums[i] = nums[i-1]+nums[i-2]+nums[i-3];
    }
}

class Solution {
    public static TriBo tribo = new TriBo();
    public int tribonacci(int n) {
        return tribo.nums[n];
    }
}