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
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
//     }

//     private boolean valid(TreeNode node, long min, long max){
//         if(node == null) return true;

//         if(node.val <= min || node.val >= max) return false;

//         return valid(node.left, min, node.val) && valid(node.right, node.val, max);
//     }
// }

class Solution {
    public boolean isValidBST(TreeNode root) {
       return bst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean bst(TreeNode root, long min, long max){
        if(root == null) return true;

        if(root.val <= min || root.val >= max) return false;

        return bst(root.left, min, root.val) && bst(root.right, root.val, max);
    }

   
}