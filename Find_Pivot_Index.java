class Solution {
    public int pivotIndex(int[] nums) {
        int sum=0;
        int sum1=0;
        int sum2=0;
        for(int i=0;i<nums.length;i++)
          sum+=nums[i];
         for(int i=0;i<nums.length;i++)  
         {   sum2=sum-sum1-nums[i];
            if(sum1==sum2)
               return i;
            sum1+=nums[i]; 
         }  
        return -1;    
    }
}