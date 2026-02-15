class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int size=0;
        for(int num :nums){
            set.add(num);
        }
        for(int i : set){
            if(!set.contains(i-1)){
                int curr = i;
                int currsize =1;
            
                while(set.contains(curr+1)){
                    curr++;
                    currsize++;
                }
                size = Math.max(size,currsize);
            }
        }
        return size;
    }
}