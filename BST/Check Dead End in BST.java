class GFG {
  public static boolean isDeadEnd(Node root) {
    return dfs(root, 0, Integer.MAX_VALUE);
  }
  private static boolean dfs(Node node, int min, int max) {
    if (node == null) return false;
    if (node.left == null && node.right == null) {
      if (min == max) return true;
    }
    return dfs(node.left, min, node.val - 1) || dfs(node.right, node.val + 1);
  }
}
