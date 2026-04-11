class Solution {
    public int minOperations(int[] nums) {
        int c = 0;
        for(int n : nums){
            if( n == nums[0]) c++;
        }
        return c < nums.length? 1:0;
    }
}