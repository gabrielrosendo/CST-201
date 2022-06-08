
public class Main {

	public static void main(String[] args) {
		LinkedList myList = new LinkedList();
		// insert data into linked list
		myList.insert(10);
		myList.insert(5);
		myList.insert(15);
		myList.insert(20);
		myList.insert(8);
		myList.insert(3);
		
		// access first element of list
		System.out.println("first element: " + myList.front().data);
		
		// access last element of list
		System.out.println("last element: " + myList.back().data);
		
		System.out.print("Print list: ");
		myList.printList();
		// delete first element of the list
		myList.pop_front();
		myList.printList();
		// delete last element of the list
		myList.pop_back();
		myList.printList();
		
		// determine if list is empty
		System.out.println("myList is empty: " + myList.empty());

		// merge with another list
		LinkedList newList = new LinkedList();
		newList.insert(25);
		newList.insert(13);
		newList.insert(19);
		newList.insert(3);


		System.out.print("List 1: ");
		myList.printList();
		System.out.print("List 2: ");
		newList.printList();
		LinkedList mergedList = myList.merge(newList);
		// print out merged list
		System.out.print("Merged list: ");
		mergedList.printList();
		
		//reverse list
		System.out.print("Reversed list: ");
		mergedList.reverse();
		mergedList.printList();
	}

}
