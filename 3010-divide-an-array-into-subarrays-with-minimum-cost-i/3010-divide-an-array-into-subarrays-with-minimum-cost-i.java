class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (nums[i] < a) {
                b = a;
                a = nums[i];
            } else if (nums[i] < b)
                b = nums[i];
        }
        return nums[0] + a + b;
    }
}