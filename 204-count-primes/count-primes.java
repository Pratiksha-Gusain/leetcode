class Solution {
    public int countPrimes(int n) {
        if(n<2) return 0;
        int count=0;
        int[] prime = new int[n];
        for(int i=2;i<prime.length;i++) prime[i]=1;
        for(int i=2;i*i<=prime.length;i++){
            if(prime[i]==1){
                for(int j=i*i;j<prime.length;j+=i){
                    prime[j]=0;
                }
            }
        }
        for(int i=2;i<prime.length;i++){
            if(prime[i]==1) count++;
        }
        return count;


    }
}