import java.util.ArrayList;

public class Course {
    public String courseName;
    public String courseCode;

    public int studentCount;
    public int courseCredit;
    public Professor professor;
    public ArrayList<Item> requiredMaterials;
    public ArrayList<Student> roster;

    // default constructor
    public Course(String courseName, String courseCode, Professor courseProfessor, ArrayList<Item> requiredMaterials, int creditAmount, ArrayList<Student> roster){
        this.requiredMaterials = requiredMaterials;
        setCourseCode(courseCode);
        setCourseName(courseName);
        setCourseCredit(creditAmount);
        //roster can be nil
        setRoster(roster);

        this.studentCount = roster.size();
    }

    // credit functions
    public int getCourseCredit(){
        return this.courseCredit;
    }

    public void setCourseCredit(int creditAmount){
        this.courseCredit = creditAmount;
    }

    // roster functions
    public ArrayList<Student> getRoster(){
        return roster;
    }

    public void setRoster(ArrayList<Student> roster){
        this.roster = roster;
    }

    // required materials functions
    public ArrayList<Item> getRequiredMaterials(){
        return this.requiredMaterials;
    }

    public void setRequiredMaterials(ArrayList<Item> requiredMaterials){
        //assuming requiredMaterials extends to not only books
        this.requiredMaterials = requiredMaterials;
    }

    // course name functions
    public String getCourseName(){
        return courseName;
    }

    public void setCourseName(String courseName){
        this.courseName = courseName;
    }

    // course code functions
    public String getCourseCode(){
        return courseCode;
    }

    public void setCourseCode(String courseCode){
        this.courseCode = courseCode;
    }

    // professor functions
    public void setProfessor(Professor professor){
        this.professor = professor;
    }

    public Professor getProfessor(){
        return professor;
    }

}
