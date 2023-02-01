package com.koko.striver.day6;

/**
 * Take two dummy nodes for each list. Point each to the head of the lists.
 * Iterate over them. If anyone becomes null, point them to the head of the opposite lists and continue iterating until they collide.
 */

class ListNode{ // intentionally added outside otherwise static me 1-3-5-2-4-6 aa rha tha
    int data;
    ListNode next;

    ListNode() {
    }
    ListNode(int d) {
        this.data = d;
        this.next = null;
    }
}

public class findIntersectionPointOfYLinkList {
    public ListNode head;
    public static void main(String[] args) {
        findIntersectionPointOfYLinkList list1 = new findIntersectionPointOfYLinkList();
        findIntersectionPointOfYLinkList list2 = new findIntersectionPointOfYLinkList();

        list1.addToTheLast(new ListNode(1));
        list1.addToTheLast(new ListNode(2));
        list1.addToTheLast(new ListNode(3));
        list1.addToTheLast(new ListNode(4));
        list1.addToTheLast(new ListNode(5));
        list1.addToTheLast(new ListNode(6));
        System.out.println("first list");
        list1.printList(list1.head);

        list2.addToTheLast(new ListNode(9));
        list2.addToTheLast(new ListNode(9));
        list2.addToTheLast(new ListNode(9));
//        list2.addToTheLast(list1.head.next.next.next);

        System.out.println();
        System.out.println("second list");
        list2.printList(list2.head);

        System.out.println();
        System.out.println("intersection point " + list1.intersectionPresent(list1.head, list2.head).data);
    }

    //utility function to check presence of intersection
    private ListNode intersectionPresent(ListNode head1, ListNode head2) {
        ListNode d1 = head1;
        ListNode d2 = head2;

        // Iterate over them. If anyone becomes null, point them to the head of the opposite lists and continue iterating until they collide.
        while(d1 != d2) {
            if (d1 != null) {
                d1 = d1.next;
            } else {
                d1 = head2; // jaise hi null par phuche assign it to another string
            }

            if (d2 != null) {
                d2 = d2.next;
            } else {
                d2 = head2;
            }
        }

        return d1;
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
