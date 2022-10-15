class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        
        ArrayList<int[]> graph[] = new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int flight[] : flights){
            int sr = flight[0], nbr = flight[1], edgeWt = flight[2];
            graph[sr].add(new int[]{nbr,edgeWt});
        }
        
        Queue<int[]> pq = new LinkedList<>();
        int dist[] = new int[n];
        Arrays.fill(dist,(int)1e9);
        dist[src] = 0;
        pq.add(new int[]{src,0,0});
        
        while(!pq.isEmpty()){
            int curr[] = pq.peek();
            int currSrc = curr[0], currDist = curr[1], currK = curr[2];
            pq.remove();
            if(currK > k)
                continue;
            for(int nbrArr[] : graph[currSrc]){
                int nbr = nbrArr[0];
                int nbrWt = nbrArr[1];
                
                if(currDist+nbrWt < dist[nbr] && currK<=k){
                    System.out.println(nbr+" "+nbrWt+" "+currK+1);
                    dist[nbr] = currDist+nbrWt;
                    pq.offer(new int[]{nbr,dist[nbr], currK+1});
                }
            }
        }
        
        if(dist[dst] == (int)1e9)
            return -1;
        else
         return dist[dst];
    }
}