class Solution {
    /**
       [[9,0,1],[3,3,7]]
        4
        
        0  0  0  0  0  0  0   0   0   0
        9 -9     3           -3
        9  0  0. 3. 3. 3. 3.  0
       
    **/
    public boolean carPooling(int[][] trips, int capacity) {
        int dist[] = new int[1002];
        for(int trip[] : trips){
            int numPassenger = trip[0];
            int from = trip[1];
            int to = trip[2];
            dist[from]+=numPassenger;
            dist[to]+=-numPassenger;
        }
        for(int i=0;i<1002;i+=1){
            if(i!=0){
                dist[i]+=dist[i-1];
            }
            if(dist[i] > capacity){
                return false;
            }
        }
        return true;
    }
}