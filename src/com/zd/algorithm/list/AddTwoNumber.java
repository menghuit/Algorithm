package com.zd.algorithm.list;

import com.zd.algorithm.Node;
import com.zd.algorithm.Utils;

/**
 * 两个正整数用单链表逆序输出，再相加，逆序输出. 
 * 如：123+456=579 
 *    {3->2->1}+{6->5->4}={9->7->5}
 * @author zhangdi
 */
public class AddTwoNumber {
	public static void main(String[] args) {
		Node<Integer> head = gen(759);
		Utils.logLinkedShort(head);
		System.out.println("-----");
		Node<Integer> headB = gen(456);
		Utils.logLinkedShort(headB);

		System.out.println("-----");
		Node<Integer> result = add(head, headB);
		Utils.logLinkedShort(result);
	}

	private static Node<Integer> gen(int source) {
		Node<Integer> head = null;
		Node<Integer> tail = null;

		int tmp = source;
		do {
			Node<Integer> node = new Node<Integer>(tmp % 10);

			if (head == null) {
				head = node;
			} else {
				tail.next = node;
			}
			tail = node;

			tmp = tmp / 10;
		} while (tmp != 0);

		return head;
	}

	private static Node<Integer> add(Node<Integer> A, Node<Integer> B) {
		int extra = 0;
		Node<Integer> tail = null;
		Node<Integer> head = null;
		while (A != null || B != null || extra != 0) {
			int sum = 0;
			sum += A != null ? A.data : 0;
			sum += B != null ? B.data : 0;
			sum += extra;
			extra = sum / 10;

			if (A != null)
				A = A.next;
			if (B != null)
				B = B.next;

			Node<Integer> node = new Node<Integer>(sum % 10);
			if (head == null) {
				head = node;
			} else {
				tail.next = node;
			}
			tail = node;
		}

		return head;
	}

}
