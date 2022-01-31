class Solution {
    public int maximumWealth(int[][] accounts) {
        if(accounts == null)
            return 0;
        int n = accounts.length;
        int m = accounts[0].length;
        int maxWealth = -1;
        for(int i=0;i<n;i+=1){
            int wealth = 0;
            for(int j=0;j<m;j+=1){
                wealth+=accounts[i][j];
            }
            maxWealth = Math.max(maxWealth,wealth);
        }
        return maxWealth;
    }
}