class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int tar = 0; tar <= amount; tar++){
            if(tar%coins[0] == 0){
                dp[0][tar] = tar/coins[0];
            }
            else{
                dp[0][tar] = Integer.MAX_VALUE;
            }
        }

        for(int i = 1; i < n; i++){
            for(int j = 0; j <= amount; j++){
                int notTake = dp[i-1][j];
                int take = Integer.MAX_VALUE;
                if(coins[i] <= j && dp[i][j-coins[i]] != Integer.MAX_VALUE){
                    take = 1 +  dp[i][j-coins[i]];
                }
                dp[i][j] = Math.min(take, notTake);
            }
        }
        int ans = dp[n-1][amount];
        if( ans != Integer.MAX_VALUE) return ans;
        return -1;

    }
}