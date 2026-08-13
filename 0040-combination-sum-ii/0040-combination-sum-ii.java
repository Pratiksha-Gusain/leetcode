import java.util.*;
class Solution {
    public void findComb(int ind, int[] candidates, int target, List<List<Integer>> ans, List<Integer> temp){
        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = ind; i < candidates.length; i++){
            if(i > ind && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) break;
            temp.add(candidates[i]);
            findComb(i+1, candidates, target-candidates[i], ans, temp);
            temp.remove(temp.size()-1);
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findComb(0,candidates,target,ans, new ArrayList<>());
        return ans;
    }
}