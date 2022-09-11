/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node inorderSuccessor(Node node) {
        return node.right!=null ? inorderSuc1(node) : inorderSuc2(node);
    }
    
    // If right child is not null. Just find leftmost element in right subtree
    private Node inorderSuc1(Node node) {
        node = node.right;
        while(node.left != null)
            node = node.left;
        return node;
    }
    
    // If right child is null, move up and check for the larger parent
    private Node inorderSuc2(Node node) {
        while(node.parent!=null && node.val>node.parent.val)
            node = node.parent;
        return node.parent;
    }
}