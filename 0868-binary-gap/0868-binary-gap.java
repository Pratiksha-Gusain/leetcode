class Solution {
    public int binaryGap(int n) {
        int max = 0;
        int curr = 0;
        boolean found = false;
        while( n > 0){
            int bit = n % 2;
            if( bit == 1){
                if(found){
                    max = Math.max(max, curr);
                }
                curr = 1;
                found = true;
            }
            else{
                if(found){
                    curr++;
                }
            }
            n /= 2;
        }
        return max;
    }
}