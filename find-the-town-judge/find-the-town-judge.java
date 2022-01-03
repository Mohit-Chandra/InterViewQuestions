class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] degree = new int[n+1];
        for(int[] t: trust){
            degree[t[0]]-=1;
            degree[t[1]]+=1;
        }
        for(int i=1;i<=n;i+=1){
            if(degree[i] == n-1)
                return i;
        }
        return -1;
    }
}