/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null)
            return null;
        
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        
        while(!q.isEmpty()) {            
            int size = q.size();
            Node head = null;
            
            for(int i=0 ; i<size ; i++) {
                // R - Remove
                Node cur = q.remove();
                
                // A - Add
                if(cur.left != null)
                    q.add(cur.left);
                if(cur.right != null)
                    q.add(cur.right);
                
                // P - Processing
                if(head == null)
                    head = cur;
                else {
                    head.next = cur;
                    head = head.next;
                }
            }
        }
        return root;
    }
}