package com.github.almoskvin.teasers;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is
 * that adjacent houses have security systems connected and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */
public class HouseRobber {
    public static int rob(int[] nums) {
        int lastMax;
        int currentMax = 0;
        int result = 0;
        for(int n : nums){
            lastMax = currentMax;
            currentMax = result;
            result = Math.max(n + lastMax, currentMax);
        }
        return result;
    }
}
