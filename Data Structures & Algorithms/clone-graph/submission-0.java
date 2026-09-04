/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node,Node> map = new HashMap<>();
    public Node helper(Node node) {
        if(node == null) return null;
        if(map.containsKey(node)) return map.get(node);
        Node temp = new Node(node.val);
        map.put(node, temp);
        for(Node i : node.neighbors) {
            temp.neighbors.add(helper(i));
        }
        return temp;
    }
    public Node cloneGraph(Node node) {
        return helper(node);
    }
}