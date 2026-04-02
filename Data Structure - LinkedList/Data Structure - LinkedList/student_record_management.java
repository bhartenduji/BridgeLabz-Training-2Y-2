package Submission_of_Data_Structure_LinkedList;

public class student_record_management {

    static class Student {
        int rollNumber;
        String name;
        int age;
        String grade;
        Student next;

        Student(int rollNumber, String name, int age, String grade) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.age = age;
            this.grade = grade;
            this.next = null;
        }
    }

    Student head = null;

    public void addFirst(int roll, String name, int age, String grade) {
        Student newStudent = new Student(roll, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    public void addLast(int roll, String name, int age, String grade) {
        Student newStudent = new Student(roll, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    public void deleteByRoll(int roll) {
        if (head == null) return;
        if (head.rollNumber == roll) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != roll) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public void search(int roll) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) {
                System.out.println("Found: " + temp.name + " (" + temp.grade + ")");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Not Found");
    }

    public void display() {
        Student temp = head;
        while (temp != null) {
            System.out.println(temp.rollNumber + " " + temp.name + " " + temp.age + " " + temp.grade);
            temp = temp.next;
        }
    }

    public void updateGrade(int roll, String newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == roll) {
                temp.grade = newGrade;
                return;
            }
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        student_record_management srm = new student_record_management();
        srm.addFirst(101, "Alice", 20, "A");
        srm.addLast(102, "Bob", 21, "B");
        srm.display();
        srm.updateGrade(102, "A");
        srm.search(102);
        srm.deleteByRoll(101);
    }
}