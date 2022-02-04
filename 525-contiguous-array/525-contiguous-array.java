class Solution {
    public int findMaxLength(int[] nums) {
        int res = 0,sum=0;
        Map<Integer,Integer> hMap = new HashMap<>();
        hMap.put(0,-1);
        for(int i=0;i<nums.length;i+=1){
            if(nums[i]==0){
                sum+=-1;
            }else if(nums[i] == 1){
                sum+=1;
            }
            
            if(hMap.containsKey(sum)){
                int idx = hMap.get(sum);
                res = Math.max(res,i-idx);
            }else{
                hMap.put(sum,i);
            }
        }
        return res;
    }
}