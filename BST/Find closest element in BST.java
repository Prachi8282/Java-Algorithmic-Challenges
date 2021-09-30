class Solution {
  static int min;
  static int minKey;
  static int minDiff(Node root, int K) {
    min = Integer.MAX_VALUE;
    dfs(root, K);
    return minKey;
  }

  static void dfs(Node root, int K) {
    if (root == null)
      return;
    int diff = root.key - K;
    if (Math.abs(diff) < min) {
      min = Math.min(min, Math.abs(diff));
      minKey = root.key;
    }
    if (diff > 0) {
      dfs(root.left, K);
    } else if (diff < 0) {
      dfs(root.right, K);
    }
  }
}
