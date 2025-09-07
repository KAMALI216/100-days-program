// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // Swap children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert left and right subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public static void main(String[] args) {
        // Example: root = [4,2,7,1,3,6,9]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        root.right = new TreeNode(7, new TreeNode(6), new TreeNode(9));

        Solution obj = new Solution();
        TreeNode inverted = obj.invertTree(root);

        // Preorder traversal to check result
        printPreorder(inverted);  // Output should represent [4,7,2,9,6,3,1]
    }

    // Helper: Preorder print
    static void printPreorder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }
}
