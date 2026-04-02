package Submission_of_Data_Structure_LinkedList;

public class round_robin_scheduling {

    static class Process {
        int pid;
        int burstTime;
        int priority;
        int remainingTime;
        int waitTime;
        int turnAroundTime;
        Process next;

        Process(int pid, int burstTime, int priority) {
            this.pid = pid;
            this.burstTime = burstTime;
            this.remainingTime = burstTime;
            this.priority = priority;
            this.waitTime = 0;
            this.turnAroundTime = 0;
        }
    }

    Process head = null;
    Process tail = null;

    public void addProcess(int pid, int burstTime, int priority) {
        Process newP = new Process(pid, burstTime, priority);
        if (head == null) {
            head = tail = newP;
            tail.next = head;
        } else {
            tail.next = newP;
            tail = newP;
            tail.next = head;
        }
    }

    public void simulate(int timeQuantum) {
        if (head == null) return;
        Process curr = head;
        Process prev = tail;
        int currentTime = 0;

        while (head != null) {
            if (curr.remainingTime > timeQuantum) {
                curr.remainingTime -= timeQuantum;
                currentTime += timeQuantum;
                prev = curr;
                curr = curr.next;
            } else {
                currentTime += curr.remainingTime;
                curr.waitTime = currentTime - curr.burstTime;
                curr.turnAroundTime = currentTime;
                System.out.println("P" + curr.pid + " Finished. WT:" + curr.waitTime + " TAT:" + curr.turnAroundTime);
                
                if (curr == head && curr == tail) {
                    head = tail = null;
                    break;
                }
                if (curr == head) head = head.next;
                if (curr == tail) tail = prev;
                prev.next = curr.next;
                curr = curr.next;
            }
        }
    }

    public static void main(String[] args) {
        round_robin_scheduling rrs = new round_robin_scheduling();
        rrs.addProcess(1, 10, 1);
        rrs.addProcess(2, 5, 2);
        rrs.addProcess(3, 8, 1);
        rrs.simulate(3);
    }
}