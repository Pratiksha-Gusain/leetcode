class Solution {
    public List<Integer> findValidElements(int[] nums) {
        int n = nums.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        int lmax = nums[0];
        int rmax = nums[0];

        List<Integer> result = new ArrayList<>();

        if (n == 1) {
            result.add(nums[0]);
            return result;
        }

        maxLeft[0] = nums[0];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], nums[i]);
        }
        maxRight[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], nums[i]);
        }

        result.add(nums[0]);

        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > maxLeft[i - 1] || nums[i] > maxRight[i + 1]) {
                result.add(nums[i]);
            }
        }

        result.add(nums[n - 1]);

        return result;

    

    }
}