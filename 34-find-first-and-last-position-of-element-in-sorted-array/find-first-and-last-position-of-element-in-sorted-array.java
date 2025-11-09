class Solution {
    public int firstOcc(int[] nums,int target){
        int first=-1;
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                first=mid;
                high=mid-1;
            } 
            else if(target>nums[mid]) low=mid+1;
            else high=mid-1;
        }
        return first;
    }
    public int lastOcc(int[] nums,int target){
        int last=-1;
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                last=mid;
                low=mid+1;
            } 
            else if(target>nums[mid]) low=mid+1;
            else high=mid-1;
        }
        return last;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans=new int[2];
        ans[0]=firstOcc(nums,target);
        ans[1]=lastOcc(nums,target); 
        return ans;
    }
}