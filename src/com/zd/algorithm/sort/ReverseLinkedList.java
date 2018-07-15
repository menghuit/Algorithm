package com.zd.algorithm.sort;

import java.util.LinkedList;

/**
 * 
 * @author zhangdi
 */
public class ReverseLinkedList {
	static class Node {
		String value;
		Node next;
	}

	public static void main(String[] args) {
		// 创建单链表-尾插法
		System.out.println("尾插法创建单链表");
		Node head = createLinkedListByTail();
		printLinkedList(head);

		// 创建单链表-头插法
		System.out.println("头插法创建单链表");
		Node head1 = createLinkedListByHead();
		printLinkedList(head1);

		// 递归法逆序
		System.out.println("递归法逆序");
		recursive(head);
		System.out.println("");

		// 使用头插法 逆序输出
		System.out.println("头插法 逆序输出");
		reverseViaHeadInsert(head);
	}

	private static Node createLinkedListByHead() {
		Node head = null;
		for (int i = 0; i < 10; i++) {
			Node n = new Node();
			n.value = String.valueOf(i);
			n.next = head;
			head = n;
		}
		return head;
	}

	// 尾插法
	private static Node createLinkedListByTail() {
		Node head=null;
		Node tail=null;
		for (int i = 0; i < 10; i++) {
			Node n = new Node();
			n.value = String.valueOf(i);
			
			// 保证head指向第一个节点
			if(head == null) {
				head = n;
			}else {
				tail.next = n;
			}
			tail = n;
		}
		return head;
	}

	// 递归
	private static void recursive(Node node) {
		if (node == null) {
			return;
		}
		recursive(node.next);
		System.out.print(node.value + ",");
	}
	
	// 头插法逆序
	private static void reverseViaHeadInsert(Node node) {
		Node head = null;
		Node tmp = node;
		while(tmp != null) {
			Node next = tmp.next;
			// 头插法：新节点的next指向H所指向的节点；H 指向 新节点
			tmp.next = head;
			head = tmp;
			
			tmp = next;
		}
		
		printLinkedList(head);
	}

	private static void printLinkedList(Node head) {
		Node n = head;
		while (n != null) {
			System.out.print(n.value + ",");
			n = n.next;
		}
		System.out.println("");
	}
}
