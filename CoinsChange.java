// Time Complexity : O(mxn) where m is the different denominations of coins and n is the amount
// Space Complexity : O(mxn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class CoinsChange {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m + 1][n + 1];

        // filling the columns of the first row with a large number
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 999999;
        }

        // filling in rest of the table
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];

                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        if (dp[m][n] >= 999999)
            return -1;
        else
            return dp[m][n];
    }

    /*
     * //Exhaustive approach: time complexity is exponential
     * 
     * public int coinChange(int[] coins, int amount) {
     * return helper(coins, amount, 0, 0);
     * }
     * 
     * private int helper(int[] coins, int amount, int i, int minCoins){
     * //base case
     * if (amount == 0) return minCoins;
     * if(amount<0 || i==coins.length) return -1; // invalid conditions the path can
     * take you to
     * 
     * //logic
     * //helper(int[] coins, int amount, int i, int minCoins);
     * 
     * //case 1: choosing that index to make the amount
     * int case1 = helper(coins, amount - coins[i], i, minCoins+1);
     * //case 2: index i was not chosen to make the amount
     * int case2 = helper(coins, amount, i+1, minCoins);
     * 
     * if(case1 == -1) return case2;
     * if(case2 == -1) return case1;
     * 
     * return Math.min(case1,case2);
     * }
     */

}