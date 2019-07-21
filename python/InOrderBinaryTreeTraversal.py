# https://leetcode.com/problems/binary-tree-inorder-traversal/

# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        """
        Given a binary tree, return the inorder traversal of its nodes' values.
        """

        nodes = []
        visited_vals = []

        curr = root

        while curr is not None or len(nodes) > 0:
            # reach leftmost node of curr
            while curr is not None:
                nodes.append(curr)
                curr = curr.left

            # curr is None
            curr = nodes.pop()
            visited_vals.append(curr.val)

            # visit right node
            curr = curr.right

        return visited_vals
