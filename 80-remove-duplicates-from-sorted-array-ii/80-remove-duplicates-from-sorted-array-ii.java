class Solution {
    public void adjustElements(int[] nums,int index){
        for(int i = index+1;i<nums.length;i+=1){
            nums[i-1] = nums[i];
        }
    }
    public int removeDuplicates(int[] nums) {
        int n = nums.length,i=1,count =1;
        while(i<n){
            if(nums[i] == nums[i-1]){
                count+=1;
                if(count > 2){
                    this.adjustElements(nums,i);
                    i-=1;
                    n-=1;
                }
            }else{
                count = 1;
            }
            i+=1;
        }
        return n;
    }
}