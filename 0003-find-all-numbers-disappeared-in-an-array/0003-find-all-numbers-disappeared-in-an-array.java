class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> a =new HashSet<>();
        for(int num:nums) a.add(num);
        List<Integer> ans = new ArrayList<>();
        for(int i=1;i<=nums.length;i++){
            if((!a.contains(i)))
                ans.add(i);
        }
        return ans;
    }
}