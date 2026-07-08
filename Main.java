import java.util.*;
class Student {
    int rollNo;
    String name;
    int present;
    int absent;
    
    Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
        this.present = 0;
        this.absent = 0;
    }
    
    double getPercentage() {
        int total = present + absent;
        if(total == 0) return 0;
        return (present * 100.0) / total;
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();
    
    public static void main(String[] args) {
        int choice;
        
        System.out.println("===== ATTENDANCE MANAGEMENT SYSTEM =====");
        
        do {
            System.out.println("\n1. Add Student");
            System.out.println("2. Mark Attendance");
            System.out.println("3. View All Students");
            System.out.println("4. View Report");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            
            switch(choice) {
                case 1: addStudent(); break;
                case 2: markAttendance(); break;
                case 3: viewStudents(); break;
                case 4: viewReport(); break;
                case 5: System.out.println("Thank you!"); break;
                default: System.out.println("Invalid choice!");
            }
        } while(choice != 5);
        
        sc.close();
    }
    
    static void addStudent() {
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();
        sc.nextLine(); // buffer clear
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        
        students.add(new Student(roll, name));
        System.out.println("Student added successfully!");
    }
    
    static void markAttendance() {
        if(students.isEmpty()) {
            System.out.println("No students found! Add students first.");
            return;
        }
        
        System.out.println("\n--- MARK ATTENDANCE ---");
        for(Student s : students) {
            System.out.print(s.rollNo + ". " + s.name + " [P/A]: ");
            char status = sc.next().charAt(0);
            
            if(status == 'P' || status == 'p') {
                s.present++;
            } else {
                s.absent++;
            }
        }
        System.out.println("Attendance marked!");
    }
    
    static void viewStudents() {
        if(students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }
        
        System.out.println("\n--- STUDENT LIST ---");
        System.out.printf("%-10s %-20s\n", "Roll No", "Name");
        System.out.println("--------------------------------");
        for(Student s : students) {
            System.out.printf("%-10d %-20s\n", s.rollNo, s.name);
        }
    }
    
    static void viewReport() {
        if(students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }
        
        System.out.println("\n========== ATTENDANCE REPORT ==========");
        System.out.printf("%-10s %-20s %-10s %-10s %-12s\n", "Roll No", "Name", "Present", "Absent", "Percentage");
        System.out.println("------------------------------------------------------------------");
        
        for(Student s : students) {
            System.out.printf("%-10d %-20s %-10d %-10d %.2f%%\n", 
                s.rollNo, s.name, s.present, s.absent, s.getPercentage());
        }
        System.out.println("===========================================");
    }
}

