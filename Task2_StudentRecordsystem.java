import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id, marks;
    String name;

    Student(int id, String n, int m) {
        this.id = id;
        this.name = n;
        this.marks = m;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int m) {
        this.marks = m;
    }

    public String toString() {
        return "\nID: " + id + "\nName: " + name + "\nMarks: " + marks + "\n";
    }
}

public class Task2_StudentRecordsystem {

    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        while (true) {
            System.out.println("\n*** Student Record Management ***");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you for using our software.");
                    return;
                default:
                    System.out.println("Enter a valid choice.");
                    break;
            }
        }
    }

    public static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        int marks = sc.nextInt();

        studentList.add(new Student(id, name, marks));
        System.out.println(" New student added successfully.");
    }

    public static void viewStudent() {
        if (studentList.isEmpty()) {
            System.out.println(" No students found.");
            return;
        }

        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    public static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine(); 

        for (Student s : studentList) {
            if (s.getId() == id) {
                System.out.print("Enter New Name: ");
                String name = sc.nextLine();

                System.out.print("Enter New Marks: ");
                int marks = sc.nextInt();

                s.setName(name);
                s.setMarks(marks);

                System.out.println(" Student data updated successfully.");
                return;
            }
        }

        System.out.println(" Student not found.");
    }

    public static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                studentList.remove(i);
                System.out.println(" Student data deleted successfully.");
                return;
            }
        }

        System.out.println(" Student not found.");
    }
}
