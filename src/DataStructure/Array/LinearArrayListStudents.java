package DataStructure.Array;

class LinearArrayListStudents        {

    Student[] students;
    int StudentsNumber;

    public LinearArrayListStudents(int MaxSize) {
        students = new Student[MaxSize];
        StudentsNumber = 0;
    }
    void insert(Student x) {
        if (StudentsNumber < students.length) {
            for (int i = 0; i < students.length; i++) {
                if (students[i] == null) {
                    students[i] = x;
                    break;
                }
            }
            StudentsNumber++;
        } else {
            System.out.println("DataStructure.Array is full");
        }
    }
    int linearSearch(Student x){
        for(int i = 0; i < students.length; i++){
            if(students[i] != null && students[i].equals(x)){
                return i;
            }
        }
        return -1;
    }
    void delete(Student x) {
        int pos = linearSearch(x);

        if (pos != -1) {
            students[pos] = null;
            StudentsNumber--;
        } else {
            System.out.println("Student not found");
        }
    }
    public void displayArray()
    {
        // print the array
        System.out.print("DataStructure.Array: ");
        for(int i = 0; i < students.length; i++)
            if(students[i]!=null)
                System.out.print(students[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        LinearArrayListStudents a = new LinearArrayListStudents(10);
        a.insert(new Student("Timmy", "Turner", 1));
        a.insert(new Student("Harry", "Potter", 2));
        a.insert(new Student("Peter", "Parker", 3));
        a.insert(new Student("Jack", "Sparrow", 4));
        a.displayArray();
        System.out.println("Count: " + a.StudentsNumber);
        System.out.println("Position of Harry: " + a.linearSearch(new Student("Harry", "Potter", 2)));
        a.delete(new Student("Hermione", "Granger", 5)); // Should print "Element not found!"
        a.delete(new Student("Harry", "Potter", 2)); // Should successfully delete Harry Potter
        System.out.println("Count: " + a.StudentsNumber);
        a.displayArray();
        System.out.println("Position of Harry: " + a.linearSearch(new Student("Harry", "Potter", 2))); // Should return -1 as Harry is deleted
    }

}