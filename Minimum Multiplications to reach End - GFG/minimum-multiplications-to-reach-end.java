//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        int n = arr.length;
        Queue<int[]> q = new LinkedList<>();
        int mod = 100000;
        int dist[] = new int[mod];
        dist[start] = 1;
        q.add(new int[]{start,0});
        while(!q.isEmpty()){
            int curr[] = q.poll();
            int nextStart = curr[0];
            int steps = curr[1];
            for(int i=0;i<n;i++){
                int num = (nextStart*arr[i])%mod;
                 if(num == end)
                        return steps+1;
                if(dist[num] == 0){
                    dist[num] = 1;
                    q.add(new int[]{num, steps+1});
                }
            }
        }
        return -1;
    }
}
