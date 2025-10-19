class Solution {
    public void swap(int[] nums, int a, int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    public void sortColors(int[] nums) {
        int start =0;
        int middle =0;
        int end =nums.length-1;
        while(middle<=end){
            switch(nums[middle]){
                case 0:
                    swap(nums,start,middle);
                    middle++;
                    start++;
                    break;
                case 1:
                    middle++;
                    break;
                case 2:
                swap(nums,middle,end);
                end--;
                break;
            }
        }
    }
}