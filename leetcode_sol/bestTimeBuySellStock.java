/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/
public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(prices.length==0) return 0; 
        int min=prices[0], max=prices[0];
        int profit=0; 
        for(int i=1; i<prices.length; i++) {
            if(prices[i]>max) {
                max=prices[i];
            }
            if(prices[i]<min) {
                min=prices[i];
                max=prices[i]; 
            }
            profit=Math.max(profit, max-min);
        }
        return profit; 
    }
}
