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
        clonedMap.put(node, new Node(node.val));
        cloneGraph(node, clonedMap);
        return clonedMap.get(node);
    }
    
    private void cloneGraph(Node srcNode, Map<Node, Node> clonedMap) {
        List<Node> nbrs = srcNode.neighbors;
        
        Node cloned = clonedMap.get(srcNode);
        for(Node nbr : nbrs) {
            if(!clonedMap.containsKey(nbr)) {
                clonedMap.put(nbr, new Node(nbr.val));
                cloneGraph(nbr, clonedMap);
            }
            
            cloned.neighbors.add(clonedMap.get(nbr));
        }
    }
}