import java.util.Iterator;

public class LinkedListDemo {
    public static void main(String args[]) {
        LinkedList<String> list = new LinkedList<String>();
        list.insert("Linked List");
        list.insert("Doubly Linked list");
        list.insert("Heap");
        list.insert("Arrays");
        list.insert("Binary Trees");
        list.insert("Graphs");

        // -> |Graphs| -> |Binary Trees| -> |Arrays| -> |Heap| -> |Doubly Linked list| -> |Linked List|
        System.out.println(list);

        // Delete index 0
        System.out.println("Delete index 0: " + list.delete());

        // Delete at index 2
        System.out.println("Delete index 2: " + list.delete(2));

        // Insert at index 2
        list.insert("HashMap", 2);

        // Print final list
        System.out.println(list);
        
    }
}
