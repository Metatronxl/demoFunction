package com.example.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lei.X
 * @date 2018/9/11
 */
public class Utils {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public ListNode buildListNode(){

        List<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        ListNode res = new ListNode(0);
        ListNode cur = res;
        for (int i=0;i<list.size();i++){
            ListNode temp = new ListNode(list.get(i));
            res.next = temp;
            res = res.next;
        }
        return  cur.next;
    }

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }


}
