class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n ; i++){
            int req = target-nums[i];
            if(map.containsKey(req)){
                ans[0] = map.get(req);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i], i);
        }
        return new int[] {-1,-1};

    }
}