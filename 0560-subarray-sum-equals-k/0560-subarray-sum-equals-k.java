class Solution {
    public int subarraySum(int[] nums, int k) {
        int res=0;
        int curr=0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        for(int i = 0; i < nums.length; i++){
            curr += nums[i];
            if(hm.containsKey(curr-k)){
                res += hm.get(curr-k);
            }
            hm.put(curr, hm.getOrDefault(curr, 0)+1);
        }
        return res;
    }
}