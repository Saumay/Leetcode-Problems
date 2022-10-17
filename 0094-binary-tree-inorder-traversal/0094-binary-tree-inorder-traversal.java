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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        if(root == null)
            return inorder;
        
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;
        
        while(!st.isEmpty() || node!=null) {
            // Go to leftmost node
            while(node != null) {
                st.push(node);
                node = node.left;
            }

            // Pop the leftmost node
            TreeNode popped = st.pop();
            
            // Add value to list
            inorder.add(popped.val);
            
            // Move to right subtree of popped node
            node = popped.right;
        }
        
        return inorder;
    }
}