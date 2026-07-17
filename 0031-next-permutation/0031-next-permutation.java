class Solution {
    public void swap(int[] nums, int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    public void reverse(int nums[], int start,int end){
        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }

    }
    public void nextPermutation(int[] nums) {
        int ind = -1;
        for(int i = nums.length-1; i > 0; i--){
            if(nums[i-1] < nums[i]){
                ind = i-1;
                break;
            }
        }
        if(ind == -1){
            reverse(nums, 0, nums.length-1);
        }
        else{
            for(int i = nums.length-1; i >= ind; i--){
                if(nums[i] > nums[ind]){
                    swap(nums, i, ind);
                    break;
                }
            }
            reverse(nums, ind+1, nums.length-1);
        }
    }
}