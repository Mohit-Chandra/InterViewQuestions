class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null)
            return 0;
        int n = prices.length;
        int maxProfit = 0,minPrice = prices[0];
        for(int i=1;i<n;i+=1){
            maxProfit = Math.max(maxProfit,prices[i]-minPrice);
            minPrice = Math.min(minPrice,prices[i]);
        }
        return maxProfit;
    }
}