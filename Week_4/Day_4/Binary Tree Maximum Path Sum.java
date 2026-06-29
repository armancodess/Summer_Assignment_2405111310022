class Solution {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        gain(root);
        return maxSum;
    }

    private int gain(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = Math.max(0, gain(root.left));
        int right = Math.max(0, gain(root.right));

        maxSum = Math.max(maxSum, root.val + left + right);

        return root.val + Math.max(left, right);
    }
}