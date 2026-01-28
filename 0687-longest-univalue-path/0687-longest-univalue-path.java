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
    int ans=0;
    int func(TreeNode root,int prev){
        if(root==null) return 0;
        int left=func(root.left,root.val);
        int right=func(root.right,root.val);
        ans=Math.max(ans,left+right);
        if(root.val==prev) return Math.max(left,right)+1;
        else return 0;

    }
    public int longestUnivaluePath(TreeNode root) {
        func(root,-1);
        return ans;
    }
}