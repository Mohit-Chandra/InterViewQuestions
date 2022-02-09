class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer,Integer> seen = new HashMap<>();
        int n = nums.length;
        for(int x:nums)
            seen.merge(x,1,Integer::sum);
        int res = 0;
        for(Map.Entry<Integer,Integer> entry : seen.entrySet()){
            int x = entry.getKey();
            int val = entry.getValue();
            if(k>0 && seen.containsKey(x+k)){
                res+=1;
            }else if(k== 0 && val>1){
                res+=1;
            }
        }
        return res;
        
    }
}