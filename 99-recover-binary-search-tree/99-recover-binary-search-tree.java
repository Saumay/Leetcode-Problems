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
    
    // 1) By storing inorder in a list
//     public void recoverTree(TreeNode root) {
//         List<TreeNode> inorderList = new ArrayList<>();
//         inorder(root, inorderList);
        
//         List<TreeNode> sorted = new ArrayList<>(inorderList);
//         Collections.sort(sorted, Comparator.comparingInt(node -> node.val));
        
//         TreeNode n1 = null;
//         TreeNode n2 = null;
//         for(int i=0 ; i<sorted.size() ; i++) {
//             if(inorderList.get(i).val != sorted.get(i).val) {
//                 if(n1 == null)
//                     n1 = inorderList.get(i);
//                 else
//                     n2 = inorderList.get(i);
//             }
//         }
//         swap(n1, n2);
//     }
    
//     private void inorder(TreeNode root, List<TreeNode> inorderList) {
//         if(root==null)
//             return;
        
//         inorder(root.left, inorderList);
//         inorderList.add(root);
//         inorder(root.right, inorderList);
//     }
    
    
    
    // 2) By storing inorder in a list
//     public void recoverTree(TreeNode root) {
//         List<TreeNode> inorderList = new ArrayList<>();
//         inorder(root, inorderList);
        
//         TreeNode l1 = null, r1 = null;
//         TreeNode r2 = null, l2 = null;
        
//         for(int i=1 ; i<inorderList.size() ; i++) {
//             if(inorderList.get(i).val < inorderList.get(i-1).val) {
//                 if(l1 == null) {                
//                     l1 = inorderList.get(i-1);
//                     r1 = inorderList.get(i);
//                 } else {
//                     l2 = inorderList.get(i-1);
//                     r2 = inorderList.get(i);
//                 }
//             }
//         }
        
//         if(l2 == null)
//             swap(l1, r1);
//         else
//             swap(l1, r2);
//     }
    
//     private void inorder(TreeNode root, List<TreeNode> inorderList) {
//         if(root==null)
//             return;
        
//         inorder(root.left, inorderList);
//         inorderList.add(root);
//         inorder(root.right, inorderList);
//     }
    
    
    
    // 3) Constant space: By doing inorder traversal 
    private TreeNode prev = null;
    private TreeNode l1 = null;
    private TreeNode l2 = null;
    private TreeNode r1 = null;
    private TreeNode r2 = null;
    
    public void recoverTree(TreeNode root) {
        inorder(root);
        
        if(l2 != null)
            swap(l1, r2);
        else
            swap(l1, r1);
    }
    
    private void inorder(TreeNode root) {
        if(root==null)
            return;
        
        inorder(root.left);
        
        if(prev!=null && prev.val>root.val) {
            if(l1==null) {
                l1 = prev;
                r1 = root;
            } else {
                l2 = prev;
                r2 = root;
            }
        }
        prev = root;
        
        inorder(root.right);
    }
    
    private void swap(TreeNode n1, TreeNode n2) {
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
}