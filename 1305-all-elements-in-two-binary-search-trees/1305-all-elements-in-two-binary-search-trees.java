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
    List<Integer> res;
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
         res = new ArrayList<>();
        inOrder(root1);
        inOrder(root2);
        Collections.sort(res);
        return res;
    }
    
    public void inOrder(TreeNode root){
        if(root == null)
            return;
        inOrder(root.left);
        if(root!=null)
            res.add(root.val);
        inOrder(root.right);
    }
}