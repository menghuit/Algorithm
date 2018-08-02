package com.zd.algorithm.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import com.zd.algorithm.Node;
import com.zd.algorithm.Utils;

/**
 * @author zhangdi
 * 合并两个有序的单链表
 */
public class MergeTwoSortedList {

	public static void main(String[] args) {
		// 生成已排序待合并的数组
		Integer[] arrA = {2,9,80,100};
		Integer[] arrB = {19,30,32,55,90};
		Node<Integer> A = Utils.genLinkedFrom(arrA);
		Node<Integer> B = Utils.genLinkedFrom(arrB);
		
		System.out.print("A:");
		Utils.logLinkedShort(A);
		System.out.print("B:");
		Utils.logLinkedShort(B);
		
		System.out.println("合并之后：");
		Node<Integer> merged = merge(A, B);
		Utils.logLinkedShort(merged);
	}

	/**
	 * 合并两个有序的单链表
	 * @param a 单链表A
	 * @param b 单链表B
	 * @return 新的单链表
	 */
	private static Node<Integer> merge(Node<Integer> a, Node<Integer> b) {
		if(a == null && b == null) return null;
		
		// 使用一个首结点，就不用麻烦的判断到底使用哪个作为头了
		Node<Integer> head = new Node<>();
		Node<Integer> cursor = head;
		while(a != null || b != null) {
			if(b == null || (a != null && a.data <= b.data)) { // (a不为空且小于等于b) || b已为空
				cursor.next = a;
				a = a.next;
			}else {
				cursor.next = b;
				b = b.next;
			}
			cursor = cursor.next;
		}
		return head.next;
	}

	
}
