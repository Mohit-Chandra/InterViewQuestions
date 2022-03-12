# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        res = 0
        def recur(root):
            nonlocal res
            if root is None:
                return 0
            left = recur(root.left)
            right = recur(root.right)
            res+=abs(left)+abs(right)
            return root.val+left+right-1
        recur(root)
        return res
        