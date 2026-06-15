import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class StudentRecord {

    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    private static void addStudent() {
        System.out.println("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student st : students) {
        if (st.getId() == id) {
            System.out.println("Error: Student ID already exists! Please enter a unique ID.");
            return;
        }
    }

        System.out.println("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.println("Enter Student Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully.");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found!!!");
        } else {
            System.out.println("\nStudent List: ");
            for (Student st : students) {
                System.out.println(st);
            }
        }
    }

    private static void updateStudent() {
        System.out.println("Enter Student ID to update record: ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean found = false;

        for (Student st : students) {
            if (st.getId() ==  id) {
                System.out.println("Enter new name: ");
                String name = sc.nextLine();

                System.out.println("Enter new marks: ");
                double marks = sc.nextDouble();
                
                st.setName(name);
                st.setMarks(marks);
                System.out.println("Details updated successfully.");

                found = true;
                break;
            } 
        }
        if (!found) {
            System.out.println("Student not found!!!");
        }
    }

    private static void deleteStudent() {
        System.out.println("Enter Student ID to delete record: ");
        int id = sc.nextInt();

        boolean found = false;

        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student st = it.next();
            if (st.getId() == id) {
                it.remove();
                System.out.println("Student record delete successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found!!!");
        }

    }

    public static void main(String[] args) {
        boolean exit = false;
        System.out.println("<--- Welcome to Student Record Management System --->");

        while (!exit) {
            System.out.println("Select an option to perform task.");
            System.out.println("1. Add Student Record.");
            System.out.println("2. View Students Record.");
            System.out.println("3. Update Student Record.");
            System.out.println("4. Delete Student Record.");
            System.out.println("5. Exit.");

            System.out.print("Enter your choice---: ");

            if (sc.hasNextInt()) {
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                        case 1: 
                            addStudent();
                            break;
                        
                        case 2: 
                            viewStudents();
                            break;
                        
                        case 3: 
                            updateStudent();
                            break;

                        case 4: 
                            deleteStudent();
                            break;

                        case 5 : 
                            exit = true;
                            break;

                        default: 
                            System.out.println("Invalid choice, Please select a valid choice!");
                            break;
                    }
                    System.out.println("-----------------------------------------");
            } else {
                System.out.println("Invalid choice, Please select a valid choice!");
                sc.next();
                continue;
            }

        }
    }
    
}