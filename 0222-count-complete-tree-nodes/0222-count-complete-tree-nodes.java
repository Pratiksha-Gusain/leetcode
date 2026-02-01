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
    public int countNodes(TreeNode root) {
        int leftdepth =leftdepth(root);
        int rightdepth = rightdepth(root);
        if(leftdepth==rightdepth) return (int) Math.pow(2,leftdepth)-1;
        else return 1+countNodes(root.left)+countNodes(root.right);
    }
    int leftdepth(TreeNode root){
        int depth=0;
        while(root!=null){
            root=root.left;
            depth++;
        }
        return depth;
    }
    int rightdepth(TreeNode root){
        int depth=0;
        while(root!=null){
            root=root.right;
            depth++;
        }
        return depth;
    }
}