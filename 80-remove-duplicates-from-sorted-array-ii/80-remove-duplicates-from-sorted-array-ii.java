class Solution {
    public int removeDuplicates(int[] nums) {
        int l=1,r = 1,n=nums.length,count =1;
        while(r<n){
            if(nums[r] == nums[r-1])
                count+=1;
            else{
                count = 1;
            }
            if(count <= 2){
                nums[l++] = nums[r];
            }
            r+=1;
        }
        return l;
    }
}