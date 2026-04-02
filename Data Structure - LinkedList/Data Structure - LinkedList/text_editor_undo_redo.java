package Submission_of_Data_Structure_LinkedList;

public class text_editor_undo_redo {

    static class State {
        String content;
        State next, prev;
        State(String content) { this.content = content; }
    }

    State current = null;
    int size = 0;
    int MAX_SIZE = 10;

    public void type(String content) {
        State newState = new State(content);
        if (current == null) {
            current = newState;
        } else {
            current.next = newState;
            newState.prev = current;
            current = newState;
        }
        size++;
        if (size > MAX_SIZE) {
            State head = current;
            while (head.prev != null) head = head.prev;
            head.next.prev = null;
            size--;
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    public void display() {
        if (current != null) {
            System.out.println("Text: " + current.content);
        }
    }

    public static void main(String[] args) {
        text_editor_undo_redo te = new text_editor_undo_redo();
        te.type("Hello");
        te.type("Hello World");
        te.display();
        te.undo();
        te.display();
        te.redo();
        te.display();
    }
}