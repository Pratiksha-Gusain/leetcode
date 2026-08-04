class Solution {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int count = 0;
        int even = 0;
        int odd =0;
        for(int i =0; i < nums.length; i++){
            odd = 0;
            even = 0;
            for(int j = i; j< nums.length; j++){
                 if((nums[j] & 1) == 0) even++;
                 else odd++;
                 if(odd >= 0 && (long) even * b <= (long) odd * a) count++;
                
            }
        }
        return count;
        
    }
}