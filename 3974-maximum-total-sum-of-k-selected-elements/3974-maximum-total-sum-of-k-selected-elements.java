class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        int n = nums.length;
        Arrays.sort(nums);
        long ans = 0;
        long[]selected = new long[k];
        for(int i = 0; i < k; i++){
            selected[i] = nums[n-1-i];
            ans+=selected[i];
            
        }
        Arrays.sort(selected);
        ArrayList<Long> coeffs = new ArrayList<>();
        for(int i =0; i < k; i++){
            long c = (long) mul -1 -i;
            if(c>0) coeffs.add(c);
        }
        int p = coeffs.size();
        for(int i =0; i < p; i++){
            ans+= selected[k-1-i] *coeffs.get(i);
        }
        return ans;
    }
}