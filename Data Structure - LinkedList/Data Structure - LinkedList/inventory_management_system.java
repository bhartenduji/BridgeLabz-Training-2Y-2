package Submission_of_Data_Structure_LinkedList;

public class inventory_management_system {

    static class Item {
        int id;
        String name;
        int qty;
        double price;
        Item next;

        Item(int id, String name, int qty, double price) {
            this.id = id;
            this.name = name;
            this.qty = qty;
            this.price = price;
        }
    }

    Item head = null;

    public void addItem(int id, String name, int qty, double price) {
        Item newItem = new Item(id, name, qty, price);
        newItem.next = head;
        head = newItem;
    }

    public void removeItem(int id) {
        if (head == null) return;
        if (head.id == id) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.id != id) {
            temp = temp.next;
        }
        if (temp.next != null) temp.next = temp.next.next;
    }

    public void updateQty(int id, int qty) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.qty = qty;
                return;
            }
            temp = temp.next;
        }
    }

    public void calcTotal() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += (temp.qty * temp.price);
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + total);
    }

    public void sortByName() {
        if (head == null || head.next == null) return;
        boolean swapped;
        do {
            swapped = false;
            Item curr = head;
            while (curr.next != null) {
                if (curr.name.compareTo(curr.next.name) > 0) {
                    int tId = curr.id; String tName = curr.name; int tQty = curr.qty; double tPrice = curr.price;
                    curr.id = curr.next.id; curr.name = curr.next.name; curr.qty = curr.next.qty; curr.price = curr.next.price;
                    curr.next.id = tId; curr.next.name = tName; curr.next.qty = tQty; curr.next.price = tPrice;
                    swapped = true;
                }
                curr = curr.next;
            }
        } while (swapped);
    }

    public void display() {
        Item temp = head;
        while (temp != null) {
            System.out.println(temp.name + " Qty:" + temp.qty + " P:" + temp.price);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        inventory_management_system ims = new inventory_management_system();
        ims.addItem(1, "Laptop", 10, 1000);
        ims.addItem(2, "Mouse", 50, 20);
        ims.updateQty(2, 45);
        ims.sortByName();
        ims.display();
        ims.calcTotal();
    }
}