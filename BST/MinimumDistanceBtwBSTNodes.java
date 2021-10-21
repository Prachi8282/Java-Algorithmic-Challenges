import java.io.*;
import java.lang.*;
import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
}

class Main {
  static ArrayList<Integer> inorder_traversal = new ArrayList<Integer>();
  static int ans = Integer.MAX_VALUE;
  public static void inorder(TreeNode root) {
    if (root != null) {
      inorder(root.left);
      inorder_traversal.add(root.val);
      inorder(root.right);
    }
  }

  public static int minDiffInBST(TreeNode root) {
    inorder(root);
    for (int i = 1; i < inorder_traversal.size(); i++) ans =
      Math.min(ans, inorder_traversal.get(i) - inorder_traversal.get(i - 1));
    return ans;
  }

  public static void main(String[] args) throws java.lang.Exception {
    TreeNode root = new TreeNode();
    root.val = 1;
    root.right = new TreeNode();
    root.right.val = 5;
    root.right.left = new TreeNode();
    root.right.left.val = 3;
    root.right.left.left = new TreeNode();
    root.right.left.left.val = 2;
    root.right.left.right = new TreeNode();
    root.right.left.right.val = 4;
    System.out.print(minDiffInBST(root));
  }
}
