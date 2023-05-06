import java.util.ArrayList;
import java.time.LocalDate;

public class Professor extends Member{
    private ArrayList<Course> courses;
    private ArrayList<Student> students;

    public Professor(String name, LocalDate dob, String email, int memberId, String address, long ssn){
        this.setName(name);
        this.setDateOfBirth(dob);
        this.setEmail(email);
        this.setMemberId(memberId);
        this.setAddress(address);
        this.setSSN(ssn);
        this.setBalance(0.0f);
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }

    public void removeCourse(Course course){
        this.courses.remove(course);
    }

    public ArrayList<Course> getCourses(){
        return this.courses;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    public void removeStudent(Student student){
        this.students.remove(student);
    }

    public ArrayList<Student> getStudents(){
        return this.students;
    }
}