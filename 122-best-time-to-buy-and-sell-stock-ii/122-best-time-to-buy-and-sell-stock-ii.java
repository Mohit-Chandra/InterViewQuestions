class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null)
            return 0;
        int n = prices.length;
        int maxProfit = 0;
        for(int i=1;i<n;i+=1){
            if(prices[i] > prices[i-1])
                maxProfit+=prices[i]-prices[i-1];
        }
        return maxProfit;
    }
}