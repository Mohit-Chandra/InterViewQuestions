class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long inDegree[] = new long[n];
        for(int i=0;i<n;i+=1)
            inDegree[edges[i]]+=i;
        
        int maxIndex = 0;
        for(int i=0;i<n;i+=1){
            if(inDegree[i] > inDegree[maxIndex])
                maxIndex = i;
        }
        return maxIndex;
    }
}