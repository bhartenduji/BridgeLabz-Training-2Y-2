package Submission_of_Data_Structure_LinkedList;

public class ticket_reservation_system {

    static class Ticket {
        int id;
        String customer;
        String movie;
        int seat;
        String time;
        Ticket next;

        Ticket(int id, String customer, String movie, int seat, String time) {
            this.id = id;
            this.customer = customer;
            this.movie = movie;
            this.seat = seat;
            this.time = time;
        }
    }

    Ticket head = null;
    Ticket tail = null;

    public void addTicket(int id, String cust, String movie, int seat, String time) {
        Ticket t = new Ticket(id, cust, movie, seat, time);
        if (head == null) {
            head = tail = t;
            tail.next = head;
        } else {
            tail.next = t;
            tail = t;
            tail.next = head;
        }
    }

    public void removeTicket(int id) {
        if (head == null) return;
        Ticket curr = head;
        Ticket prev = tail;
        do {
            if (curr.id == id) {
                if (curr == head && curr == tail) {
                    head = tail = null;
                    return;
                }
                if (curr == head) head = head.next;
                if (curr == tail) tail = prev;
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    public void display() {
        if (head == null) return;
        Ticket temp = head;
        int count = 0;
        do {
            System.out.println("TID:" + temp.id + " Cust:" + temp.customer + " Seat:" + temp.seat);
            count++;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Total Booked: " + count);
    }

    public static void main(String[] args) {
        ticket_reservation_system trs = new ticket_reservation_system();
        trs.addTicket(101, "Alice", "Matrix", 12, "10:00AM");
        trs.addTicket(102, "Bob", "Matrix", 13, "10:00AM");
        trs.display();
        trs.removeTicket(101);
        trs.display();
    }
}