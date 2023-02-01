package com.koko.striver.day7;

/**
 * Calculate the length of the list.
 * Connect the last node to the first node, converting it to a circular linked list.
 * Iterate to cut the link of the last node and start a node of k%length of the list rotated list.
 */

public class rotateList {
    public ListNode head;

    public static void main(String[] args) {
        rotateList list = new rotateList();
        list.addToTheLast(new ListNode(1));
        list.addToTheLast(new ListNode(2));
        list.addToTheLast(new ListNode(3));
        list.addToTheLast(new ListNode(4));
        list.addToTheLast(new ListNode(5));
        list.addToTheLast(new ListNode(6));
        System.out.println("List");
        list.printList(list.head);
        list.head = list.rotateList(list.head, 2);
        System.out.println("\n" + "new List");
        list.printList(list.head);
    }

    private ListNode rotateList(ListNode head, int k) {
        if(head==null || head.next == null || k==0) return head;

        // calculate the length
        ListNode temp = head;
        int length = 1;
        while(temp.next!=null) {
            length++;
            temp = temp.next;
        }

        // link last node to first node to make it cycleList
        temp.next = head;

        k = k % length; // if k is big so modulus nikalo due to its rotate

        // now its time to break at right place
        int end = length - k;
        while (end!=0) {
            temp = temp.next;
            end--;
        }
        head = temp.next;
        temp.next = null;
        return head;

    }

    private void addToTheLast(ListNode listNode) {
        if(head== null) head=listNode;
        else {
            ListNode temp = head;
            while(temp.next!=null)
                temp = temp.next;
            temp.next = listNode;
        }
    }

    private void printList(ListNode head) {
        while(head!=null) {
            if(head.next!= null) System.out.print(head.data + "->");
            else System.out.print(head.data);
            head = head.next;
        }
    }
}
