import java.util.ArrayList;
import java.util.Date;

public class Student extends Member{
    protected int studentId;
    protected ArrayList<Course> courses;

    public Student(String name, Date DOB, String studentEmail, int studentId, String address, long ssn){
        setName(name);
        setDateOfBirth(DOB);
        setEmail(studentEmail);
        setStudentId(studentId);
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

    public int getStudentId(){
        return this.studentId;
    }

    public void setStudentId(int studentId){
        this.studentId = studentId;
    }
}
