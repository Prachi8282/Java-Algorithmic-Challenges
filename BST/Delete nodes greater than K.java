class Solution {
  public Node deleteNode(Node root, int k) {
    if (root == null)
      return root;
    if (root.data >= k) {
      return deleteNode(root.left, k);
    }
    root.left = deleteNode(root.left, k);
    root.right = deleteNode(root.right, k);
    return root;
  }
}
© 2021 GitHub, Inc.
T
