class Solution {
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;
        k=k%n;
        k = n-k;
        int[] temp = new int[k];
        for( int i = 0; i<k;i++){
            temp[i] = nums[i];
        }
        for( int i = k; i < n; i++){
            nums[i-k] = nums[i];
        }
        for(int i = n-k;i < n;i++){

            nums[i] = temp[i-n+k];
        }

    }
}