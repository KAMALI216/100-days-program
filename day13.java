
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class MinimumDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        // If one of the subtrees is null, we must go through the other one
        if (root.left == null) return 1 + minDepth(root.right);
        if (root.right == null) return 1 + minDepth(root.left);

        // Both children exist → take min depth
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    public static void main(String[] args) {
        // Example: [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MinimumDepth obj = new MinimumDepth();
        System.out.println(obj.minDepth(root)); // Output: 2
    }
}

implement an inorder traversal of a binary tree in Java.
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inorderHelper(node.left, result);   // Left
        result.add(node.val);               // Root
        inorderHelper(node.right, result);  // Right
    }

    public static void main(String[] args) {
        // Example: root = [1, null, 2, 3]
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        InorderTraversal obj = new InorderTraversal();
