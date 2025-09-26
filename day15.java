
import java.util.HashSet;

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {
    public int countPairs(Node head1, Node head2, int x) {
        // Step 1: Store all elements of second list in a HashSet
        HashSet<Integer> set = new HashSet<>();
        Node temp2 = head2;
        while (temp2 != null) {
            set.add(temp2.data);
            temp2 = temp2.next;
        }

        // Step 2: Traverse first list and check for complement in set
        int count = 0;
        Node temp1 = head1;
        while (temp1 != null) {
            int complement = x - temp1.data;
            if (set.contains(complement)) {
                count++;
            }
            temp1 = temp1.next;
        }

        return count;
    }

    // Utility to print pairs (optional)
    public void printPairs(Node head1, Node head2, int x) {
        HashSet<Integer> set = new HashSet<>();
        Node temp2 = head2;
        while (temp2 != null) {
            set.add(temp2.data);
            temp2 = temp2.next;
        }

        Node temp1 = head1;
        while (temp1 != null) {
            int complement = x - temp1.data;
            if (set.contains(complement)) {
                System.out.println("(" + temp1.data + ", " + complement + ")");
            }
            temp1 = temp1.next;
        }
    }

    public static void main(String[] args) {
        // First list: 1 -> 2 -> 3
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);

        // Second list: 3 -> 4 -> 5
        Node head2 = new Node(3);
        head2.next = new Node(4);
        head2.next.next = new Node(5);

        int x = 6;

        Solution sol = new Solution();
        int count = sol.countPairs(head1, head2, x);
        System.out.println("Number of pairs = " + count);

        System.out.println("Pairs:");
        sol.printPairs(head1, head2, x);
    }
}

delete without head pointer (Linked List):
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {
    public void deleteNode(Node del_node) {
        if (del_node == null || del_node.next == null) {
            // Cannot delete last node this way
            return;
        }
        del_node.data = del_node.next.data;
        del_node.next = del_node.next.next;
    }

    public void printNode(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Example usage
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        Solution sol = new Solution();
        System.out.println("Original list:");
        sol.printNode(head);

        // Delete node 20 without head pointer
        sol.deleteNode(head.next);  // node with value 20

        System.out.println("After deletion:");
        sol.printNode(head);
    }
}


/*
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}
*/

import java.util.*;

class Solution {
    public static Node makeUnion(Node head1, Node head2) {
        // Use TreeSet to store distinct values in sorted order
        Set<Integer> set = new TreeSet<>();

        // Add all elements from first list
        Node curr = head1;
        while (curr != null) {
            set.add(curr.data);
            curr = curr.next;
        }

        // Add all elements from second list
        curr = head2;
        while (curr != null) {
            set.add(curr.data);
            curr = curr.next;
        }

        // Build the new linked list using dummy node
        Node dummy = new Node(0); // dummy head
        Node tail = dummy;

        for (int val : set) {
            tail.next = new Node(val);
            tail = tail.next;
        }
