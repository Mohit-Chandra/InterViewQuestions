class Solution {
   
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int res = -1;
         Set<Integer> seen = new HashSet<>();
        for(int i=0;i<n;i+=1){
            if(seen.contains(i))
                continue;
            int dist = 0,index = i;
            Map<Integer,Integer> hMap = new HashMap<>(); //Stores index to dist map
            while( index!=-1 ){
                if(hMap.containsKey(index)){
                    res = Math.max(res,dist - hMap.get(index));
                    break;
                }
                if(seen.contains(index))
                    break;
                seen.add(index);
                hMap.put(index,dist++);
                index = edges[index];
            }
        }
        return res;
    }
}