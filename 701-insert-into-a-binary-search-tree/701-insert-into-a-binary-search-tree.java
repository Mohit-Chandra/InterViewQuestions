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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
        {
           TreeNode tr = new TreeNode(val,null,null);
           return tr;
        }
        recur(root,val);
        return root;
    }
    public TreeNode recur(TreeNode root,int val){
         if(val > root.val){
            insertIntoBST(root.right,val);
            if(root.right == null){
                TreeNode tr = new TreeNode(val,null,null);
                root.right = tr;
                return root;
            }
        }else{
            insertIntoBST(root.left,val);
            if(root.left == null){
                TreeNode tr = new TreeNode(val,null,null);
                root.left = tr;
                return root;
            }
        }
        return root;
    }
}