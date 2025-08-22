class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int count=0;
        for(int i=0; i<n; i++){
            if(count<2 ||nums[i]!=nums[count-2] ){
                nums[count++]=nums[i];
            }
        }
        return count;
    }
}