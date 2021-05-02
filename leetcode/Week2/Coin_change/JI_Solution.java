package leetcode.Week2.Coin_change;

public class JI_Solution {
    int[][] dp;
    final int MAX = 100000;
    public int coinChange(int[] coins, int amount) {
        dp = new int[12][10000];
        for(int i=0;i<12;i++)
            for (int j = 0; j < 10000; j++) {
                dp[i][j] = -1;
            }
        int ret = solve(0,coins,amount);
        return ret == MAX ? -1 : ret;
    }

    int solve(int now, int[] coins,int amount){
        if(now >= coins.length)
            return MAX;
        if(amount < 0)
            return MAX;
        if(amount == 0)
            return 0;

        if(dp[now][amount] != -1)
            return dp[now][amount];

        dp[now][amount] = Math.min(solve(now,coins,amount-coins[now])+1, solve(now+1,coins,amount) );
        return dp[now][amount];
    }
}
