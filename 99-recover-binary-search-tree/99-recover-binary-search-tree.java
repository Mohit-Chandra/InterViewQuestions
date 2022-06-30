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
    TreeNode first,prev,middle,last;
    
    public void inOrder(TreeNode root){
        if(root == null)
            return;
        
        inOrder(root.left);
        
        //Logic when visiting Node
        if(prev!=null && (root.val < prev.val)){
            if(first == null){
                first = prev;
                middle = root;
            }else {
                last = root;
            }
                
        }
        
        //Mark curr Node as prev
        prev = root;
        
        //Go right
        inOrder(root.right);
    }
    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inOrder(root);
        if(first!=null && last!=null){
            int t = first.val;
            first.val = last.val;
            last.val = t;
        }else if(first!=null && middle!=null){
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
        }
    }
}