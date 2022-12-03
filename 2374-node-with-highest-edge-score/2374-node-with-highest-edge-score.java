class Solution {
    public int edgeScore(int[] edges) {
        if(edges == null || edges.length==0)
            return -1;
        Map<Integer,Long> freqMap = new TreeMap<>();
        for(int i=0;i<edges.length;i+=1){
            freqMap.put(edges[i],freqMap.getOrDefault(edges[i],0L)+i);
        }
        List<Long> freqList = new ArrayList<>(freqMap.values());
        Collections.sort(freqList);
        long maxEle = freqList.get(freqList.size()-1);
        for(Map.Entry<Integer,Long> entry : freqMap.entrySet()){
            int currKey = entry.getKey();
            long currVal = entry.getValue();
            if(currVal == maxEle)
                return currKey;
        }
        return -1;
    }
}