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
 class Pair {
    TreeNode node;
    int hd;

    Pair(TreeNode node, int hd) {
        this.node = node;
        this.hd = hd;
    }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            TreeMap<Integer, ArrayList<Integer>> levelMap =new TreeMap<>();
            for (int i = 0; i < size; i++) {
                Pair cur = q.poll();
                int hd = cur.hd;
                int value = cur.node.val;

                levelMap.computeIfAbsent(hd, k -> new ArrayList<>())
                    .add(value);
                if (cur.node.left != null) {
                    q.add(new Pair(cur.node.left, hd - 1));
                }
                if (cur.node.right != null) {
                    q.add(new Pair(cur.node.right, hd + 1));
                }
            }
            for (Map.Entry<Integer, ArrayList<Integer>> entry : levelMap.entrySet()) {
                int hd = entry.getKey();
                ArrayList<Integer> values = entry.getValue();
                Collections.sort(values);
                map.computeIfAbsent(hd, k -> new ArrayList<>())
                   .addAll(values);
            }
        }
        return new ArrayList<>(map.values());

    }
}