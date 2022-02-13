class Solution {
     List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        res = new ArrayList<>();
        for(int i=0;i<=n;i+=1){
            recur(nums,i,0,new LinkedList<>());
        }
        return res;
    }
    
    private void recur(int[] nums,int k,int start,LinkedList<Integer> subList){
        if(subList.size() == k){
            res.add(new ArrayList<>(subList));
            return;
        }
        for(int i=start;i<nums.length;i+=1){
            subList.add(nums[i]);
            recur(nums,k,i+1,subList);
            subList.removeLast();
        }
    }
    
    
}