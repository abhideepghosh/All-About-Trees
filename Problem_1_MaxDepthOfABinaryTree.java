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

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
Memory Usage: 41.9 MB, less than 94.65% of Java online submissions for Maximum Depth of Binary Tree.
*/

// We Use Recursion To Find The Max Depth In The Most Efficient Way
class Solution {
    
    public int maxDepth(TreeNode root) {
        
        // Base Case Of Recursion
        if(root == null){
            return 0;
        }
        
        // Calulating Height From The Leaf Nodes To The Current Nodes
        int heightLeft = maxDepth(root.left);
        int heightRight = maxDepth(root.right);
        
        // Calculating The Max Of Both Heights + 1
        return Math.max(heightLeft, heightRight) + 1;
    }
}
