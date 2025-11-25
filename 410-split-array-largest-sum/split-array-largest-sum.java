class Solution {
    public int countPartitions(int[] nums,int maxSum){
        int partitions=1;
        long subarraySum=0;
        for(int i=0;i<nums.length;i++){
            if(subarraySum+nums[i]<=maxSum) subarraySum+=nums[i];
            else{
                partitions++;
                 subarraySum=nums[i];
            }
        }
        return partitions;
    }
    public int splitArray(int[] nums, int k) {
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int i=0;i<nums.length;i++){
            low=Math.max(low,nums[i]);
            high+=nums[i];
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            int partitions=countPartitions(nums,mid);
            if(partitions>k) low=mid+1;
            else high=mid-1;
        }
        return low;
    }
}