package com.koko.striver.day6;

public class cycleInList {
    public ListNode head;
    public static void main(String[] args) {
        cycleInList list1 = new cycleInList();
        cycleInList list2 = new cycleInList();

        list1.addToTheLast(new ListNode(1));
        list1.addToTheLast(new ListNode(2));
        list1.addToTheLast(new ListNode(3));
        list1.addToTheLast(new ListNode(4));
        list1.addToTheLast(new ListNode(5));
        list1.addToTheLast(new ListNode(6));
        list1.addToTheLast(list1.head.next); // making the cycle
        System.out.println("list");
        //list1.printList(list1.head);
        System.out.println("cycle available:" + list1.cycleDetect(list1.head));

    }

    private boolean cycleDetect(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }


    private void printList(ListNode head) {
        while(head!=null) {
            if(head.next!= null) System.out.print(head.data + "->");
            else System.out.print(head.data);
            head = head.next;
        }
    }

    private void addToTheLast(ListNode listNode) {
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

