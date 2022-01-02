class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer,Integer> hMap = new HashMap<>();
        int count = 0;
        for(int t : time){
            if(t%60 == 0){
                count+=hMap.getOrDefault(0,0);
            }else{
                count+=hMap.getOrDefault(60-t%60,0);
            }
            hMap.merge(t%60,1,Integer::sum);
        }
        return count;
    }
}