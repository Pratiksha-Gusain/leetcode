class Solution {
    public int maxProduct(int n) {
        int max = 0,  secondMax = 0;
        while( n != 0){
            int digit = n%10;
            n /= 10;
            if(digit >= max){
                secondMax = max;
                max = digit;
                
            }
            else if (digit > secondMax){
                secondMax = digit;
            }
        }
        return max*secondMax;
        


    }
}