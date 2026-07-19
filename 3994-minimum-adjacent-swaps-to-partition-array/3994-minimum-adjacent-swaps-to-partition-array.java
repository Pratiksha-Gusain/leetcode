class Solution {
    public int minAdjacentSwaps(int[] nums, int a, int b) {
        long swaps = 0;
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        long MOD = 1000000007;
        for(int num : nums){
            if(num < a){
                swaps = (swaps+c2+c3)%MOD;
                c1++;
            }
            else if(num <= b){
                swaps = (swaps+c3)%MOD;
                c2++;
            }
            else{
                c3++;
            }
        }
        return (int)swaps;
    }
}