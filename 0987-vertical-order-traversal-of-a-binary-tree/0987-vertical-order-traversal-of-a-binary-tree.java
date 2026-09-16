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
 class Tuple {
    int col;
    int row;
    TreeNode node;
    

    Tuple(int col, int row, TreeNode node) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        TreeMap<Integer, ArrayList<int[]>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, 0, root));

        while(!q.isEmpty()){
            Tuple curr = q.poll();

            if(!map.containsKey(curr.col)){
                map.put(curr.col, new ArrayList<>());
            }
            map.get(curr.col).add(new int[]{curr.row, curr.node.val});

            if(curr.node.left != null){
                q.add(new Tuple(curr.col-1, curr.row+1, curr.node.left));
            }
            if(curr.node.right != null){
                q.add(new Tuple(curr.col+1, curr.row+1, curr.node.right));
            }

        }
        for(List<int[]> list : map.values()){
            Collections.sort(list, (a,b)->{
                if(a[0] != b[0]){
                    return a[0]-b[0];
                }
                else{
                    return a[1]-b[1];
                }
            });
            List<Integer> colList = new ArrayList<>();
            for(int[] info : list){
                colList.add(info[1]);
            }
            ans.add(colList);
        }
        return ans;



    }
}