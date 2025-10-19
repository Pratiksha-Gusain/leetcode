class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int arr[]= new int[k];
        arr[0]= 1;
        int sum=0;
        int result=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int mod= sum%k;
            if(mod<0){
                mod+=k;
            }
            result= result+arr[mod];
            arr[mod]++;
        }
        return result;
    }
}