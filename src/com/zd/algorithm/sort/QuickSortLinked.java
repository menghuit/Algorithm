package com.zd.algorithm.sort;

import com.zd.algorithm.Node;
import com.zd.algorithm.Utils;

/**
 * 单链表 快速排序
 * 分：使用前后指针法
 * @author zhangdi
 */
public class QuickSortLinked {
	public static void main(String[] args) {
		Integer[] nums = { 2, 8, 7, 1, 3, 5, 6, 4, 5 };
		Node<Integer> head = Utils.genLinkedFrom(nums);
		System.out.print("排序前：");
		Utils.logLinkedShort(head);
		quickSort(head, null);
		System.out.print("\n排序后：");
		Utils.logLinkedShort(head);
	}
	
	private static void quickSort(Node<Integer> head, Node<Integer> end) {
		if (head == end || head.next == end) return;
		Node<Integer> privotNode = partition(head, end);
		quickSort(head, privotNode);
		quickSort(privotNode.next, end);
	}
	
	private static Node<Integer> partition(Node<Integer> head, Node<Integer> end){
		if(head == end || head.next == end) return head;
		int privotV = head.data;
		
		Node<Integer> privotNode = head, preNode = head, curNode = head;
		while(curNode != end) { // end 起初为null，中期为基数点
			if(curNode.data < privotV) {
				preNode = preNode.next;
				Utils.swapNodeValue(curNode, preNode);
			}
			curNode = curNode.next;
		}
		Utils.swapNodeValue(privotNode, preNode);
		
		return preNode;
	}
}
