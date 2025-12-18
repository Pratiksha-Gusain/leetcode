class Solution {
    public int[] findErrorNums(int[] nums) {
        int[]  ans= new int[2];
        int[] hash = new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            hash[nums[i]]++;
        }
        for(int i=1;i<hash.length;i++){
            if(hash[i]==2) ans[0]=i;
            if(hash[i]==0) ans[1]=i;
        }
        return ans;
    }

}