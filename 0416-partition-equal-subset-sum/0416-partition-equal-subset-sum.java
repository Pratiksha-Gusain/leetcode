class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalsum =0;
        for(int num : nums){
            totalsum+=num;
        }
        if(totalsum%2 != 0){
            return false;
        }
        int target = totalsum/2;
        boolean[] prev = new boolean[target+1];
        prev[0] = true;
        for(int i = 1; i < n; i++){
            boolean[] curr = new boolean[target+1];
            curr[0]= true;
            for (int sum = 1; sum <= target; sum++) {
                boolean notTaken = prev[sum];
                boolean taken = false;
                if(nums[i] <= sum){
                    taken = prev[sum - nums[i]];
                }
                curr[sum] = taken || notTaken;
            }
            prev = curr;
        }
        return prev[target];
    }
}