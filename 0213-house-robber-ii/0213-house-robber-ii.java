class Solution {
    public int rob(int[] nums,int start,int end) {
        int n=nums.length;
        int prev =nums[start];
        int prev2=0;
        for(int i=start+1;i<=end;i++){
           int pick = nums[i];
           if(i>1) pick+=prev2;
           int notpick = 0+prev;
           int curr = Math.max(pick,notpick);
           prev2=prev;
           prev=curr;
        }
        return prev;
    }
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        return Math.max(rob(nums,0,nums.length-2),rob(nums,1,nums.length-1));
    }
}