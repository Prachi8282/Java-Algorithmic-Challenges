class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null)
      return root;
    if ((root.val >= p.val && root.val <= q.val) || (root.val >= q.val && root.val <= p.val)) {
      return root;
    }
    if (root.val > p.val && root.val > q.val)
      return lowestCommonAncestor(root.left, p, q);

    return lowestCommonAncestor(root.right, p, q);

  }
}
© 2021 GitHub, Inc.
Te
