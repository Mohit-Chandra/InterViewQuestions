class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int res = 0,sum = 0;
        Map<Integer,Integer> hMap = new HashMap<>();
        hMap.put(0,-1);
        for(int i=0;i<nums.length;i+=1){
            sum+=nums[i];
            int rsum = sum-k;
            if(hMap.containsKey(rsum)){
                int idx = hMap.get(rsum);
                res = Math.max(res,i-idx);
            }
            hMap.putIfAbsent(sum,i);
        }
        return res;
    }
}