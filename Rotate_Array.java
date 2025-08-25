class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        int j= nums.length-k;
        int [] rotated=new int[nums.length];
        for(int i=0; i< nums.length; i++){
            rotated[i]=nums[Math.abs(i+j)%nums.length];
        }
        for(int i=0; i< nums.length; i++){
            nums[i]=rotated[i];
        }
    }
}