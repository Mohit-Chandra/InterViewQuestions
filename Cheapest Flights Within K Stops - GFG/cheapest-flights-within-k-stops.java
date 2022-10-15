//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
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
            pq.remove();
            int currSrc = curr[0], currDist = curr[1], currK = curr[2];
            if(currK > k)
                continue;
            for(int nbrArr[] : graph[currSrc]){
                int nbr = nbrArr[0];
                int nbrWt = nbrArr[1];
                
                if(currDist+nbrWt < dist[nbr] && currK<=k){
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