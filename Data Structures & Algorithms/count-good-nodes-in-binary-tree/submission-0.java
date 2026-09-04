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
    int ans;
    public int goodNodes(TreeNode root) {
        this.ans = 0;
        if(root != null) dfs(root, root.val);
        return ans;
    }

    public void dfs(TreeNode root, int max){
        if(root.val >= max) ans++;
        if(root.left != null) dfs(root.left, Math.max(max, root.val));
        if(root.right != null) dfs(root.right, Math.max(max, root.val));
    }
}