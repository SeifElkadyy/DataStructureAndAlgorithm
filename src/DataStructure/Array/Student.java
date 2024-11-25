package DataStructure.Array;

class Student {
    String firstName, lastName;
    int id;

    public Student(String f, String l, int id) {
        firstName = f;
        lastName = l;
        this.id = id;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", ID:" + id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id == student.id;
    }
}