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
    List<Integer> ans;
    int k;
    public int kthSmallest(TreeNode root, int k) {
        this.ans = new ArrayList<>();
        this.k = k;
        dfs(root);
        return ans.get(k-1);
    }
    public void dfs(TreeNode root){
        if(root == null || ans.size() >= k){
            return;
        }

        dfs(root.left);

        ans.add(root.val);

        dfs(root.right);
        
    }
}
