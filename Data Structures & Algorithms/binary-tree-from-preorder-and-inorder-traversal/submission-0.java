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
    Map<Integer, Integer> map;
    int[] preorder;
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();
        this.preorder = preorder;
        this.index = 0;

        for(int i = 0 ; i < inorder.length ; i++){
            map.put(inorder[i], i);
        }

        return dfs(0,  preorder.length - 1);
    }

    public TreeNode dfs(int l, int r){
        if(l > r) return null;

        int value = preorder[index++];
        TreeNode root = new TreeNode(value);

        root.left = dfs(l, map.get(value) - 1);
        root.right = dfs(map.get(value) + 1, r);

        return root;
    }
}
