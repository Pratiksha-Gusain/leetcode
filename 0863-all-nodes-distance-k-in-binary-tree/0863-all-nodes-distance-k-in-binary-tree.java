/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer,TreeNode> parent = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left!=null){
                    parent.put(curr.left.val,curr);
                    q.offer(curr.left);
                }
                 if(curr.right!=null){
                    parent.put(curr.right.val,curr);
                    q.offer(curr.right);
                }
            }
            
        }
        Map<Integer,Integer> visited = new HashMap<>();
        q.offer(target);
        while(k>0 &&!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                visited.put(curr.val,1);
                if(curr.left!=null&&!visited.containsKey(curr.left.val))
                    q.offer(curr.left);
                if(curr.right!=null&&!visited.containsKey(curr.right.val))
                    q.offer(curr.right);
                if(parent.containsKey(curr.val)&& !visited.containsKey(parent.get(curr.val).val))
                    q.offer(parent.get(curr.val));
                
            }
            k--;

        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
}