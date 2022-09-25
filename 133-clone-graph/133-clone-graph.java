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
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        
        Map<Node, Node> clonedMap = new HashMap<>();
        return cloneGraph(node, clonedMap);
    }
    
    private Node cloneGraph(Node src, Map<Node, Node> clonedMap) {
        if(clonedMap.containsKey(src))
            return clonedMap.get(src);
        
        Node cloned = new Node(src.val);
        clonedMap.put(src, cloned);
        
        for(Node nbr : src.neighbors) {
            Node clonedNbr = cloneGraph(nbr, clonedMap);
            cloned.neighbors.add(clonedNbr);
        }
        return cloned;
    }
}