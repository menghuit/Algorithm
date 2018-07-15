package com.zd.algorithm;

public final class Utils {

	public static void logLinked(Node<?> head){
		Node<?> t1 = head;
		do{
			System.out.print(t1.toString()+",");
		}while((t1 = t1.next) != null);
	}
	
	public static void logLinkedShort(Node<?> head){
		Node<?> t1 = head;
		do{
			System.out.print(t1.toShortString()+",");
		}while((t1 = t1.next) != null);
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
		Node<T> head=null;
		Node<T> tail=null;
		for (T t : arrays) {
			Node<T> n = new Node<T>(t);
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
	
	public static <T> Node<T> genLinkedFrom(T[] arrays){
		return createLinkedListByTailFrom(arrays);
	}
	
	public static <T> void swapNodeValue(Node<T> a, Node<T> b) {
		if(a == null || b == null) 
			throw new NullPointerException("Node a or b is null!");
		T tmp = a.data;
		a.data = b.data;
		b.data = tmp;
	}
}
