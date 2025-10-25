Binary Search Tree (BST)
import java.util.Scanner;

// Node class
class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

// BST class
class BST {
    Node root;

    BST() {
        root = null;
    }

    // Insert a node
    Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.data) {
            node.left = insert(node.left, value);
        } else if (value > node.data) {
            node.right = insert(node.right, value);
        }
        return node;
    }

    // Search a node
    boolean search(Node node, int key) {
        if (node == null) return false;
        if (key == node.data) return true;
        return key < node.data ? search(node.left, key) : search(node.right, key);
    }

    // Delete a node
    Node delete(Node node, int key) {
        if (node == null) return null;

        if (key < node.data) node.left = delete(node.left, key);
        else if (key > node.data) node.right = delete(node.right, key);
        else { // node to delete found
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            // Node with two children: get inorder successor
            node.data = minValue(node.right);
            node.right = delete(node.right, node.data);
        }
        return node;
    }

    // Helper: find minimum value in subtree
    int minValue(Node node) {
        int min = node.data;
        while (node.left != null) {
            node = node.left;
            min = node.data;
        }
        return min;
    }

    // Inorder traversal
    void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // Find k-th smallest element
    int kthSmallest(Node node, int k) {
        int[] count = {0};
        int[] result = {-1};
        kthSmallestHelper(node, k, count, result);
        return result[0];
    }

    void kthSmallestHelper(Node node, int k, int[] count, int[] result) {
        if (node == null) return;

        kthSmallestHelper(node.left, k, count, result);

        count[0]++;
        if (count[0] == k) {
            result[0] = node.data;
            return;
        }

        kthSmallestHelper(node.right, k, count, result);
    }
}

// Main class
public class BSTOperations {
    public static void main(String[] args) {
        BST bst = new BST();
        Scanner sc = new Scanner(System.in);

        // Sample insertions
        int[] values = {50, 30, 20, 40, 70, 60, 80};
        for (int val : values) bst.root = bst.insert(bst.root, val);

        System.out.print("Inorder traversal of BST: ");
        bst.inorder(bst.root);
        System.out.println();

        // Search example
        int key = 40;
        System.out.println("Search " + key + ": " + (bst.search(bst.root, key) ? "Found" : "Not Found"));

        // Delete example
        int delKey = 30;
        bst.root = bst.delete(bst.root, delKey);
        System.out.print("Inorder after deleting " + delKey + ": ");
        bst.inorder(bst.root);
        System.out.println();

        // k-th smallest example
        int k = 3;
        System.out.println(k + "-th smallest element: " + bst.kthSmallest(bst.root, k));
    }
}
