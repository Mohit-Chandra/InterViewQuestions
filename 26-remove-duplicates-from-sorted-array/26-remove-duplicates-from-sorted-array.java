class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null)
            return 0;
        int n=nums.length;
        int l=1,r=1;
        while(r<n){
            if(nums[r] != nums[r-1]){
                nums[l++] = nums[r];
            }
            r+=1;
        }
        return l;
    }
}