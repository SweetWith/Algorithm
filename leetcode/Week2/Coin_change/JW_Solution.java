package leetcode.Week2.Coin_change;

public class JW_Solution {
    public static void main(String[] args) {
        JW_Solution jw = new JW_Solution();

        int[] nums = {186,419,83,408};
        
        System.out.println(jw.coinChange(nums, 6249));
    }

    public int coinChange(int[] coins, int amount) {
    
        int Max = 987654321;            
        int[] dp = new int[1000001];
        int ans = Max;
        
        if(amount == 0) return 0;

        for(int i = 1; i < 1000001; i++) {
            dp[i] = Max;
        }

        for(int i = 0; i < coins.length; i++) {

            if(coins[i] > amount) continue;

            for(int j = 0; j < amount + 1; j++) {
                if(dp[j] != Max && dp[j] + 1 < dp[j + coins[i]]) {
                    dp[j + coins[i]] = dp[j] + 1;
                    if(j == amount) {
                        ans = Math.min(ans, dp[j]);
                    }
                }
            }
        }

        if(ans == Max) {
            ans = -1;
        }
        
        return ans;
    }
}
