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
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        buildGraph(root,0,map);
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        int min=0;
        while(!q.isEmpty()){
            int size= q.size();
            while(size>0){
                int node = q.poll();
                for(int num:map.get(node)){
                    if(!visited.contains(num)){
                        q.add(num);
                        visited.add(num);
                    }
                }
                size--;
            }
            min++;
        }
        return min-1;
    }
    void buildGraph(TreeNode node,int parent,Map<Integer, Set<Integer>> map){
        if(node!=null){
            if(!map.containsKey(node.val))
                map.put(node.val,new HashSet<>());
            Set<Integer> adj = map.get(node.val);
            if(parent!=0)
                adj.add(parent);
            if(node.left!=null)
                adj.add(node.left.val);
            if(node.right!=null)
                adj.add(node.right.val);
            buildGraph(node.left,node.val,map);
            buildGraph(node.right,node.val,map);

            
        }
    }
}