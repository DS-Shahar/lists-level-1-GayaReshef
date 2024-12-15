package List;

import java.util.Scanner;

public class Main {
	static int [] arr= {7, 8, 2};
	static int [] arr2= {2, 8, 5, 9};
	static Node<Integer> list = buildList(arr);
	static Node<Integer> list2 = buildList(arr2);
	static Node<Integer> list2Head = list2;
	
	public static void main(String[]args) {

	    System.out.println("The list:");
	    printList(list);
	    System.out.println(list2);
//	    
//	    System.out.println("The list- recursion: ");
//	    printListRecursive(list);  
//
//	    System.out.println("The list- reverse: ");
//	    printListReverse(list);
//		
//		
//		//System.out.println(inputList());
//		
//		System.out.print ("The zoogi numbers in the list are: ");
//		zoogiNumbersInList(list);
//		System.out.println();
//		
//		boolean numInList = findNumberInList(list, 7);
//		System.out.print ("Is number in list? ");
//		System.out.println (numInList);
//		
//		
//		System.out.print ("Is number in list?- recursion: ");
//		System.out.println (findNumberInListRecursion(list, 7));
//		
//	    list = deleteNode (list, 7);
//		System.out.println("Delete Node: " + list);
//		
//		list2 = deleteNodeInX (list2, 2);
//		System.out.println("Delete node in index: " + list2);
//		
		System.out.println ("L1 in L2? " + list1IsInList2(list, list2));
		
		
		System.out.println ("L1 in L2- Recursion? " + list1IsInList2Recursion(list, list2));
		
		 printList1IsInList2(list, list2);
		 
		 Node<Integer> newList = findCommonValuesNewList (list, list2);
		 System.out.println ("new list: " + newList);
		 
		 Node<Integer> newL1 = removeNodesInList1(list, list2);
		 System.out.println ("new list 1: " + newL1);
}
	
	public static Node<Integer> buildList (int []arr) {
		Node<Integer> head = new Node<>(arr[0]);
		Node<Integer> prev = head;
		for(int i=1; i<arr.length; i++) {
			Node <Integer> p = new Node <Integer>(arr[i]);
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
		  if (x == 1) {
		        return head.getNext();
		    }
		  Node<Integer> current = head;
		    int count = 1;

		    while (current != null && count < x - 1) {
		        current = current.getNext();
		        count++;
		    }
		    
		    current.setNext(current.getNext().getNext()); 
		    return head; 
	}
	
	//בשבילי בלי רקורסיה
	public  static boolean list1IsInList2 (Node <Integer> headL1, Node <Integer> headL2){
		Node<Integer> currentL1 = headL1;
		Node<Integer> currentL2 = headL2;
		boolean found = false;
		while (currentL1 != null) {
			currentL2 = headL2;
			found = false;
			while (currentL2 !=  null) {
				if (currentL1.getValue() == currentL2.getValue()) {
					found = true;
				}
				currentL2 = currentL2.getNext();
			}
			if (found == false) {
				return false;
			}
			 currentL1 = currentL1.getNext();
		}
	
		return true;
	}
	
	
	public static boolean list1IsInList2Recursion(Node<Integer> currentL1, Node<Integer> currentL2) {
	    if (currentL1 == null) {
	        return true;
	    }

	    if (currentL2 == null) {
	        return false;
	    }

	    if (currentL1.getValue() == (currentL2.getValue())) {
	        return list1IsInList2Recursion(currentL1.getNext(), list2Head);  
	    }
	    return list1IsInList2Recursion(currentL1, currentL2.getNext());  
	}

	public  static void printList1IsInList2 (Node <Integer> headL1, Node <Integer> headL2){
		Node<Integer> currentL1 = headL1;
		Node<Integer> currentL2 = headL2;
		while (currentL1 != null) {
			currentL2 = headL2;
			while (currentL2 !=  null) {
				if (currentL1.getValue() == currentL2.getValue()) {
					System.out.println (currentL1.getValue());
				}
				currentL2 = currentL2.getNext();
			}
			currentL1 = currentL1.getNext();
		}
	}
	
	public static Node<Integer> findCommonValuesNewList(Node<Integer> list1, Node<Integer> list2) {
	    Node<Integer> dummy = new Node<>(0); 
	    Node<Integer> current = dummy;

	    Node<Integer> current1 = list1;

	    while (current1 != null) {
	        Node<Integer> current2 = list2;
	        boolean found = false;
	        while (current2 != null && found == false) {
	            if (current1.getValue().equals(current2.getValue())) {
	                current.setNext(new Node<>(current1.getValue())); 
	                current = current.getNext();
	                found = true; 
	            }
	            current2 = current2.getNext();
	        }

	        current1 = current1.getNext();
	    }

	    return dummy.getNext(); 
	}
	
	
	public static Node<Integer> removeNodesInList1(Node<Integer> list1, Node<Integer> list2) {
		 Node<Integer> dummy = new Node<>(-1, list1);
		 Node<Integer> p2 = list2;
		 Node<Integer> current = list1;
		 Node<Integer> p1 = dummy;
		 
		 while (current != null) {
		     boolean found = false;
			 p2 = list2;
			 while (p2 != null && found == false) {
				 if (current.getValue().equals(p2.getValue())) {
					 found = true; 
				 }
					 p2 = p2.getNext();
			 }
			 if ( found == true) {
				 p1.setNext(current.getNext());
			 }
			 else {
				p1 = current; 
				 
			 }
			 current = current.getNext();
		 }
		 return dummy.getNext();
	}


}
