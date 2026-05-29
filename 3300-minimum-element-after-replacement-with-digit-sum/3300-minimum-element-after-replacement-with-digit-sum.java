class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i ++){
            nums[i] = sumOfDigits(nums[i]);
            min = Math.min(min, nums[i]);
        }
        return min;
    }
    public int sumOfDigits(int n){
        int sum = 0;
        while(n != 0){
            int rem = n%10;
            sum += rem;
            n /= 10;
        }
        return sum;
    }
}