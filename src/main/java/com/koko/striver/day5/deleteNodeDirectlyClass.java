package com.koko.striver.day5;



public class deleteNodeDirectlyClass {
    public ListNode head;
    public static void main(String[] args) {
        deleteNodeDirectlyClass list = new deleteNodeDirectlyClass();
        list.addToTheLast(new ListNode(1));
        list.addToTheLast(new ListNode(2));
        list.addToTheLast(new ListNode(3));
        list.addToTheLast(new ListNode(4));
        list.addToTheLast(new ListNode(5));
        list.printList(list.head);
        // ListNode n = new ListNode(3); // this is not correct way to delete the 3 coz its not the part of existing list
        list.deleteNodeDirectly(list.head.next.next);
        list.printList(list.head);
    }

    private void deleteNodeDirectly(ListNode n) {
        n.data = n.next.data;
        n.next = n.next.next;
    }

    public void printList(ListNode head) {
        while(head!=null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
    }
    public void addToTheLast(ListNode listNode) {
        if (head == null) {
            head = listNode;
        } else {
            ListNode temp = head;
            while(temp.next != null)
                temp = temp.next;
            temp.next = listNode;
        }
    }
}
