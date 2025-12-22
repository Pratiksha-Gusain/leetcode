class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findSubsets(nums, 0, new ArrayList<>(),result);
        return result;
    }
    public void findSubsets(int[] nums,int i, List<Integer> sublist,List<List<Integer>> result){
        if(i==nums.length){
            result.add(new ArrayList<>(sublist));
            return;
        }
        sublist.add(nums[i]);
        findSubsets(nums,i+1,sublist,result);
        sublist.remove(sublist.size()-1);
        findSubsets(nums,i+1,sublist,result);
    }
}