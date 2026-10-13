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

//  Idea 1 - Queue Size Method
// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> result = new ArrayList<>();
//         if(root == null) return result;

//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);

//         while(!q.isEmpty()){
//             int levelSize = q.size();
//             List<Integer> currLevel = new ArrayList<>();

//             for(int i=0; i<levelSize; i++){
//                 TreeNode currNode = q.remove();
//                 currLevel.add(currNode.val);

//                 if(currNode.left != null) q.add(currNode.left);
//                 if(currNode.right != null) q.add(currNode.right);
//             }

//             result.add(currLevel);
//         }

//         return result;
//     }
// }

// Idea 2 - Null Pointer Method

//     public static void levelOrder(Node root) { // O(n)
//       if (root == null) {
//         return;
//       }

//       Queue<Node> q = new LinkedList<>();
//       q.add(root);
//       q.add(null);

//       while (!q.isEmpty()) {
//         Node curNode = q.remove();
//         if (curNode == null) {
//           System.out.println();
//           if (q.isEmpty()) {
//             break;
//           } else {
//             q.add(null);
//           }
//         } else {
//           System.out.print(curNode.data + " ");
//           if (curNode.left != null) {
//             q.add(curNode.left);
//           }
//           if (curNode.right != null) {
//             q.add(curNode.right);
//           }
//         }
//       }
//     }
//   }

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for(int i=0; i<size; i++){
                TreeNode curr = q.remove();
                level.add(curr.val);

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }

            result.add(level);
        }

        return result;
    }
}