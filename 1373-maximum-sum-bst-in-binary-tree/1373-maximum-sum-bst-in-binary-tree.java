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
 class Node{
    int min;
    int max;
    int sum;
    Node(int min,int max,int sum){
        this.min=min;
        this.max=max;
        this.sum=sum;
    }
}
class Solution {
    int sum=0;
    public int maxSumBST(TreeNode root) {
        helper(root);
        return sum;
    }
    public Node helper(TreeNode root){
        if(root==null) return new Node(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        Node left=helper(root.left);
        Node right=helper(root.right);
        if(left.max<root.val && root.val<right.min){
            int m=Math.max(left.sum,right.sum);
            int mm=Math.max(m,left.sum+right.sum+root.val);
            sum=Math.max(sum,mm);
            return new Node(Math.min(left.min,root.val),Math.max(root.val,right.max),left.sum+right.sum+root.val);
        }
        return new Node(Integer.MIN_VALUE,Integer.MAX_VALUE,0);
    }
}