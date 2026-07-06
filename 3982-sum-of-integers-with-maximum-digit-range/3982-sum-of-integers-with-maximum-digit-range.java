class Solution {
    public int maxDigitRange(int[] nums) {
        int max = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i ++){
            int curr = getRange(nums[i]);
            if(curr > max){
                max = curr;
                sum = nums[i];
            }
            else if(curr == max)
                sum += nums[i];
            
        }
        return sum;
    }
        
    private int getRange(int num){
        if(num == 0) return 0;
        int maxDigit = 0;
        int minDigit = 9;
        while( num > 0 ){
            int d = num % 10;
            maxDigit=Math.max(maxDigit, d);
            minDigit = Math.min(minDigit, d);
            num /=10;
        }
        return maxDigit-minDigit;
    }
}