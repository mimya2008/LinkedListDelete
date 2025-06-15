package undo_redo_manager;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList<String> manager = new DoubleLinkedList<>();

        manager.addState("Planning of New Project");
        manager.addState("Meeting with Client");
        manager.addState("Meeting with DevOps Team");

        System.out.println("Latest Task: " + manager.getCurrentState());
        manager.undo();
        System.out.println("After Undo: " + manager.getCurrentState());
        manager.redo();
        System.out.println("After Redo: " + manager.getCurrentState());

        manager.addState("Finalize the Product");
        System.out.println("Adding New Task: " + manager.getCurrentState());
        boolean canRedo = manager.redo();
        System.out.println("Can redo again? " + canRedo);

        System.out.println("\nAll Tasks in Order:");
        manager.traverseStates();
    }
}

