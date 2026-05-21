package Arrays;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

//121. Best Time to Buy and Sell Stock
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int currLowest = prices[0];
        int maxProfit = 0;

        for(int i=1; i<prices.length; i++){
            if(prices[i]<currLowest){
                currLowest = prices[i];
            }
            //calculate max profit
            int profit = prices[i] - currLowest;
            if(profit>maxProfit){
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}
