students = []

class Student:
    def __init__(self, roll_no, name):
        self.roll_no = roll_no
        self.name = name
        self.present = 0
        self.absent = 0
    
    def get_percentage(self):
        total = self.present + self.absent
        if total == 0:
            return 0
        return (self.present * 100.0) / total

def add_student():
    roll = int(input("Enter Roll No: "))
    name = input("Enter Name: ")
    students.append(Student(roll, name))
    print("Student added successfully!")

def mark_attendance():
    if len(students) == 0:
        print("No students found! Add students first.")
        return
    
    print("\n--- MARK ATTENDANCE ---")
    for s in students:
        status = input(f"{s.roll_no}. {s.name} [P/A]: ")
        if status.upper() == 'P':
            s.present += 1
        else:
            s.absent += 1
    print("Attendance marked!")

def view_students():
    if len(students) == 0:
        print("No students found!")
        return
    
    print("\n--- STUDENT LIST ---")
    print(f"{'Roll No':<10} {'Name':<20}")
    print("--------------------------------")
    for s in students:
        print(f"{s.roll_no:<10} {s.name:<20}")

def view_report():
    if len(students) == 0:
        print("No students found!")
        return
    
    print("\n========== ATTENDANCE REPORT ==========")
    print(f"{'Roll No':<10} {'Name':<20} {'Present':<10} {'Absent':<10} {'Percentage':<12}")
    print("------------------------------------------------------------------")
    
    for s in students:
        print(f"{s.roll_no:<10} {s.name:<20} {s.present:<10} {s.absent:<10} {s.get_percentage():.2f}%")
    print("===========================================")

def main():
    print("===== ATTENDANCE MANAGEMENT SYSTEM =====")
    
    while True:
        print("\n1. Add Student")
        print("2. Mark Attendance")
        print("3. View All Students")
        print("4. View Report")
        print("5. Exit")
        choice = int(input("Enter choice: "))
        
        if choice == 1:
            add_student()
        elif choice == 2:
            mark_attendance()
        elif choice == 3:
            view_students()
        elif choice == 4:
            view_report()
        elif choice == 5:
            print("Thank you!")
            break
        else:
            print("Invalid choice!")

main()