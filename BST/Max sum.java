
class Solution {
  public static int maxPathSum(Node root) {
    if (root == null)
      return 0;
    int left = maxPathSum(root.left);
    int right = maxPathSum(root.right);
    int max = Math.max(left, right);
    return max + root.data;
  }
}
