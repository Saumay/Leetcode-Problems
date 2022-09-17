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
    public void recoverTree(TreeNode root) {
        List<TreeNode> inorderList = new ArrayList<>();
        inorder(root, inorderList);
        
        TreeNode l1 = null, r1 = null;
        TreeNode r2 = null, l2 = null;
        
        for(int i=1 ; i<inorderList.size() ; i++) {
            if(inorderList.get(i).val < inorderList.get(i-1).val) {
                if(l1 == null) {                
                    l1 = inorderList.get(i-1);
                    r1 = inorderList.get(i);
                } else {
                    l2 = inorderList.get(i-1);
                    r2 = inorderList.get(i);
                }
            }
        }
        
        if(l2 == null)
            swap(l1, r1);
        else
            swap(l1, r2);
    }
    
    private void swap(TreeNode n1, TreeNode n2) {
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }
    
    private void inorder(TreeNode root, List<TreeNode> inorderList) {
        if(root==null)
            return;
        
        inorder(root.left, inorderList);
        inorderList.add(root);
        inorder(root.right, inorderList);
    }
}