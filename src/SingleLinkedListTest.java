public class SingleLinkedListTest {
    public Node head;
    public Node tail;
    public int size;

    // Create single linked list
    public Node createSingleLinkedlist(int nodeValue) {
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    // Insert a node at a specific location
    public void insertLinkedList(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;

        if (head == null) {
            createSingleLinkedlist(nodeValue);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
        } else if (location >= size) {
            node.next = null;
            tail.next = node;
            tail = node;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;
        }
        size++;
    }

    // Traverse and print the linked list
    public void traverseLinkedList() {
        if (head == null) {
            System.out.println("SLL does not exist");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
            System.out.println();
        }
    }

    // Search for a node by value
    public boolean searchNode(int nodeValue) {
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Found the node at location: " + i);
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found");
        return false;
    }

    // Delete a node at a given position
    public void delete(int position) {
        if (head == null) {
            System.out.println("Linked List does not exist.");
            return;
        }

        if (position < 0 || position >= size) {
            System.out.println("Invalid position: " + position);
            return;
        }

        if (position == 0) {
            // Delete at beginning
            head = head.next;
            size--;
            if (size == 0) {
                tail = null; // List is now empty
            }
            System.out.println("Node deleted at position 0 (head)");
            return;
        }

        if (position == size - 1) {
            // Delete at end
            Node tempNode = head;
            for (int i = 0; i < size - 2; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = null;
            tail = tempNode;
            size--;
            System.out.println("Node deleted at position " + position + " (tail)");
            return;
        }

        // Delete from the middle
        Node tempNode = head;
        for (int i = 0; i < position - 1; i++) {
            tempNode = tempNode.next;
        }
        tempNode.next = tempNode.next.next;
        size--;
        System.out.println("Node deleted at position " + position);
    }

}

