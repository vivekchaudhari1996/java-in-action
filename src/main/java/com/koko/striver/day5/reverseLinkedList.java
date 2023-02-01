package com.koko.striver.day5;

public class reverseLinkedList {

    public static ListNode head;
    public static class ListNode {
        int data;
        ListNode next;

        ListNode(int d) {
            this.data = d;
            this.next = null;
        };
    }




    public static void main(String args[]) {
        reverseLinkedList list = new reverseLinkedList();
        list.head = new ListNode(1);
        list.head.next = new ListNode(2);
        list.head.next.next = new ListNode(3);
        list.head.next.next.next = new ListNode(4);

        System.out.println("Linked List");
        list.printList(head);
        System.out.println("");
        head = list.reverseList(head);
        System.out.println("New Linked List");
        list.printList(head);

    }

    private ListNode reverseList(ListNode head) {

        // keep in mind that 3 pointer needed not just 2 pointer
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }

    private static void printList(ListNode head) {
        while(head!=null) {
            System.out.print(head.data + "-> ");
            head = head.next;
        }
    }
}
