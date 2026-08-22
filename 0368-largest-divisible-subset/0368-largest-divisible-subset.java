class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<Integer>();
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] hash = new int[n];

        int max = 0;
        int lastInd = 0;

        for(int i = 0; i < n; i++){
            hash[i] = i;
            for(int prev = 0; prev < i; prev++){
                if(nums[i]% nums[prev] == 0 && 1+dp[prev] > dp[i]){
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }
            if(dp[i] > max){
                max = dp[i];
                lastInd = i;
            }
        }
        while(hash[lastInd] != lastInd){
            ans.add(nums[lastInd]);
            lastInd = hash[lastInd];
        }
        ans.add(nums[lastInd]);
        return ans;
        
    }
}