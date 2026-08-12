class Solution {
    public void solve(int[] candidates, int i, int n, int target, List<List<Integer>> ans, List<Integer>temp){
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if (i == n) {
            return;
        }
        
        if(candidates[i] <= target){
            temp.add(candidates[i]);
            solve(candidates, i, n, target-candidates[i], ans, temp);
            temp.remove(temp.size()-1);
        }
        
        solve(candidates, i+1, n, target, ans, temp);


    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = candidates.length;
        solve(candidates, 0, n, target, ans, new ArrayList<>());
        return ans;
    }
}