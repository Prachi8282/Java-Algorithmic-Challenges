class Solution
{
    static ArrayList<Integer> arr = new ArrayList<>();
    static int i=0;
    public static void convertToMaxHeapUtil(Node root)
    {
        i = 0;
        arr.clear();
        // inorder traversal to populate 'arr'
	    inorderTraversal(root);
	    
	    // BST to MAX HEAP conversion
        BSTToMaxHeap(root);
    }
    
    // Function for the inorder traversal of the tree
    // so as to store the node values in 'arr' in
    // sorted order
    static void inorderTraversal(Node root)
    {
        if (root == null)
            return;
       
        // first recur on left subtree
        inorderTraversal(root.left);
       
        // then copy the data of the node
        arr.add(root.data);
       
        // now recur for right subtree
        inorderTraversal(root.right);
    }
       
    static void BSTToMaxHeap(Node root)
    {
        if (root == null)
            return;
       
        // recur on left subtree
        BSTToMaxHeap(root.left);
       
        // recur on right subtree
        BSTToMaxHeap(root.right);
       
        // copy data at index 'i' of 'arr' to
        // the node
        root.data = arr.get(i++);
    }
}
