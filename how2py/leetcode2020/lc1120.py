class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def __init__(self):
        self.max_avg = 0

    def postorder(self, root):
        """
        return: (sum: float, total_count: int)
        """
        if not root:
            return 0.0, 0
        left_sum, left_count = self.postorder(root.left)
        right_sum, right_count = self.postorder(root.right)
        total_sum = left_sum + right_sum + root.val
        total_count = left_count + right_count + 1
        self.max_avg = max(self.max_avg, total_sum/total_count)
        return total_sum, total_count

    def maximumAverageSubtree(self, root: TreeNode) -> float:
        """
        left-right-mid traverse of the tree (postorder)
        for each node, maintain left_count, right_count and sum to calculate average and return its sum and count
        """

        self.postorder(root)
        return self.max_avg


