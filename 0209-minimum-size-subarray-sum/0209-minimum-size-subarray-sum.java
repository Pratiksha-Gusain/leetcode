class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum=0;
        int i=0;
        int j=0;
        int minSize= Integer.MAX_VALUE;
        while(j<nums.length){
            sum+=nums[j];
            while(sum>=target){
                int size= j-i+1;
                minSize= Math.min(size,minSize);
                sum-=nums[i];
                i++;
            }
            j++;
        }
        return minSize==Integer.MAX_VALUE?0:minSize;
    }
}