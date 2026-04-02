package Submission_of_Data_Structure_LinkedList;

public class movie_management_system {

    static class Movie {
        String title;
        String director;
        int year;
        double rating;
        Movie next, prev;

        Movie(String title, String director, int year, double rating) {
            this.title = title;
            this.director = director;
            this.year = year;
            this.rating = rating;
        }
    }

    Movie head = null;
    Movie tail = null;

    public void addLast(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    public void removeByTitle(String title) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                if (temp == head) head = temp.next;
                if (temp == tail) tail = temp.prev;
                if (temp.prev != null) temp.prev.next = temp.next;
                if (temp.next != null) temp.next.prev = temp.prev;
                return;
            }
            temp = temp.next;
        }
    }

    public void searchByDirector(String director) {
        Movie temp = head;
        while (temp != null) {
            if (temp.director.equals(director)) {
                System.out.println(temp.title + " " + temp.rating);
            }
            temp = temp.next;
        }
    }

    public void displayForward() {
        Movie temp = head;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.rating);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        Movie temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.rating);
            temp = temp.prev;
        }
    }

    public void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = newRating;
                return;
            }
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        movie_management_system mms = new movie_management_system();
        mms.addLast("Inception", "Nolan", 2010, 8.8);
        mms.addLast("Avatar", "Cameron", 2009, 7.8);
        mms.displayForward();
        mms.displayReverse();
        mms.updateRating("Avatar", 8.0);
        mms.removeByTitle("Inception");
    }
}