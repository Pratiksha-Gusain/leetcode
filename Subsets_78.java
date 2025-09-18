class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        findSubsets(nums, 0, new ArrayList<>());
        return result;
    }
    public void findSubsets(int[] nums,int i, List<Integer> sublist){
        if(i==nums.length){
            result.add(new ArrayList<>(sublist));
            return;
        }
        sublist.add(nums[i]);
        findSubsets(nums,i+1,sublist);
        sublist.remove(sublist.size()-1);
        findSubsets(nums,i+1,sublist);
    }
}