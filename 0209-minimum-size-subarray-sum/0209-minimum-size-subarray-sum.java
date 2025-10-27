class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum=0;
        int i=0;
        int j=0;
        int minSize= Integer.MAX_VALUE;
        while(j<nums.length){
            sum+=nums[j];
            j++; 
            while(sum>=target){
                int size= j-i;
                minSize= Math.min(size,minSize);
                sum-=nums[i];
                i++;
            }
        }
        return minSize==Integer.MAX_VALUE?0:minSize;
    }
}