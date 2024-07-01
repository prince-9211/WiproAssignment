package Assignment;

public class BinaryTree {
    
    // Node class for binary tree nodes
    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root;

    // Constructor to initialize an empty binary tree
    public BinaryTree() {
        this.root = null;
    }

    // Method to insert a value into the binary tree
    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    // Recursive method to insert a value into the binary tree
    private TreeNode insertRecursive(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }

        if (value < root.data) {
            root.left = insertRecursive(root.left, value);
        } else if (value > root.data) {
            root.right = insertRecursive(root.right, value);
        }

        return root;
    }

    // Method to delete a value from the binary tree
    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    // Recursive method to delete a value from the binary tree
    private TreeNode deleteRecursive(TreeNode root, int value) {
        if (root == null) {
            return null;
        }

        if (value < root.data) {
            root.left = deleteRecursive(root.left, value);
        } else if (value > root.data) {
            root.right = deleteRecursive(root.right, value);
        } else {
            // Node to be deleted found

            // Case 1: Node has no children or only one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 2: Node has two children
            // Find the minimum value node in the right subtree (successor)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRecursive(root.right, root.data);
        }

        return root;
    }

    // Helper method to find the minimum value in a subtree
    private int minValue(TreeNode root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    public void inorderTraversal() {
        inorderRecursive(root);
        System.out.println();
    }

    private void inorderRecursive(TreeNode root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.data + " ");
            inorderRecursive(root.right);
        }
    }

    public void preorderTraversal() {
        preorderRecursive(root);
        System.out.println();
    }

    private void preorderRecursive(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRecursive(root.left);
            preorderRecursive(root.right);
        }
    }

    public void postorderTraversal() {
        postorderRecursive(root);
        System.out.println();
    }

    private void postorderRecursive(TreeNode root) {
        if (root != null) {
            postorderRecursive(root.left);
            postorderRecursive(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Inserting elements into the binary tree
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal:");
        tree.inorderTraversal(); // Should print 20 30 40 50 60 70 80

        // Deleting an element from the binary tree
        tree.delete(30);

        System.out.println("Inorder traversal after deletion of 30:");
        tree.inorderTraversal(); // Should print 20 40 50 60 70 80

        System.out.println("Preorder traversal:");
        tree.preorderTraversal(); // Should print 50 20 40 70 60 80

        System.out.println("Postorder traversal:");
        tree.postorderTraversal(); // Should print 40 20 60 80 70 50
    }
}

