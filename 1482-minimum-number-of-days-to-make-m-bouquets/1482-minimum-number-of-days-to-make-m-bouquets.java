class Solution {
    public boolean possible(int[] arr, int day,int m,int k){
        int c = 0, count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= day) count++;
            else{
                c += count/k;
                count = 0;
            }
        }
        c += count/k;
        return c >= m;
       
    }
    public int minDays(int[] bloomDay, int m, int k) {
        long req=(long)m*k;

        if(req>bloomDay.length) return -1;

        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            low=Math.min(bloomDay[i],low);
            high=Math.max(bloomDay[i],high);
        }
        while(low < high){
            int mid = low + (high-low)/2;
            if(possible(bloomDay, mid, m , k)){
                high = mid;
            }
            else low = mid+1;
        }
        return low;
       
    }
}