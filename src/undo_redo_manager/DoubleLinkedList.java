package undo_redo_manager;

public class DoubleLinkedList<T> {
    public DoubleNode<T> head;
    public DoubleNode<T> tail;
    public DoubleNode<T> current;
    public int size;

    public void createLinkedList(T nodeValue) {
        DoubleNode<T> node = new DoubleNode<>();
        node.value = nodeValue;
        node.next = null;
        node.previous = null;
        head = node;
        tail = node;
        current = node;
        size = 1;
    }

    public void addState(T nodeValue) {
        if (head == null) {
            createLinkedList(nodeValue);
            return;
        }

        DoubleNode<T> node = new DoubleNode<>();
        node.value = nodeValue;

        current.next = null;

        // Connecting the new node
        current.next = node;
        node.previous = current;
        tail = node;
        current = node;
        size++;
    }

    public boolean undo() {
        if (current != null && current.previous != null) {
            current = current.previous;
            return true;
        }
        return false;
    }

    public boolean redo() {
        if (current != null && current.next != null) {
            current = current.next;
            return true;
        }
        return false;
    }

    public T getCurrentState() {
        return current != null ? current.value : null;
    }

    public void traverseStates() {
        DoubleNode<T> tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.value);
            if (tempNode.next != null) {
                System.out.print(" <-> ");
            }
            tempNode = tempNode.next;
        }
        System.out.println();
    }
}
