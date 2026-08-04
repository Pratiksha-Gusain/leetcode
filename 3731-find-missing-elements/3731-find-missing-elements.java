class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        int start= nums[0];
        int end = nums[0];

        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
            start = Math.min(nums[i], start);
            end = Math.max(nums[i], end);
        }

        for(int i = start; i < end; i++){
            if(!set.contains(i)) ans.add(i);
        }
        return ans;
    }

}