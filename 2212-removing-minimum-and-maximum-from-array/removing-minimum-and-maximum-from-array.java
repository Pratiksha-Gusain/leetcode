class Solution {
    public int minimumDeletions(int[] nums) {
        if(nums.length==1) return 1;
        int minIndex=0;
        int maxIndex=0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]<nums[minIndex])
                minIndex = i;
            if(nums[i]>nums[maxIndex])
                maxIndex = i;
        }
        if(minIndex>maxIndex){
            int temp = minIndex;
            minIndex = maxIndex;
            maxIndex = temp;
        }

        int deleteFront = maxIndex+1;
        int deleteBack = nums.length-minIndex;
        int deleteBoth = minIndex+1+nums.length-maxIndex;
        return Math.min(deleteFront,Math.min(deleteBack,deleteBoth));
    }
}