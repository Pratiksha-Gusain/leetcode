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
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root)!=-1;
    }
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int leftheight=maxDepth(root.left);
        if(leftheight==-1) return -1;
        int rightheight=maxDepth(root.right);
        if(rightheight==-1) return -1;
        if(Math.abs(rightheight-leftheight)>1) return -1;
        return 1+ Math.max(leftheight,rightheight);
    }
}