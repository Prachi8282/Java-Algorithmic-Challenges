class Solution {
  public int largestBst(TreeNode root) {
    return util(root).size;
  }

  private Ds util(TreeNode root) {
    if (root == null) {
      return new Ds(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
    }
    Ds left = util(root.left);
    Ds right = util(root.right);
    if (left.isBst && right.isBst && left.max < root.val && root.val < right.min) {
      return new Ds(true, Math.min(root.val, left.min), Math.max(root.val, right.max), left.size + right.size + 1);
    }
    return new Ds(false, -1, -1, Math.max(left.size, right.size));

  }

  class Ds {
    boolean isBst;
    int min;
    int max;
    int size;

    public Ds(boolean isBst, int min, int max, int size) {
      this.isBst = isBst;
      this.min = min;
      this.max = max;
      this.size = size;
    }
  }

}
