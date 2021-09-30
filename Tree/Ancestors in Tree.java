class Solution {
  public static ArrayList<Integer> Ancestors(Node root, int target) {
    if (root == null)
      return null;
    ArrayList<Integer> list = new ArrayList<>();
    util(root, target, list);
    return list;
  }

  private static Node util(Node root, int target, ArrayList<Integer> list) {
    if (root == null)
      return null;
    if (root.data == target)
      return root;
    Node left = util(root.left, target, list);
    Node right = util(root.right, target, list);
    if (left != null || right != null) {
      list.add(root);
      return root;
    }
    return null;
  }
}
