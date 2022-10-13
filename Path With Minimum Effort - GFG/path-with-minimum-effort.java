//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends


class Solution {
    
    int MinimumEffort(int heights[][]) {
        int rowLen = heights.length;
        int colLen = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        pq.offer(new int[]{0,0,0});
        
       
        int dist[][] = new int[rowLen][colLen];
        for(int i=0;i<rowLen;i++){
            for(int j=0;j<colLen;j++){
                dist[i][j] = (int)1e9;
            }
        }
        dist[0][0] = 0;
        int dirs[][] = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        while(pq.size()>0){
            int curr[] = pq.poll();
            int currRow = curr[0],currCol = curr[1], currWt = curr[2];
            // if(currRow == rowLen-1 && colLen-1 == currCol)
            //     return currWt;
            for(int dir[] : dirs){
                int nextRow = currRow+dir[0];
                int nextCol = currCol+dir[1];
                if(nextRow >= rowLen || nextCol >= colLen || nextRow<0 || nextCol<0){
                    continue;
                }
                int newEffort = Math.max(Math.abs(heights[nextRow][nextCol] 
                                        - heights[currRow][currCol]), currWt);
                if(newEffort < dist[nextRow][nextCol]){
                    dist[nextRow][nextCol] = newEffort;
                    pq.offer(new int[]{nextRow,nextCol, newEffort});
                }
            }
        }
        return dist[rowLen-1][colLen-1];
       
    }
}