//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        TreeSet<int[]> ts = new TreeSet<>((a,b) -> {
            if(Integer.compare(a[1],b[1]) == 0){
                return Integer.compare(a[0],b[0]);
            }
            else{
                return Integer.compare(a[1],b[1]);
             }
            });
        int dist[] = new int[V];
        Arrays.fill(dist,(int)1e9);
        dist[S] = 0;
        
        ts.add(new int[]{S,0});
        while(!ts.isEmpty()){
            int curr[] = ts.pollFirst();
            int src = curr[0], wt = curr[1];
           
            for(int i=0;i<adj.get(src).size();i++){
                ArrayList<Integer> nbrList = adj.get(src).get(i);
                int nbr = nbrList.get(0), edgeWt = nbrList.get(1);
                if(wt + edgeWt < dist[nbr]){
                    // erase if it existed with not infinity value
                    // meaning someone has reached
                    if(dist[nbr]!=(int)1e9){
                        ts.remove(new int[]{nbr, dist[nbr]});
                    }
                    dist[nbr] = wt+edgeWt;
                     //System.out.println(nbr+" "+dist[nbr]);
                    ts.add(new int[]{nbr, dist[nbr]});
                    
                }
            }
        }
        return dist;
    }
}

