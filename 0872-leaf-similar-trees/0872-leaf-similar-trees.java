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
    
    List<Integer> list1;
    List<Integer> list2;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1==null || root2==null)
            return true;
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        recur(root1,list1);
        recur(root2,list2);
        return list1.equals(list2);
    }
    
    public void recur(TreeNode root, List<Integer> lst){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            lst.add(root.val);
        }
        recur(root.left,lst);
        recur(root.right,lst);
    }
}