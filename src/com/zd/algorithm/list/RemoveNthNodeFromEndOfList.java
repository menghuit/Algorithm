package com.zd.algorithm.list;

import com.zd.algorithm.Node;
import com.zd.algorithm.Utils;

/**
 * @author zhangdi 
 * 删除单链表倒数第N个元素
 */
public class RemoveNthNodeFromEndOfList {
	public static void main(String[] args) {
		Node<Integer> head = Utils.genLinkedFrom(new Integer[] {2, 8, 7, 1, 3, 10, 6, 4, 5});
		Utils.logLinkedShort(head);
		dele(head, 9);
		
		System.out.println("------------");
		Utils.logLinkedShort(head);
		dele(head, 3);
		
		System.out.println("------------");
		Node<Integer> head1 = Utils.genLinkedFrom(new Integer[] {2, 8});
		Utils.logLinkedShort(head1);
		dele(head1, 1);
		
		System.out.println("------------");
		Node<Integer> head2 = Utils.genLinkedFrom(new Integer[] {2});
		Utils.logLinkedShort(head2);
		dele(head2, 1);
	}

	/**
	 * 删除倒数第n个元素
	 * @param nth 倒数第几个元素
	 */
	private static void dele(Node head, int nth) {
		Node p1 = head; // 快指针
		Node p2 = head; // 慢指针
		int count = 0;
		// 先将p1向后移动n次
		while (count++ < nth) {
			p1 = p1.next;
		}
		// 要删除的结点是首结点
		if(p1 == null) {
			head = null;
			System.out.println("删除后：head = null");
			return;
		}
		
		while(p1.next != null) {
			p2 = p2.next;
			p1 = p1.next;
		}
		p2.next = p2.next.next;
		System.out.print("删除后：");
		Utils.logLinkedShort(head);
	}
}
