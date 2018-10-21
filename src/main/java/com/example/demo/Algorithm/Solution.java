package com.example.demo.Algorithm;
import com.google.common.base.Joiner;

import java.util.*;


/**
 * @author lei.X
 * @date 2018/9/8
 */







public class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 使用pre 和cur 来代替root和head的目的是在于返回的时候能直接得到头部节点
     * @param head
     * @return
     */

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode root  = new ListNode(-1);
        ListNode pre = root;
        root.next = head;
        ListNode cur = head;

        while (cur != null){

            while (cur.next != null && cur.next.val == cur.val){
                cur = cur.next;
            }

            if (pre.next == cur){  //不存在重复值的时候
                pre = pre.next;
            }else{    // 跳过重复值
                pre.next = cur.next;
            }
            cur = cur.next;
        }


        return root.next;


    }



    public static void main(String[] args) {


        Solution solution = new Solution();
//        System.out.println(solution.deleteDuplicates("10"));

    }
}
