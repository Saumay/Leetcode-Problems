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
    
    private int maxSum = 0;
    
    public int maxSumBST(TreeNode root) {
        traverse(root);
        return maxSum;
    }
    
    private Integer[] traverse(TreeNode root) {
        if(root==null)
            return new Integer[] {0, null, null};
        
        Integer[] left = traverse(root.left);
        Integer[] right = traverse(root.right);
        
        if(left!=null && right!=null) {
            int sum = root.val + left[0] + right[0];

            if((left[2]==null || left[2]<root.val) && (right[1]==null || root.val<right[1])) {
                maxSum = Math.max(sum, maxSum);
                return new Integer[] {sum, left[1]!=null ? left[1] : root.val, right[2]!=null ? right[2] : root.val};
            }
        }
        return null;
    }
    
//     class Pair {
//         int sum;
//         Integer lower;
//         Integer upper;
        
//         public Pair(int sum, Integer lower, Integer upper) {
//             this.sum = sum;
//             this.lower = lower;
//             this.upper = upper;
//         }
//     }
}