class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxcount = 0;
        for(int num : nums){
            set.add(num);
        }
        for(int num : set){
            if(set.contains(num-1)){
                continue;
            }
            int count = 1;
            while(set.contains(num+1)){
                num ++;
                count++;
            }
            maxcount = Math.max(maxcount, count);
        }
        return maxcount;
    }
}