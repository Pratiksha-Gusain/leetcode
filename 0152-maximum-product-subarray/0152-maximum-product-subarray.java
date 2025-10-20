class Solution {
    public int maxProduct(int[] nums) {
        int leftProduct =1;
        int rightProduct =1;
        int n = nums.length;
        int max = nums[0];

        for(int i =0;i<n;i++){
            leftProduct = leftProduct==0?1:leftProduct;
            rightProduct= rightProduct==0?1:rightProduct;

            leftProduct *= nums[i];
            rightProduct *= nums[n-i-1];

            max = Math.max(max,Math.max(leftProduct,rightProduct));
        }
        return max;

    }
}