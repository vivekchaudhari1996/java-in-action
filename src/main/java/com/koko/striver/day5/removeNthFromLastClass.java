package com.koko.striver.day5;


public class removeNthFromLastClass {

    public static ListNode head;
    public static class ListNode{
        int data;
        ListNode next;

        ListNode(int d) {
            this.data = d;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        removeNthFromLastClass list = new removeNthFromLastClass();
        list.addAtLast(new ListNode(1));
        list.addAtLast(new ListNode(2));
        list.addAtLast(new ListNode(3));
        list.addAtLast(new ListNode(4));
        list.addAtLast(new ListNode(5));
        list.addAtLast(new ListNode(6));
        System.out.println("Link List");
        list.printList(list.head);
        list.head = list.removeNthFromLast(list.head, 1);
        System.out.println("After removing the nth");
        list.printList(list.head);
    }

    private void printList(ListNode head) {
        while(head!=null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
    }

    private ListNode removeNthFromLast(ListNode head, int n) {
        ListNode normalP = head;
        ListNode advanceP = head;

        //pre work to reach to nth place
        for (int i=0; i<n; i++) {
            advanceP = advanceP.next;
        }

        while(advanceP.next!=null) {
            normalP=normalP.next;
            advanceP=advanceP.next;
        }
        normalP.next = normalP.next.next;
        return head;

    }

    private void addAtLast(ListNode node) {
        if(head==null) head = node;
        else {
            ListNode temp = head;
            while(temp.next!=null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }
}
