class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0, pro = 1;
        int num = n;
        while(num != 0){
            int digit = num % 10;
            sum += digit;
            pro *= digit;
            num /= 10;
        }
        int div = sum + pro;
        if( n % div == 0) return true;
        else return false;
        
    }
}