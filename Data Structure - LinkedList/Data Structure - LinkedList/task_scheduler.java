package Submission_of_Data_Structure_LinkedList;

public class task_scheduler {

    static class Task {
        int id;
        String name;
        int priority;
        String dueDate;
        Task next;

        Task(int id, String name, int priority, String dueDate) {
            this.id = id;
            this.name = name;
            this.priority = priority;
            this.dueDate = dueDate;
        }
    }

    Task head = null;
    Task tail = null;
    Task current = null;

    public void addTask(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }

    public void removeTask(int id) {
        if (head == null) return;
        Task curr = head;
        Task prev = tail;
        do {
            if (curr.id == id) {
                if (curr == head && curr == tail) {
                    head = tail = current = null;
                    return;
                }
                if (curr == head) head = head.next;
                if (curr == tail) tail = prev;
                prev.next = curr.next;
                if (current == curr) current = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    public void displayTasks() {
        if (head == null) return;
        Task temp = head;
        do {
            System.out.println(temp.name + " (" + temp.priority + ")");
            temp = temp.next;
        } while (temp != head);
    }

    public void nextTask() {
        if (current == null) current = head;
        else current = current.next;
        if (current != null) {
            System.out.println("Current Task: " + current.name);
        }
    }

    public void searchByPriority(int priority) {
        if (head == null) return;
        Task temp = head;
        do {
            if (temp.priority == priority) {
                System.out.println("Found: " + temp.name);
            }
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        task_scheduler ts = new task_scheduler();
        ts.addTask(1, "Fix Bug", 1, "2023-11-01");
        ts.addTask(2, "Write Docs", 2, "2023-11-05");
        ts.displayTasks();
        ts.nextTask();
        ts.nextTask();
        ts.removeTask(1);
    }
}