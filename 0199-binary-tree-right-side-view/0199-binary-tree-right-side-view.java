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
    
    // 1) DFS
//     public List<Integer> rightSideView(TreeNode root) {
//         List<Integer> right = new LinkedList<>();
//         preOrder(root, 0, right);
//         return right;
//     }
    
//     private void preOrder(TreeNode root, int level, List<Integer> right) {
//         if(root == null)
//             return;
        
//         if(right.size() == level)
//             right.add(root.val);
        
//         preOrder(root.right, level+1, right);
//         preOrder(root.left, level+1, right);
//     }
    
    
    // 2) BFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> right = new LinkedList<>();
        if(root == null)
            return right;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i=0 ; i<size ; i++) {
                TreeNode node = q.remove();
                
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
                
                if(i==size-1)
                    right.add(node.val);
            }
        }
        return right;
    }
}