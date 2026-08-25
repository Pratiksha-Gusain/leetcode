class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int mul = k;
        int i = 2;
        while(set.contains(mul)){
            mul = k*i;
            i++;
        }
        return mul;
    }
}