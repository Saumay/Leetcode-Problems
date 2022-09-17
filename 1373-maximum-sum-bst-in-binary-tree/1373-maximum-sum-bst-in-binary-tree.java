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
    
    // 1) Check for each node if it's a valid bst. Also return it's sum. 
    // Complexity: O(n^2)
//     private int maxSum = 0;
    
//     public int maxSumBST(TreeNode root) {
//         preordeHelper(root);
//         return maxSum;
//     }
    
//     private void preordeHelper(TreeNode root) {
//         if(root==null)
//             return;
        
//         Integer validBstSum = validBstSum(root, null, null);
//         if(validBstSum!=null && validBstSum>maxSum)
//             maxSum = validBstSum;
        
//         preordeHelper(root.left);
//         preordeHelper(root.right);
//     }
    
//     private Integer validBstSum(TreeNode root, Integer lower, Integer upper) {
//         if(root==null)
//             return 0;
        
//         Integer left = validBstSum(root.left, lower, root.val);
//         Integer right = validBstSum(root.right, root.val, upper);
        
//         if(left!=null && right!=null 
//            && (lower==null || lower<root.val)
//            && (upper==null || root.val<upper))
//             return left+right+root.val;
        
//         return null;
//     }
    
    
    // 2.1) Use upper bound and lower bounds. Bottom up approach instead of top down.
    // Refer 2.2 for better understanding.
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
                
                Integer lower = left[1]!=null ? left[1] : root.val;
                Integer upper = right[2]!=null ? right[2] : root.val;
                return new Integer[] {sum, lower, upper};
            }
        }
        return null;
    }
    
    
    // 2.2) Use upper bound and lower bounds. Bottom up approach instead of top down. Using pair class
//     private int maxSum = 0;
    
//     public int maxSumBST(TreeNode root) {
//         traverse(root);
//         return maxSum;
//     }
    
//     private Helper traverse(TreeNode root) {
//         if(root==null)
//             return new Helper(0, null, null);
        
//         Helper left = traverse(root.left);
//         Helper right = traverse(root.right);
        
//         if(left!=null && right!=null) {
//             int sum = root.val + left.sum + right.sum;
            
//             if((left.upper==null || left.upper<root.val)
//                && (right.lower==null || root.val<right.lower)) {
//                 maxSum = Math.max(maxSum, sum);
                
//                 Integer lower = left.lower!=null ? left.lower : root.val;
//                 Integer upper = right.upper!=null ? right.upper : root.val;
//                 return new Helper(sum, lower, upper);
//             }
//         }
//         return null;
//     }
    
//     class Helper {
//         int sum;
//         Integer lower;
//         Integer upper;
        
//         public Helper(int sum, Integer lower, Integer upper) {
//             this.sum = sum;
//             this.lower = lower;
//             this.upper = upper;
//         }
//     }
}