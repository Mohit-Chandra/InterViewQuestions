class Solution {
    /**
    
    [3,4,2]
     3 4  
    [2,2,3,3,3,4]
    
    2 2 4 -> 8
    3 3 3 -> 9
    4 2 2 -> 8
    
    2->4
    3->9
    4->4
    
    2 -> 8
    4 -> 4
    
    **/
    public int deleteAndEarn(int[] nums) {
        int sortedNums[] = Arrays.stream(nums).sorted().distinct().toArray();
        Map<Integer, Integer> costMap = Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(i -> i)));
        System.out.println(costMap);
        int ppCost = 0,pCost = costMap.get(sortedNums[0]);
        for(int i=1;i<sortedNums.length;i+=1){
            int currCost = costMap.get(sortedNums[i]);
            int c = sortedNums[i]!=sortedNums[i-1]+1 ? pCost+currCost : Math.max(ppCost + currCost, pCost);
            ppCost = pCost;
            pCost = c;
        }
        return pCost;
    }
}