package com.zd.algorithm.list;

import com.zd.algorithm.Node;
import com.zd.algorithm.Utils;

/**
 * @author zhangdi
 * 带有环的单链表
 * 1.判断是否有环
 * 	 原理：快慢指针追击问题
 * 2.找出环的起点
 * 	 原理：假设快慢指针在P点相遇，(a表示从头结点到环起点的距离，p表示从环起点到P点距离，环用r表示)
 *   那么有快指针走过 a+p+nr 距离，慢指针走过 a+p 距离，又快指针是慢指针速度的2倍，
 *   得到 a+p+nr=2a+2p，化简：nr=a+p，
 *   所以从P点再向前走a距离，即可找到环起点
 */
public class LinkedListCycle {
	public static void main(String[] args) {
		Integer[] nums = /*Utils.genRandomArray(5);*/{16, 10, 33, 41, 8};
		Node<Integer> head = Utils.genLinkedFrom(nums);
		Utils.logLinkedShort(head);
		System.out.println("生成环：" + (cycle(head, 3) ? "成功" : "失败"));
		
		System.out.println("是否存在环？"+hasCycle(head));
		System.out.println("环起点："+findNodeWhereCycleBegins(head));
	}
	
	/**
	 * 直接生成带有环的单链表
	 * @param arrays 准备数据
	 * @param cycle 环的起点位置, 从0开始计
	 * @return
	 */
	private static Node<Integer> genLinkedListWithCycle(int[] arrays, int cycle) {
		if (cycle == arrays.length - 1 || cycle == 0)
			return null;

		Node<Integer> head = null, tail = null, cycleNode = null;
		for (int i = 0; i < arrays.length; i++) {
			Node<Integer> node = new Node<>(arrays[i]);
			// 保存环起点
			if (cycle == i) {
				cycleNode = node;
			}
			// 尾插发生成单链表
			if (head == null) {
				head = node;
			} else {
				tail.next = node;
			}
			tail = node;

			// 最后一个元素的next再指向cycleNode，形成环
			if (i == arrays.length - 1) {
				tail.next = cycleNode;
			}
		}
		return head;
	}

	/**
	 * 使指定的单链表形成环
	 * @param head 单链表
	 * @param cycleIndex 环的起始点, 从0开始计
	 * @return 是否成环
	 */
	private static boolean cycle(Node<Integer> head, int cycleIndex) {
		int count = 0;
		Node<Integer> cycle = null; // 环的起点
		Node<Integer> tail = null; // 尾结点
		while(head != null) {
			if(count++ == cycleIndex) { // 寻找环起点
				cycle = head;
			}
			if(head.next == null) { // 末结点
				tail = head;
			}
			head = head.next;
		}
		// 连接成环
		if(cycle != null && tail != null) {
			tail.next = cycle;
			return true;
		}
		return false;
	}
	
	/**
	 * 判断单链表是否有环
	 * @param head
	 * @return
	 */
	private static boolean hasCycle(Node<Integer> head) {
		if(head == null || head.next == null) return false;
		
		Node<Integer> fast = head, slow = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) return true;
		}
		return false;
	}
	
	/**
	 * 寻找环的起点
	 * @param head 单链表
	 * @return 找到返回环的起点，否则返回null
	 */
	private static Node<Integer> findNodeWhereCycleBegins(Node<Integer> head){
		if(head == null || head.next == null) return null;
		
		Node<Integer> fast = head, slow = head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) {
				fast = head;
				while(fast != slow) {
					fast = fast.next;
					slow = slow.next;
				}
				return fast;
			}
		}
		return null;
	}
}
