/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = ser(root, new StringBuilder());
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private StringBuilder ser(TreeNode root, StringBuilder sb){
        if(root == null){ return sb.append("null,");}
        
        StringBuilder s = new StringBuilder(sb);
        s.append(root.val + ",");
        s = ser(root.left, s);
        s = ser(root.right, s);

        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] s = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(s));
        return des(list);
    }
    private TreeNode des(List<String> l){
        if(l.get(0).equals("null")){
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));

        l.remove(0);
        root.left = des(l);
        root.right = des(l);

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));