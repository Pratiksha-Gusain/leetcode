class Solution {
    public boolean check(int[] nums) {
        int deviations=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>nums[(i+1)%nums.length]){
                deviations++;
            }
            if(deviations>1)
                return false;
            
        }
        return true;
    }
}