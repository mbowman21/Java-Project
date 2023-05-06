import java.util.ArrayList;
import java.time.LocalDate;

public class Student extends Member{
    protected int studentId;
    protected ArrayList<Course> courses;

    public Student(String name, LocalDate DOB, String studentEmail, int id, String address, long ssn){
        setName(name);
        setDateOfBirth(DOB);
        setEmail(studentEmail);
        setMemberId(id);
        setAddress(address);
        setSSN(ssn);
        setBalance(0.0f);
    }

    public void addCourse(Course course){
        courses.add(course);
    }

    public void removeCourse(Course course){
        //add catch for if a course does not exist
        courses.remove(course);
    }

    // public int getStudentId(){
    //     return this.studentId;
    // }

    // public void setStudentId(int studentId){
    //     this.studentId = studentId;
    // }
}
