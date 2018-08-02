package com.zd.algorithm;

import java.util.Random;

public final class Utils {

	public static void logLinked(Node<?> head) {
		Node<?> t1 = head;
		do {
			System.out.print(t1.toString() + ",");
		} while ((t1 = t1.next) != null);
		System.out.println();
	}

	public static void logLinkedShort(Node<?> head) {
		Node<?> t1 = head;
		do {
			System.out.print(t1.toShortString() + ",");
		} while ((t1 = t1.next) != null);
		System.out.println();
	}

	// 头插法 创建单链表
	public static <T> Node<T> createLinkedListByHeadFrom(T[] arrays) {
		Node<T> head = null;
		for (T t : arrays) {
			Node<T> n = new Node<T>(t);
			n.next = head;
			head = n;
		}
		return head;
	}

	// 尾插法 创建单链表
	public static <T> Node<T> createLinkedListByTailFrom(T[] arrays) {
		Node<T> head = null;
		Node<T> tail = null;
		for (T t : arrays) {
			Node<T> n = new Node<T>(t);
			// 保证head指向第一个节点
			if (head == null) {
				head = n;
			} else {
				tail.next = n;
			}
			tail = n;
		}
		return head;
	}

	public static <T> Node<T> genLinkedFrom(T[] arrays) {
		return createLinkedListByTailFrom(arrays);
	}

	public static <T> void swapNodeValue(Node<T> a, Node<T> b) {
		if (a == null || b == null)
			throw new NullPointerException("Node a or b is null!");
		T tmp = a.data;
		a.data = b.data;
		b.data = tmp;
	}

	/**
	 * 交换数组中两个值
	 * @param A 数组
	 * @param i 待交换的下标
	 * @param j 待交换的下标
	 */
	public static void swap(int[] A, int i, int j) {
		if (A == null || A.length == 0)
			throw new NullPointerException("The A is null or empty!");
		int len = A.length;
		if (i < 0 || j < 0 || i >= len || j >= len) {
			throw new IndexOutOfBoundsException("The length of A is " + len + ",i=" + i + ",j=" + j);
		}
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}

	/**
	 * 生成随机整数数组
	 * 
	 * @param count
	 *            个数
	 * @return 数组
	 */
	public static int[] genRandomArray(int count) {
		Random r = new Random();
		int[] A = new int[count];
		for (int i = 0; i < count; i++) {
			A[i] = r.nextInt(count * 10);
		}
		return A;
	}
	
	public static Integer[] genRandomIntegerArray(int count) {
		Random r = new Random();
		Integer[] A = new Integer[count];
		for (int i = 0; i < count; i++) {
			A[i] = r.nextInt(count * 10);
		}
		return A;
	}
}
