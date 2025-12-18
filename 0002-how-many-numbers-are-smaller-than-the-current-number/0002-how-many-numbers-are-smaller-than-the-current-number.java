class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] all = new int[101];
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            all[nums[i]]++;
        }
        for(int i=1;i<101;i++){
            all[i] +=all[i-1];
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) res[i]=0;
            else res[i]=all[nums[i]-1];
        }
        return res;
    }
}