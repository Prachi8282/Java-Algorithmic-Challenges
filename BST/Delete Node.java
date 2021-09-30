class Solution {
  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null)
      return null;
    if (key > root.val) {
      root.right = deleteNode(root.right, key);
    } else if (key < root.val) {
      root.left = deleteNode(root.left, key);
    } else {
      if (root.left == null)
        return root.right;
      if (root.right == null)
        return root.left;
      TreeNode temp = findMin(root.right);
      root.val = temp.val;
      root.right = deleteNode(root.right, root.val);
    }
    return root;
  }

  private TreeNode findMin(TreeNode node) {
    TreeNode cur = node;
    while (cur.left != null) {
      cur = cur.left;
    }
    return cur;
  }
}
