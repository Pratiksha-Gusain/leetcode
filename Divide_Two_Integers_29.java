import java.util.*;
class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(divisor ==1) return dividend;
        boolean sign = true;
        if(dividend>=0 && divisor<0) sign = false;
        if(dividend<0 && divisor>0) sign = false;
        long n= dividend;
        long d = divisor;
        n= Math.abs(n);
        d=Math.abs(d);
        long ans =0,sum=0;
        while(sum+d<=n){
            ans++;
            sum+=d;
        }
        if(ans > Integer.MAX_VALUE && sign) return Integer.MAX_VALUE;
        if(ans > Integer.MAX_VALUE && !sign) return Integer.MIN_VALUE;
        return sign? (int)ans:(int)(-1*ans);

    }
}