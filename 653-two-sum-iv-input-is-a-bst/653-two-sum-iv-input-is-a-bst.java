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
    
    // 1) Converting to array + 2 pointer approach
    List<Integer> inorder = new ArrayList<>();
    
    public boolean findTarget(TreeNode root, int k) {
        inorder(root);
        
        int left=0;
        int right=inorder.size()-1;
        
        while(left<right) {
            int sum = inorder.get(left) + inorder.get(right);
            if(sum < k)
                left++;
            else if(sum > k)
                right--;
            else
                return true;
        }
        return false;
    }
    
    private void inorder(TreeNode root) {
        if(root==null)
            return;
        
        inorder(root.left);
        inorder.add(root.val);
        inorder(root.right);
    }
}