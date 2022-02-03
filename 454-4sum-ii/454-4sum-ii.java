class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> hMap = new HashMap<>();
        int count = 0;
        int n = nums1.length;
        for(int i=0;i<n;i+=1){
            for(int j=0;j<n;j+=1){
                hMap.merge(nums1[i]+nums2[j],1,Integer::sum);
            }
        }
        
         for(int i=0;i<n;i+=1){
            for(int j=0;j<n;j+=1){
                int currSum = -(nums3[i]+nums4[j]);
                if(hMap.containsKey(currSum)){
                    count+=hMap.get(currSum);
                }
            }
        }
        return count;
        
    }
}