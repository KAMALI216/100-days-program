/*
class Node
{
    int data ;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public static  void deleteNode(Node del_node) {
        if(del_node==null || del_node.next==null)
        {
            return;
        }
        del_node.data=del_node.next.data;
        del_node.next=del_node.next.next;
        // code here
        
        
    }
    public static void printNode(Node head)
    {
        Node temp=head;
        while(head!=null)
        {
            System.out.println(head.data+"->");
            head=head.next;
        }
    }
    public static void main(String args[])
    {
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        
        deleteNode(head.next);
        printNode(head);
    }
   
}
