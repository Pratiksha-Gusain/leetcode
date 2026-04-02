class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        if ((totalSum + target) % 2 != 0 || Math.abs(target) > totalSum) return 0;
        int newTarget = (totalSum + target) / 2;

        int[] dp = new int[newTarget+1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = newTarget; j >= num; j--) {
                dp[j] += dp[j-num];
            }
        }
        return dp[newTarget];
    }
}