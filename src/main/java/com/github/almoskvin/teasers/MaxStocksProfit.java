package com.github.almoskvin.teasers;

import java.util.List;

/**
 * Create a method that would return the maximum profit for the day given certain conditions such like only buy and sell once,
 * the difference between buy and sell time must be at least five seconds long.
 * The difference in time between each stock price is 1 second long,
 * stock prices are already in order by time, if there is not profit for the day, return 0.
 */
public class MaxStocksProfit {

    /**
     * O(N) complex solution.
     * For this should be used an array with max values AFTER the current element in the <i>prices</i>.
     * Max values array fills up starting from the end of it, by comparing a previous value  (closer to the end) with a current value in the <i>prices</i>.
     * So later when we loop through the <i>prices</i>, for each position we know the max value in the array AFTER this element.
     * Keeping in mind, we need to compare values only after 5 elements or so, we adjust a final comparison so
     * we can get a max value starting from the 5th position from the current element.
     *
     * @param prices range of prices sorted by time
     * @return maximum profit over the period of 5 days
     */
    public long getMaxProfit(long[] prices) {
        int len = prices.length;
        long[] maxPricesAfter = new long[len];
        maxPricesAfter[len - 1] = 0L;
        for (int i = len - 2; i >= 0; i--) {
            maxPricesAfter[i] = Math.max(maxPricesAfter[i + 1], prices[i + 1]);
        }
        long result = 0L;
        for (int i = 0; i < len - 6; i++) {
            result = Math.max(result, maxPricesAfter[i + 5] - prices[i]);
        }
        return result;
    }

    public long getMaxProfit(List<Long> prices) {
        return getMaxProfit(prices.stream().mapToLong(v -> v).toArray());
    }
}
