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
    
    // 1) By iterating to find which elements belong to left subtree/right subtree
//     public TreeNode bstFromPreorder(int[] preorder) {
//         return bstFromPreorder(preorder, 0, preorder.length-1);
//     }
    
//     private TreeNode bstFromPreorder(int[] preorder, int start, int end) {
//         if(start > end)
//             return null;
        
//         int rootVal = preorder[start];
//         TreeNode root = new TreeNode(rootVal);
//         int rightStart = start+1;
//         while(rightStart<preorder.length && preorder[rightStart]<rootVal) {
//             rightStart++;
//         }
        
//         root.left = bstFromPreorder(preorder, start+1, rightStart-1);
//         root.right = bstFromPreorder(preorder, rightStart, end);
        
//         return root;
//     }
    
    
    // 2) Recursion: Passing upper and lower bounds
//     public TreeNode bstFromPreorder(int[] preorder) {
//         return bstFromPreorder(preorder, new int[]{0}, Integer.MIN_VALUE, Integer.MAX_VALUE);
//     }
    
//     private TreeNode bstFromPreorder(int[] preorder, int[] idx, Integer lower, Integer upper) {
//         if(idx[0]>=preorder.length)
//             return null;
        
//         if((lower!=null && preorder[idx[0]]<lower) || (upper!=null && preorder[idx[0]]>upper))
//             return null;
        
//         TreeNode node = new TreeNode(preorder[idx[0]]);
//         idx[0]++;
//         node.left = bstFromPreorder(preorder, idx, lower, node.val);
//         node.right = bstFromPreorder(preorder, idx, node.val, upper);
        
//         return node;
//     }
    
    
    // 3) Recursion: Passing only upper bound
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, new int[]{0}, null);
    }
    
    private TreeNode bstFromPreorder(int[] preorder, int[] idx, Integer upper) {
        if(idx[0]>=preorder.length)
            return null;
        
        if(upper!=null && preorder[idx[0]]>upper)
            return null;
        
        TreeNode root = new TreeNode(preorder[idx[0]]);
        idx[0]++;
        root.left = bstFromPreorder(preorder, idx, root.val);
        root.right = bstFromPreorder(preorder, idx, upper);
        return root;
    }
    

    // 4) Iterative: Passing only upper bound
//     public TreeNode bstFromPreorder(int[] preorder) {
//         Deque<Pair> stack = new ArrayDeque<>();
        
//         TreeNode root = new TreeNode(preorder[0]);
//         stack.addFirst(new Pair(root, Integer.MAX_VALUE));
        
//         int i=1;
//         while(i < preorder.length) {
//             Pair top = stack.peek();
                        
//             TreeNode newNode = new TreeNode(preorder[i]);
//             if(preorder[i] < top.node.val) {
//                 top.node.left = newNode;
//                 stack.addFirst(new Pair(newNode, top.node.val));
//                 i++;
//             }
//             else if(preorder[i] < top.upper) {
//                 top.node.right = newNode;
//                 stack.addFirst(new Pair(newNode, top.upper));
//                 i++;
//             } else {
//                 stack.removeFirst();
//             }
//         }
//         return root;
//     }
    
//     class Pair {
//         TreeNode node;
//         Integer upper;
        
//         Pair(TreeNode node, Integer upper) {
//             this.node = node;
//             this.upper = upper;
//         }
//     }
    
    
     // 4) Iterative 2: Passing only upper bound
//     public TreeNode bstFromPreorder(int[] preorder) {
//         if(preorder==null || preorder.length==0)
//             return null;
        
//         Deque<TreeNode> stack = new ArrayDeque<>();
//         TreeNode root = new TreeNode(preorder[0]);
//         stack.push(root);
        
//         for(int i=1 ; i<preorder.length ; i++) {
//             TreeNode newNode = new TreeNode(preorder[i]);
            
//             TreeNode top = stack.peek();
//             while(!stack.isEmpty() && stack.peek().val<newNode.val)
//                 top = stack.pop();
            
//             if(newNode.val < top.val)
//                 top.left = newNode;
//             else if(newNode.val > top.val)
//                 top.right = newNode;
//             stack.push(newNode);
//         }
//         return root;
//     }
}