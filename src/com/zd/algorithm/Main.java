package com.zd.algorithm;

import java.util.HashSet;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

public class Main {

	public static void main(String[] args) {
		Node head = new Node(-1);
		Node tmp = head;
		for(int i=0;i<3;i++){
			tmp.nextNode = new Node(i);
			tmp = tmp.nextNode;
		}
		log(head);
		
		System.out.println();
		head = reverse(head);
		log(head);
	}
	
	public static Node reverse(Node head) {    
        if (null == head || null == head.getNextNode()) {    
            return head;    
        }    
        Node reversedHead = reverse(head.getNextNode());    
        head.getNextNode().setNextNode(head);    
        head.setNextNode(null);    
        return reversedHead;    
    }  
	
	private static void log(Node head){
		Node t1 = head;
		do{
			System.out.print(t1.getRecord()+",");
		}while((t1 = t1.nextNode) != null);
	}

	static class Node {    
	    //变量    
	    private int record;    
	    //指向下一个对象    
	    private Node nextNode;    
	    
	    public Node(int record) {    
	        super();    
	        this.record = record;    
	    }    
	    public int getRecord() {    
	        return record;    
	    }    
	    public void setRecord(int record) {    
	        this.record = record;    
	    }    
	    public Node getNextNode() {    
	        return nextNode;    
	    }    
	    public void setNextNode(Node nextNode) {    
	        this.nextNode = nextNode;    
	    }
		@Override
		public String toString() {
			return "Node [record=" + record + "]";
		} 
	}    
}
