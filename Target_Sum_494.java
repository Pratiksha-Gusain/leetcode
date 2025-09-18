class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        for(int num:nums){
            Map<Integer, Integer> nexthm = new HashMap<>();
            for(int sum: hm.keySet()){
                int count = hm.get(sum);
                nexthm.put(sum+num, nexthm.getOrDefault(sum+num,0)+count);
                nexthm.put(sum-num,nexthm.getOrDefault(sum-num,0)+count);
            }
            hm=nexthm;
        }
        return hm.getOrDefault(target,0);
    }
}