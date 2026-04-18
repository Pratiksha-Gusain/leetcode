class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] ahead = new int[2][3];
        int[][] cur = new int[2][3];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) { 
                for (int cap = 1; cap <= 2; cap++) {
                    if (buy == 0) {
                        cur[buy][cap] = Math.max(ahead[0][cap],
                                -prices[ind] + ahead[1][cap]);
                    } else {
                        cur[buy][cap] = Math.max(ahead[1][cap],
                                prices[ind] + ahead[0][cap - 1]);
                    }
                }
            }
            for (int i = 0; i < 2; i++) {
                System.arraycopy(cur[i], 0, ahead[i], 0, 3);
            }
        }

        return ahead[0][2];
    }
}