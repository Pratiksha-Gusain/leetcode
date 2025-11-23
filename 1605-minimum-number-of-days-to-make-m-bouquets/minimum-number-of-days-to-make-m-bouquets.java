class Solution {
    public boolean possible(int[] arr, int day,int m,int k){
        int noOfBouquets=0;
        int cnt=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=day){
                cnt++;
            }
            else{
                noOfBouquets+=cnt/k;
                cnt=0;
            }
        }
        noOfBouquets+=cnt/k;
        if(noOfBouquets>=m) return true;
        return false;
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
        while(low<=high){
            int mid=low+(high-low)/2;
            if(possible(bloomDay,mid,m,k)) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
}