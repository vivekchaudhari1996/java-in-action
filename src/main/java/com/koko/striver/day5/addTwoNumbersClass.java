package com.koko.striver.day5;

/**
 * yha question ek aur banega - given in correct format then stack Use karke karna hoga
 */

public class addTwoNumbersClass {
    public ListNode head;
    public static void main(String[] args) {
        addTwoNumbersClass list1 = new addTwoNumbersClass();
        addTwoNumbersClass list2 = new addTwoNumbersClass();


        list1.addToTheLast(new ListNode(8));
        list1.addToTheLast(new ListNode(8));
        list1.addToTheLast(new ListNode(8));
        System.out.println("first number in reverse form");
        list1.printList(list1.head);

        list2.addToTheLast(new ListNode(9));
        list2.addToTheLast(new ListNode(9));
        list2.addToTheLast(new ListNode(9));
        System.out.println("second number in reverse form");
        list2.printList(list2.head);

        list1.head = addTwoNumber(list1.head, list2.head);
        System.out.println("");
        System.out.println("final number after adding it");
        list1.printList(list1.head);
    }

    private static ListNode addTwoNumber(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // head ko set karne ke liye so end me dummy.next return kar do
        ListNode p = dummy;
        int carry = 0;
        // simple add everthing in carry till last
        while(l1!=null || l2!=null || carry!=0) {
            if(l1!=null) {
                carry += l1.data;
                l1=l1.next;
            }
            if(l2!=null) {
                carry +=  l2.data;
                l2=l2.next;
            }

            p.next = new ListNode(carry%10); // p cant use as its pointing to head
            carry = carry/10;
            p = p.next; // imp
            System.out.println(carry);
        }
        return dummy.next;
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
