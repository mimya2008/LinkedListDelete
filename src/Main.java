public class Main {
    public static void main(String[] args) {
        SingleLinkedListTest sll = new SingleLinkedListTest();

        // Insert nodes
        sll.insertLinkedList(1, 0);
        sll.insertLinkedList(2, 1);
        sll.insertLinkedList(3, 2);
        sll.insertLinkedList(4, 3);

        System.out.println("Initial List:");
        sll.traverseLinkedList();

        System.out.println("\nSearching node value 5:");
        sll.searchNode(5);

        System.out.println("\nDeleting node position 2 (middle):");
        sll.delete(2);
        sll.traverseLinkedList();

        System.out.println("\nDeleting node position 0 (head):");
        sll.delete(0);
        sll.traverseLinkedList();

        System.out.println("\nInserting node at the end:");
        sll.insertLinkedList(99, sll.size);  // Appending new tail
        sll.traverseLinkedList();

        System.out.println("\nDeleting node position " + (sll.size - 1) + " (tail):");
        sll.delete(sll.size - 1);
        sll.traverseLinkedList();

        System.out.println("\nAttempting to delete an invalid position 10:");
        sll.delete(10);
        sll.traverseLinkedList();
    }
}
