package com.neu.CCI.RecursionAndDynamicProgramming;

import com.neu.bBy.RemoveDuplicatesLinkedList;

/**
 * Created by raghu on 1/6/2017.
 */

  class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }

  class Result{
      int x;
      Result(int x)
      {
          this.x = x;
      }
  }
public class Recursion {
    public static void main(String[] args) {
        ListNode temp = new ListNode(6);
        temp.next = new ListNode(3);
        temp.next.next = new ListNode(7);
        temp.next.next.next = new ListNode(3);
        temp.next.next.next.next = new ListNode(6);

         Result result = new Result(1);
        new Recursion().recure(temp, temp, result);
        System.out.println(result.x);
    }


    public ListNode recure(ListNode A, ListNode b, Result result)
    {
        if(b == null)
        {
            return A;
        }

        if(b.next == null)
        {
            return A.next;
        }

        ListNode val = recure(A.next, b.next.next, result);
  //      System.out.println(result);
        System.out.println(A.val+" "+val.val);



        if(result.x == 0 || A.val != val.val )
        {
            result.x = 0;
        }
      //  System.out.println(result);
        return val.next;
    }
}
