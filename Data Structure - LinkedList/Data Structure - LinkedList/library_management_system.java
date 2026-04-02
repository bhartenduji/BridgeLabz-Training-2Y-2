package Submission_of_Data_Structure_LinkedList;

public class library_management_system {

    static class Book {
        int id;
        String title;
        String author;
        String genre;
        boolean available;
        Book next, prev;

        Book(int id, String title, String author, String genre, boolean available) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.available = available;
        }
    }

    Book head = null;
    Book tail = null;

    public void addBook(int id, String title, String author, String genre) {
        Book newBook = new Book(id, title, author, genre, true);
        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    public void removeBook(int id) {
        Book temp = head;
        while (temp != null) {
            if (temp.id == id) {
                if (temp == head) head = temp.next;
                if (temp == tail) tail = temp.prev;
                if (temp.prev != null) temp.prev.next = temp.next;
                if (temp.next != null) temp.next.prev = temp.prev;
                return;
            }
            temp = temp.next;
        }
    }

    public void countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total Books: " + count);
    }

    public void display() {
        Book temp = head;
        while (temp != null) {
            System.out.println(temp.title + " by " + temp.author);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        library_management_system lms = new library_management_system();
        lms.addBook(1, "Dune", "Frank Herbert", "Sci-Fi");
        lms.addBook(2, "1984", "George Orwell", "Dystopian");
        lms.display();
        lms.countBooks();
        lms.removeBook(1);
    }
}