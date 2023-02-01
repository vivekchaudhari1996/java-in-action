package com.koko.striver.day5;

import java.util.List;

public class middleOfList {

    public static ListNode head;
    public static class ListNode {
        int data;
        ListNode next;
        ListNode(int d) {
            this.data = d;
            this.next = null;
        }
    }

    public static void main(String args[]) {
        middleOfList list = new middleOfList();
        list.head = new ListNode(1);
        list.head.next = new ListNode(2);
        list.head.next.next = new ListNode(3);
        list.head.next.next.next = new ListNode(4);

        System.out.println("Link List");
        list.printList(head);
        System.out.println("");
        ListNode mid = list.middleNode(head);
        System.out.println("middle" + mid.data);
    }

    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private void printList(ListNode head) {
        while(head!=null) {
            System.out.print(head.data + "->");
            head= head.next;
        }
    }
}
