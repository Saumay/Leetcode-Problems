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
    
    // 1) Void recursion method
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        
        Map<Node, Node> clonedMap = new HashMap<>();
        clonedMap.put(node, new Node(node.val));
        dfs(node, clonedMap);
        return clonedMap.get(node);
    }

    private void dfs(Node node, Map<Node, Node> clonedMap) {
        Node cloned = clonedMap.get(node);
        
        List<Node> nbrs = node.neighbors;        
        for(Node nbr : nbrs) {
            if(!clonedMap.containsKey(nbr)) {
                clonedMap.put(nbr, new Node(nbr.val));
                dfs(nbr, clonedMap);
            }
            cloned.neighbors.add(clonedMap.get(nbr));
        }
    }
    
    
    // 2) Recursion method returning cloned graph
//     public Node cloneGraph(Node node) {
//         if(node == null)
//             return null;
        
//         Map<Node, Node> clonedMap = new HashMap<>();
//         return cloneGraph(node, clonedMap);
//     }
    
//     private Node cloneGraph(Node node, Map<Node, Node> clonedMap) {
//         if(clonedMap.containsKey(node))
//             return clonedMap.get(node);
        
//         Node clonedNode = new Node(node.val);
//         clonedMap.put(node, clonedNode);
        
//         for(Node nbr : node.neighbors) {
//             Node clonedNbr = cloneGraph(nbr, clonedMap);
//             clonedNode.neighbors.add(clonedNbr);
//         }
//         return clonedNode;
//     }
}