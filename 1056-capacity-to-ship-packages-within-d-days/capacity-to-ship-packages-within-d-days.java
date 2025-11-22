class Solution {
    public int findDays(int[] weights,int capacity){
        int days=1;
        int load=0;
        for(int i=0;i<weights.length;i++){
            if(load+weights[i]>capacity){
                days+=1;
                load=weights[i];
            }
            else{
                load+=weights[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int i=0;i<weights.length;i++){
            if(weights[i]>low) low=weights[i];
            high+=weights[i];
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            int reqDays=findDays(weights,mid);
            if(reqDays<=days) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
}