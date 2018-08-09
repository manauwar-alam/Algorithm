package com.manauwar.dataStructure.linkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		
		LinkedList.Node node1 = new LinkedList.Node("1001");
		LinkedList.Node node2 = new LinkedList.Node("1002");
		
		//creating LinkedList with 5 elements including head
        LinkedList linkedList = new LinkedList();
        linkedList.appendIntoTail(new LinkedList.Node("101"));
        linkedList.appendIntoTail(new LinkedList.Node("201"));
        linkedList.appendIntoTail(new LinkedList.Node("301"));
        linkedList.appendIntoTail(new LinkedList.Node("401"));
        
        //checking cyclic
        
        linkedList.appendIntoTail(node1);
        linkedList.appendIntoTail(node2);
        linkedList.appendIntoTail(node1);
        

        System.out.println("Linked List : " + linkedList);

        if(linkedList.isCyclic()){
            System.out.println("Linked List is cyclic as it contains cycles or loop");
        }else{
            System.out.println("LinkedList is not cyclic, no loop or cycle found");
        }   

        
        
        
        //getting nth node of linked list
       
        System.out.println("\nThe first node from last: " + linkedList.getLastNode(1));
        System.out.println("The second node from the end: " + linkedList.getLastNode(2));
        System.out.println("The third node from the tail: " + linkedList.getLastNode(3));



        

	}

}
