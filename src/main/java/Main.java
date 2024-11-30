package List;

import java.util.Scanner;

public class Main {
	
	public static void main(String[]args) {
		int [] arr= {7, 2, 8};

		Node<Integer> list = buildList(arr);
		Node<Integer> list2 = buildList(arr);


		System.out.println("The list:");
	    printList(list);
	    
	    System.out.println("The list- recursion: ");
	    printListRecursive(list);  

	    System.out.println("The list- reverse: ");
	    printListReverse(list);
		
		
		//System.out.println(inputList());
		
		System.out.print ("The zoogi numbers in the list are: ");
		zoogiNumbersInList(list);
		System.out.println();
		
		boolean numInList = findNumberInList(list, 7);
		System.out.print ("Is number in list? ");
		System.out.println (numInList);
		
		
		System.out.print ("Is number in list?- recursion: ");
		System.out.println (findNumberInListRecursion(list, 7));
		
	    list = deleteNode (list, 7);
		System.out.println("Delete Node: " + list);
		
		list2 = deleteNodeInX (list2, 0);
		System.out.println("Delete node in index: " + list2);
		
}
	
	public static Node<Integer> buildList (int []arr) {
		Node<Integer> head = new Node<>(arr[0]);
		Node<Integer> prev = head;
		for(int i=1; i<arr.length; i++) {
			Node<Integer>p=new Node <Integer>(arr[i]);
			prev.setNext(p);
			prev=p;
		}
		return head;
	}
	
	
	 public static void printList(Node<Integer> head) {
	        Node<Integer> current = head;
	        while (current != null) {
	            System.out.println(current.getValue());
	            current = current.getNext();
	        }
	    }
	
	
	 public static void printListRecursive(Node<Integer> head) {
		 if (head == null) {
		        return;
		 }
		 System.out.println(head.getValue());
		 printListRecursive(head.getNext());
	 }
	 
	 
	 public static void printListReverse(Node<Integer> head) {
		 if (head == null) {
		        return;
		 }
		 printListReverse(head.getNext());
		 System.out.println(head.getValue());
	 }
	


	 public static Node<Integer> inputList() {
	     Scanner scanner = new Scanner(System.in);
	     Node<Integer> head = new Node<>(null); 
	     Node<Integer> p = head; 

	     System.out.println("Enter a number or -1 to end:");
	     int digit = scanner.nextInt();

	     while (digit != -1) {
	         Node<Integer> newNode = new Node<>(digit); 
	         p.setNext(newNode); 
	         p = newNode; 
	         System.out.println("Enter a number or -1 to end:");
	         digit = scanner.nextInt(); 
	     }
	     return head.getNext(); 
	 }
	
	 public static void zoogiNumbersInList(Node<Integer> head) {
		 while (head != null) {
			 if (head.getValue() % 2 == 0) {
				 System.out.print(head.getValue()+ " ");
			 }
			 head = head.getNext();
		 }
	 }
	 
	    public static boolean findNumberInList(Node<Integer> head, int num) {
	        while (head != null) {
	            if (head.getValue() == num) {
	                return true;
	            }
	            head = head.getNext();
	        }
	        return false;
	    }
	    
	    public static boolean findNumberInListRecursion (Node<Integer> head, int num) {
	    	if (head == null) {
	    		return false;
	    	}
	    	if (head.getValue() == num) {
	    		return true;
	    	}
	    	return	findNumberInListRecursion (head.getNext(), num);
	    }

	public  static Node<Integer> deleteNode (Node <Integer> h, int x) {
		h = new Node<Integer>(-1, h);
		Node<Integer> p = h;
		boolean done = false;
		while (!done && p.hasNext()) {
			if (p.getNext().getValue() == x) {
				p.setNext(p.getNext().getNext());
				done = true;
			} else {
				p = p.getNext();
			}
		}
		return h.getNext();
	}
	
	
	public  static Node<Integer> deleteNodeInX (Node <Integer> head, int x) {
		 if (head == null) {
		        return null;
		    }
		  if (x == 0) {
		        return head.getNext();
		    }
		  Node<Integer> current = head;
		    int count = 0;

		    while (current != null && count < x - 1) {
		        current = current.getNext();
		        count++;
		    }
		    
		    current.setNext(current.getNext().getNext()); 
		    return head; 
	}

}
