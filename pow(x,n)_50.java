class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1.0;
        if(x==0) return 0.0;
        if(x==1) return 1.0;
        if(x==-1 && n%2 ==0) return 1.0;
        if(x==-1 && n%2!=0) return -1.0;
        long nn =n;
        if(n<0){
            x=1/x;
            nn=-nn;
        }
        double ans =1;

        while(nn>0){
            if(nn%2==1){
                ans*=x;
                nn=nn-1;
            }  
            else{
            x*=x;
            nn/=2;
            }
        }
        return ans;
    }
}