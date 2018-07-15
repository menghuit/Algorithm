package com.zd.algorithm;

public class Node<T> {

	public T data;
	public Node<T> next;
	
	public Node() {}
	
	public Node(T data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "Node ["
				+ "data=" + data == null ? "NULL" : data.toString() 
				+ ", next=" + (next == null ? "NULL" : next.hashCode())
				+ "]";
	}
	
	public String toShortString() {
		return data == null ? "NULL" : data.toString();
	}
}
