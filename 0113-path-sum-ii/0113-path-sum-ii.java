/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root,targetSum,0,new ArrayList<>(), ans );
        return ans;
    }
    public void dfs(TreeNode root, int targetSum,int currSum,List<Integer>temp, List<List<Integer>> ans){
        if(root==null) return;
        currSum+=root.val;
        temp.add(root.val);
        if(root.left==null && root.right==null&&currSum==targetSum){
            ans.add(new ArrayList<>(temp));
        }
        dfs(root.left,targetSum,currSum,temp,ans);
        dfs(root.right,targetSum,currSum,temp,ans);
        temp.remove(temp.size()-1);
    }
}