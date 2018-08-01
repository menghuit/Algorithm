package com.zd.algorithm.list;

import com.zd.algorithm.Node;
import com.zd.algorithm.Utils;

/**
 * @author zhangdi
 * 带有环的单链表
 * 1.判断是否有环
 * 2.找出环的起点
 */
public class LinkedListCycle {
	public static void main(String[] args) {
		int[] nums = /*Utils.genRandomArray(5);*/{16, 10, 33, 41, 8};
		Node<Integer> head = genLinkedListWithCycle(nums, 2);
		System.out.println(head.toShortString());
		
		
	}
	
	/**
	 * 生成带有环的单链表
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
	 * 判断单链表是否有环
	 * @param head
	 * @return
	 */
	private static boolean hasCycle(Node<Integer> head) {
		
		return false;
	}
}
