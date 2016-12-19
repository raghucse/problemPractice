package com.neu;

/**
 * Created by raghu on 12/14/2016.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        System.out.println("here ");
        int num1 = 0;
        int num2 = 0;
        int carry = 0;
        int result[];
        ListNode finalResultl = null;
        int finalResult = 1;
        ListNode temp = null;

        // while anyone is not null go into the loop
        while(l1.next != null || l2.next != null)
        {
            // get values to be added
            if(l1.next == null)
            {
                num1 = 0;
            }
            else
            {
                num1 = l1.val;
                l1 = l1.next;
            }

            if(l2.next == null)
            {
                num2 = 0;
            }
            else
            {
                num2 = l2.val;
                l2 = l2.next;
            }

            result = addNumber(num1, num2, carry);

            if(l1.next != null && l2.next != null){
                if(result[0] == 0) {
                    finalResult = (finalResult * 10) + result[1];
                }
                else{
                    finalResult = (finalResult * 10) + result[0];
                    finalResult = (finalResult * 10) + result[1];
                }
            }
            else
            {
                finalResult = (finalResult * 10) + result[1];
            }

        }

        while(finalResult > 10)
        {

            int num = finalResult % 10;
            finalResult = (finalResult - num)/10;
            if(finalResultl == null){
                finalResultl = new ListNode(num);
                temp = finalResultl;
            }
            else
            {
                finalResultl.next = new ListNode(num);
            }

        }

        return temp;


    }

    public int[] addNumber(int num1, int num2, int carry)
    {
        int sum = num1 + num2 + carry;
        int result[] = new int[2];

        if(sum > 9){
            result[1] = sum % 10;
            result[0] = 1;
        }
        else
        {
            result[1] = sum;
            result[0] = 0;
        }

        return result;
    }

}